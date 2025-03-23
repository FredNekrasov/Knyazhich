package com.fredprojects.core.ui

import android.content.Context
import android.widget.Toast
import androidx.annotation.StringRes

// Knyazhich extensions
fun Context.toast(message: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, duration).show()
}
/**
 * Отображение тоста.
 * @param messageId идентификатор строки из ресурсов. Например, R.string.some_string
 * @param duration длительность тоста
 */
fun Context.toast(
    @StringRes messageId: Int,
    duration: Int = Toast.LENGTH_SHORT
) = toast(getString(messageId), duration)
