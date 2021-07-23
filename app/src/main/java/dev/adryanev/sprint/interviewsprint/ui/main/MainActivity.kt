package dev.adryanev.sprint.interviewsprint.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
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

}