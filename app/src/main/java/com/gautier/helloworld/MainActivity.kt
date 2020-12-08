package com.gautier.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var firstNameEdit: EditText
    private lateinit var lastNameEdit: EditText
    private lateinit var namesText: TextView
    private lateinit var firstLateButton: Button
    private lateinit var lateFirstButton: Button
    private lateinit var reverseButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        addNames()
        firstLateButton.setOnClickListener {
            namesText.text = getNames(1)
        }
        lateFirstButton.setOnClickListener {
            namesText.text = getNames(2)
        }
        reverseButton.setOnClickListener {
            namesText.text = getNames(3)
        }
    }

    fun addNames() {
        namesText.text = "Bonjour!"
    }

    fun getNames(choice: Int): String {
        val firstName = testCapitalize(firstNameEdit.text.toString())
        val lastName = testCapitalize(lastNameEdit.text.toString())
        lateinit var namesResult: String

        when(choice) {
            1 -> namesResult = firstLast(firstName, lastName)
            2 -> namesResult = lastFirst(firstName, lastName)
            3 -> namesResult = reverse(firstName, lastName)
        }
        return namesResult
    }

    private fun firstLast(firstName: String, lastName: String): String {
        return "$firstName $lastName"
    }

    private fun lastFirst(firstName: String, lastName: String): String {
        return "$lastName $firstName"
    }

    private fun reverse(firstName: String, lastName: String): String {
        var fullName = "$firstName $lastName"
        var reverseName = ""
        for(i in 1..fullName.length) {
            reverseName += fullName[fullName.length-i]
        }
        return reverseName
    }

    private fun testCapitalize(name: String): String {
        var capitalizeName = ""
        for(i in name.indices)
            if(name[i].isUpperCase() && i != 0) {
                capitalizeName += name[i].toLowerCase()
            }
            else if(i == 0) {
                capitalizeName += name[0].toUpperCase()
            }
            else {
                capitalizeName += name[i]
            }
        return capitalizeName
    }

    fun initViews() {
        firstNameEdit = findViewById(R.id.editTextTextPersonName3)
        lastNameEdit = findViewById(R.id.editTextTextPersonName4)
        namesText = findViewById(R.id.textView)
        firstLateButton = findViewById(R.id.button)
        lateFirstButton = findViewById(R.id.button2)
        reverseButton = findViewById(R.id.button3)
    }
}