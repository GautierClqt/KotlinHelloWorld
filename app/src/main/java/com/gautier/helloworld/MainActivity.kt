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
            getNames(1)
        }
        lateFirstButton.setOnClickListener {
            getNames(2)
        }
        reverseButton.setOnClickListener {
            getNames(3)
        }
    }

    fun addNames() {
        namesText.text = "Bonjour!"
    }

    fun getNames(choice: Int) {
        val stringManipulation = StringManipulation(firstNameEdit.text.toString(), lastNameEdit.text.toString(), choice)
        namesText.text = stringManipulation.capitalizeNames()
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