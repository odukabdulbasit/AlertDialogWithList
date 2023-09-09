package com.odukabdulbasit.alertdialogwithlist

import android.app.AlertDialog
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Sample list of items
        val items = arrayOf("Item 1", "Item 2", "Item 3", "Item 4")

        // Create an ArrayAdapter to populate the list in the AlertDialog
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, items)

        // Create the AlertDialog
        val alertDialog = AlertDialog.Builder(this)
            .setTitle("Select an Item")
            .setAdapter(adapter) { _, position ->
                // Handle item click
                val selectedItem = items[position]
                Toast.makeText(this, "You selected: $selectedItem", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Cancel") { dialog, _ ->
                // Handle cancel button click
                dialog.dismiss()
            }
            .create()

        // Show the AlertDialog when a button or some UI element is clicked
        val showButton = findViewById<Button>(R.id.show_button) // Replace with your button ID
        showButton.setOnClickListener {
            alertDialog.show()
        }
    }
}
