package dev.adryanev.sprint.interviewsprint.ui.base

import android.widget.Toast

interface BaseView {
    fun showMessage(message: String, length: Int = Toast.LENGTH_SHORT)
    fun showSnack(message: String, actionTitle: String, action: () -> Unit)
}