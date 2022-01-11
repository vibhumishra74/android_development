package com.example.ageinminutes

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var buttonclick = findViewById<Button>(R.id.btnDatePicker)
        buttonclick.setOnClickListener {view ->
            clickDatePicker(view)

        }
    }
    fun clickDatePicker(view: View) {
        val myCalendar = Calendar.getInstance()
        var SelectedDatetext = findViewById<TextView>(R.id.SelectedDate)
        var selectedTimeInMinute = findViewById<TextView>(R.id.SelectedDateInMinute)
        var selectedTimeInDays = findViewById<TextView>(R.id.SelectedDateInDays)
        val year = myCalendar.get(Calendar.YEAR)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)
        val month = myCalendar.get(Calendar.MONTH)
       var dpd = DatePickerDialog(this,DatePickerDialog.OnDateSetListener { view, Selectedyear, Selectedmonth, SelecteddayOfMonth ->
            val selectedDate = "$SelecteddayOfMonth/${Selectedmonth+1}/$Selectedyear"
            SelectedDatetext.setText(selectedDate)
            val SelectedDateFormate = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
            val theDate = SelectedDateFormate.parse(selectedDate)
//        Toast.makeText(this, "button work $selectedDate", Toast.LENGTH_SHORT).show()
            val selectedDateInMinute = theDate!!.time/60000
            val currentDate = SelectedDateFormate.parse(SelectedDateFormate.format(System.currentTimeMillis()))
            val currentTimeInMinute = currentDate!!.time/60000
            val differenceOfTime = currentTimeInMinute - selectedDateInMinute
           val differenceOfDays = differenceOfTime/1440
            selectedTimeInMinute.setText(differenceOfTime.toString())
           selectedTimeInDays.setText(differenceOfDays.toString())
        },year,month,day)
        dpd.datePicker.setMaxDate(Date().time - 86400000)
        dpd.show()

    }
}