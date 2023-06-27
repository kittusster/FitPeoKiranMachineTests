package com.example.FitpeoKiranMachineTest.views

import android.app.Activity
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import com.example.FitpeoKiranMachineTest.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class WaitDialog(private val context: Activity) : MaterialAlertDialogBuilder(context) {
    private var waitDialogBox: Dialog

    init {
        val view = LayoutInflater.from(context).inflate(R.layout.layout_wait, null)
        setView(view)
        background = ColorDrawable(Color.TRANSPARENT)
        setCancelable(false)
        waitDialogBox = create()
    }

    fun showDialog() {
        context.runOnUiThread { waitDialogBox.show() }
    }

    fun dismiss() {
        Handler(Looper.getMainLooper()).postDelayed({
            waitDialogBox.dismiss()
        }, 500)
    }
}