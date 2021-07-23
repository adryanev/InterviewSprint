package dev.adryanev.sprint.interviewsprint.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import dagger.hilt.android.AndroidEntryPoint
import dev.adryanev.sprint.interviewsprint.R
import dev.adryanev.sprint.interviewsprint.databinding.ActivityMainBinding
import dev.adryanev.sprint.interviewsprint.ui.base.BaseActivity
import dev.adryanev.sprint.interviewsprint.ui.base.BaseViewModel
@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding,BaseViewModel>() {
    override val viewModel: BaseViewModel by viewModels()
    override val layoutId: Int
        get() = R.layout.activity_main

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val toolbar = viewBinding.toolbarMain

        navController = findNavController(R.id.nav_host_fragment)
        val appBarConfiguration = AppBarConfiguration(
            setOf(R.id.destinationFragment, R.id.hotelFragment)
        )

        navController.let {
            toolbar.setupWithNavController(it, appBarConfiguration)

        }
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}