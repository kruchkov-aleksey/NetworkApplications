package com.example.networkapplications

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatDialogFragment

class DialogNotification: AppCompatDialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder: AlertDialog.Builder = AlertDialog.Builder(activity)
        builder.setMessage(R.string.dialog_message)
            .setPositiveButton(R.string.ok) { dialog, which ->
                dialog.cancel()
            }
        return builder.create()
    }
}