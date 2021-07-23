package dev.adryanev.sprint.interviewsprint.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.google.android.material.snackbar.Snackbar
import dev.adryanev.sprint.interviewsprint.utils.dismissLoadingDialog
import dev.adryanev.sprint.interviewsprint.utils.showLoadingDialog
import dev.adryanev.sprint.interviewsprint.BR



abstract class BaseFragment<ViewBinding : ViewDataBinding, ViewModel : BaseViewModel> : Fragment(),
    BaseView {

    protected lateinit var viewBinding: ViewBinding
    protected abstract val viewModel: ViewModel


    @get:LayoutRes
    protected abstract val layoutId: Int

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        viewBinding.apply {
            setVariable(BR.viewModel, viewModel)
            lifecycleOwner = viewLifecycleOwner
            root.isClickable = true
            executePendingBindings()
        }

        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeEvent()
    }

    fun observeEvent() {
        viewModel.apply {
            isLoading.observe(viewLifecycleOwner, {
                handleLoading(it == true)
            })
            errorMessage.observe(viewLifecycleOwner, {
                handleErrorMessage(it)
            })
        }
    }

    protected open fun handleLoading(isLoading: Boolean) {
        if (isLoading) showLoadingDialog() else dismissLoadingDialog()
    }

    protected open fun handleErrorMessage(message: String?) {
        if (message.isNullOrBlank()) return
        dismissLoadingDialog()
        showMessage(
            message = message,
        )
    }

    fun navigateUp() {
        getNavController()?.navigateUp()
    }

    private var toast: Toast? = null
    override fun showMessage(message: String, length: Int) {
        toast?.cancel()
        toast = Toast.makeText(requireContext(), message, length).also {
            it.show()
        }
    }

    private var snack: Snackbar? = null
    override fun showSnack(message: String, actionTitle: String, action: () -> Unit) {
        snack?.dismiss()
        snack = Snackbar.make(requireView(), message, Snackbar.LENGTH_INDEFINITE)
            .setAction(actionTitle) {
                action.invoke()
            }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        snack?.dismiss()
    }

    fun launchOnLifecycleScope(execute: suspend () -> Unit) {
        viewLifecycleOwner.lifecycleScope.launchWhenCreated {
            execute()
        }
    }


}

fun Fragment.getNavController(): NavController? {
    return try {
        NavHostFragment.findNavController(this)
    } catch (e: IllegalStateException) {
        null
    }
}