package com.mobile.protocolbuffer

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.mobile.protocolbuffer.protoApp.ProtoViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var protoViewModel: ProtoViewModel
    private lateinit var editTextTextPersonName: EditText
    private lateinit var button: Button
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextTextPersonName = findViewById(R.id.editTextTextPersonName)
        button = findViewById(R.id.button)
        textView = findViewById(R.id.textView)

        protoViewModel = ViewModelProvider(this).get(ProtoViewModel::class.java)

        protoViewModel.fullName.observe(this, {
            textView.text = it.fullName
//            Toast.makeText(this, it.fullName, Toast.LENGTH_LONG).show()
        })

        button.setOnClickListener {
            protoViewModel.updateValue(editTextTextPersonName.text.toString())
        }
    }
}