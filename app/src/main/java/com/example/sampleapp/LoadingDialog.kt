package com.example.sampleapp

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment

import androidx.navigation.Navigation

class LoadingDialog(private var fragment: Fragment) {
    private lateinit var alterDialog: AlertDialog

    @SuppressLint("SuspiciousIndentation", "InflateParams")
    fun startDialog(b: Boolean) {
        val builder = AlertDialog.Builder(fragment.requireContext())
        val inflate = fragment.layoutInflater
        builder.setView(inflate.inflate(R.layout.activity_progress_bar, null))
            .setCancelable(true)
        alterDialog = builder.create()
        alterDialog.show()
        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed({
            alterDialog.dismiss()
            showDialogMessage(b)
        }, 2000)

    }

    @SuppressLint("InflateParams")
    fun startLoginDialog(b: Boolean) {
        val builder = AlertDialog.Builder(fragment.requireContext())
        val inflate = fragment.layoutInflater
        builder.setView(inflate.inflate(R.layout.activity_progress_bar, null))
            .setCancelable(true)
        alterDialog = builder.create()
        alterDialog.show()
        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed({
            alterDialog.dismiss()
            showDialogLoginMessage(b)
        }, 2000)

    }

    private fun showDialogMessage(b: Boolean) {
        val message = if (b) "Success" else "Not success"
        val builder = AlertDialog.Builder(fragment.requireContext())
        builder.setMessage(message).setCancelable(false)
            .setPositiveButton("Ok") { _: DialogInterface?, _: Int ->
                redirectToLoginPage()
            }
        val r = builder.create()
        r.show()
    }

    private fun showDialogLoginMessage(b: Boolean) {
        val message = if (b) "Success" else "Not success"
        val builder = AlertDialog.Builder(fragment.requireContext())
        builder.setMessage(message).setCancelable(false)
            .setPositiveButton("Ok") { _: DialogInterface?, _: Int ->
                if (b) {
                    redirectToDashboard()
                }
            }
        val r = builder.create()
        r.show()
    }

    private fun redirectToLoginPage() {
        val navController =
            Navigation.findNavController(fragment.requireActivity(), R.id.navHostFragmentView)
        navController.navigate(R.id.action_register_to_login)
    }

    private fun redirectToDashboard() {
        val navController =
            Navigation.findNavController(fragment.requireActivity(), R.id.navHostFragmentView)
        navController.navigate(
            R.id.action_login_to_dashboard4
        )
    }

}