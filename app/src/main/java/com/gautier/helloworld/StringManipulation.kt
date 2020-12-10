package com.gautier.helloworld

import android.icu.util.Calendar
import android.os.Build
import androidx.annotation.RequiresApi
import java.util.*

class StringManipulation(var firstName: String, var lastName: String, var choice: Int) {

    lateinit var namesResult: String

    @RequiresApi(Build.VERSION_CODES.N)
    fun capitalizeNames(): String {
        firstName = cassing(firstName)
        lastName = cassing(lastName)
        whileLoop()
        when(choice) {
            1 -> namesResult = firstLast()
            2 -> namesResult = lastFirst()
            3 -> namesResult = reverse()
        }
        return namesResult
    }

    private fun cassing(name: String): String {
        var cassingName = ""
        for(i in name.indices)
            if(name[i].isUpperCase() && i != 0) {
                cassingName += name[i].toLowerCase()
            }
            else if(i == 0) {
                cassingName += name[0].toUpperCase()
            }
            else {
                cassingName += name[i]
            }
        return cassingName
    }

    private fun firstLast(): String {
        return "$firstName $lastName"
    }

    private fun lastFirst(): String {
        return "$lastName $firstName"
    }

    private fun reverse(): String {
        val fullName = "$firstName $lastName"
        var reverseName = ""
        for(i in fullName.indices) {
            reverseName += fullName[(fullName.length-i)-1]
        }
        return reverseName
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun whileLoop() {
        var calendar: Calendar = Calendar.getInstance()
        val longCalendar: Long = calendar.timeInMillis+10000
        while(calendar.timeInMillis != longCalendar) {
            calendar = Calendar.getInstance()
        }
    }
}