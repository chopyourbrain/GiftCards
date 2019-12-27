package com.example.giftcards.util.extensions

import android.content.DialogInterface
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment

object Progress {
    var dialogProgress: ProgressDialogMain? = null
}

fun Fragment.showProgressDialog() {
    hideProgressDialog()
    Progress.dialogProgress = ProgressDialogMain()
    this.fragmentManager?.let {
        Progress.dialogProgress?.show(
            it,
            ProgressDialogMain::class.java.simpleName
        )
    }
}

fun Fragment.hideProgressDialog() {
    try {
        Progress.dialogProgress?.dismiss()
        Progress.dialogProgress = null
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

fun Fragment.showError(error: String, listener: DialogInterface.OnClickListener? = null) {
    if (isAdded)
        context?.let {
            AlertDialog.Builder(it)
                .setTitle("")
                .setMessage(error)
                .setPositiveButton("", listener)
                .show()
        }
}