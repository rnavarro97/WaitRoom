package com.revature.waitroom

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.DatePicker
import android.widget.TimePicker
import com.revature.waitroom.databinding.ActivityDateAndTimePickerBinding
import com.revature.waitroom.R
import java.util.*

class DateAndTimePicker : AppCompatActivity(/*R.layout.activity_main*/),
    DatePickerDialog.OnDateSetListener,
    TimePickerDialog.OnTimeSetListener {

    var month = 0
    var day = 0
    var year = 0
    var hour = 0
    var minute = 0

    //I kind of wonder why these shouldn't be remembered by mutableStateOf("")
    var savedMonth = 0
    var savedDay = 0
    var savedYear = 0
    var savedHour = 0
    var savedMinute = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_date_and_time_picker)

        pickDate()
    }

    private fun getDateTimeCalendar(){
        val cal = Calendar.getInstance()
        day = cal.get(Calendar.DAY_OF_MONTH)
        month = cal.get(Calendar.MONTH)
        year = cal.get(Calendar.YEAR)
        hour = cal.get(Calendar.HOUR)
        minute = cal.get(Calendar.MINUTE)
    }

    private fun pickDate(){

        /*Working around deprecated methods to call views we declared in layout
        and setting an On Click Listener for that button*/
        var startBinding //example used lateinit, test this
                = ActivityDateAndTimePickerBinding.inflate(layoutInflater)
        startBinding.btnTimePicker.setOnClickListener{

            Log.d("CLICKED","Button was clicked")
            //fetches the method we declared earlier...
            getDateTimeCalendar()

            //...and feeds them to the Date Picker Dialog
            DatePickerDialog(this,
                this,
                year,
                month,
                day).show()
        }
    }


    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        savedDay = dayOfMonth
        savedMonth = month
        savedYear = year

        getDateTimeCalendar()
        TimePickerDialog(this,
            this,
            hour,
            minute,
            true).show()
    }

    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
        savedHour = hourOfDay
        savedMinute = minute

        var endBinding:ActivityDateAndTimePickerBinding
                = ActivityDateAndTimePickerBinding.inflate(layoutInflater)
        endBinding.tvTextTime.text = "$savedMonth-$savedDay-$savedYear\n"+
                "$savedHour:$savedMinute"
    }


}

