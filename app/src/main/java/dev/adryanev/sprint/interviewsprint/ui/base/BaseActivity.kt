package dev.adryanev.sprint.interviewsprint.ui.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import dev.adryanev.sprint.interviewsprint.BR


abstract class BaseActivity<ViewBinding : ViewDataBinding, ViewModel : BaseViewModel> :
    AppCompatActivity() {

    protected lateinit var viewBinding: ViewBinding
    protected abstract val viewModel: ViewModel

    @get:LayoutRes
    protected abstract val layoutId: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = DataBindingUtil.setContentView(this, layoutId)
        viewBinding.apply {
            setVariable(BR.viewModel, viewModel)
            viewBinding.lifecycleOwner = this@BaseActivity
            root.isClickable = true
            executePendingBindings()
        }
    }


}