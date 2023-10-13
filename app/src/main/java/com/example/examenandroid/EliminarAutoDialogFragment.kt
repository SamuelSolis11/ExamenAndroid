package com.example.examenandroid

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.DialogFragment

class EliminarAutoDialogFragment(val auto: Auto, val function: (Auto) -> Unit) : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        Log.d("Eliminate auto","EliminarAutoDialogFragment.onCreateDialog")
        return activity?.let {
            // Use the Builder class for convenient dialog construction
            val builder = AlertDialog.Builder(it)
            builder.setMessage(getString(R.string.delete_car_message)+ ":" + auto.nombre + "?")
                .setPositiveButton("Yes",
                    DialogInterface.OnClickListener { dialog, id ->
                        Singleton.lista.remove(auto)
                        function(auto)
                    })
                .setNegativeButton("No",
                    DialogInterface.OnClickListener { dialog, id ->
                        // User cancelled the dialog
                    })
            // Create the AlertDialog object and return it
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}