package com.glownia.maciej.readcsvfile

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.io.BufferedReader
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Create an object of InputStreamReader
        val input = InputStreamReader(assets.open("status_reports_2022-11-07T07-52-23+00-00.csv"))
        val reader = BufferedReader(input)

        // Read the data
        var line: String?
        var displayData = ""

        while (reader.readLine().also { line = it } != null) {
            val row: List<String> = line!!.split(",")
            // Display first 3 columns
            displayData = displayData + row[0] + " | " + row[1] + " | " + row[2] + "\n" + "\n"
        }

        // Set text to display to field in XML
        val textData = findViewById<TextView>(R.id.data)
        textData.text = displayData
    }
}