package com.example.ch10_notification

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.widget.DatePicker
import android.widget.TimePicker
import androidx.activity.ComponentActivity
import androidx.activity.result.contract.ActivityResultContracts
import com.example.ch10_notification.databinding.ActivityMainBinding

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val requestPermissionLauncher = registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) {isGranted ->
            if (isGranted) {
                Log.d("event", "callback, granted..")
            } else {
                Log.d("event", "callback, denied..")
            }
        }

        requestPermissionLauncher.launch("android.permission.ACCESS_FINE_LOCATION")

        val dateLog = DatePickerDialog(this, object: DatePickerDialog.OnDateSetListener{
            override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
                Log.d("event", "year : $year, month: ${month+1}, day: $dayOfMonth")
            }
        }, 2024, 0, 1)

        dateLog.show()

        val timePickerDialog = TimePickerDialog(this, object:TimePickerDialog.OnTimeSetListener{
            override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
                Log.d("event", "time : $hourOfDay, minute : $minute")
            }
        }, 15, 0, true)

        timePickerDialog.show()

        val eventHandler = object : DialogInterface.OnClickListener {
            override fun onClick(dialog: DialogInterface?, which: Int) {
                if (which == DialogInterface.BUTTON_POSITIVE){
                    Log.d("event", "Positive Button click")
                } else if (which == DialogInterface.BUTTON_NEGATIVE){
                    Log.d("event", "Negative Button click")
                }
            }
        }

        AlertDialog.Builder(this).run {
            setTitle("text dialog")
            setIcon(android.R.drawable.ic_dialog_info)
            setMessage("정말로 종료하시겠습니까?")
            setPositiveButton("OK",eventHandler)
            setNegativeButton("Cancel", eventHandler)
            setNeutralButton("More", null)
            show()
        }




    }
}