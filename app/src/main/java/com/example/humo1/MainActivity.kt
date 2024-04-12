package com.example.humo1

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.switchmaterial.SwitchMaterial
import second.MainActivity2

class MainActivity : AppCompatActivity() {
    private var editTextView: EditText? = null
    private var editTextView1: EditText? = null
    private var textView: TextView? = null
    private var button: Button? = null
    private var button1: Button? = null
    private var checkBox: CheckBox? = null
    private var switcher: SwitchMaterial? = null
    private var radbutton: RadioButton? = null
    private var colorgroup: RadioGroup? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*
        editTextView = findViewById<EditText>(R.id.text_edit)
        textView = findViewById<TextView>(R.id.text_view)
        button = findViewById<Button>(R.id.first_button)
        button1 = findViewById<Button>(R.id.second_button)
        checkBox = findViewById<CheckBox>(R.id.checkbox)
        switcher = findViewById<SwitchMaterial>(R.id.switch_mat)
        colorgroup = findViewById<RadioGroup>(R.id.color)

        editTextView?.doAfterTextChanged { text ->
            textView?.text = text.toString()
            button?.isEnabled = text.toString().isNotEmpty()
            checkBox?.isEnabled = text.toString().isNotEmpty()
        }

        button?.setOnClickListener {
            editTextView?.text?.clear()
        }

        button?.setOnLongClickListener {
            checkBox?.isChecked = true
            true
        }

        checkBox?.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked){

                if (editTextView?.text?.isNotEmpty() == true){
                    Toast.makeText(this, "Is checked", Toast.LENGTH_SHORT).show()
                }else{
                    buttonView.isChecked = false
                    Toast.makeText(this, "Fill edit text", Toast.LENGTH_SHORT).show()
                }

            }else{
                Toast.makeText(this, "Is not checked", Toast.LENGTH_SHORT).show()
            }
        }

        switcher?.setOnCheckedChangeListener { buttonView, isChecked ->
            Snackbar.make(buttonView, isChecked.toString(), Snackbar.LENGTH_SHORT).show()
        }

        colorgroup?.setOnCheckedChangeListener { group, checkedId ->
            when(checkedId){
                R.id.blue ->{
                    Snackbar.make(group, "is checked: blue", Snackbar.LENGTH_SHORT).show()
                }

                R.id.green ->{
                    Snackbar.make(group, "is checked: green", Snackbar.LENGTH_SHORT).show()
                }

                R.id.red ->{
                    Snackbar.make(group, "is checked: red", Snackbar.LENGTH_SHORT).show()
                }
            }
        }

      */

        val button1 = findViewById<Button>(R.id.second_button)
        val editTextView = findViewById<EditText>(R.id.edit_tex)
        val editTextView1 = findViewById<EditText>(R.id.edit_text)

        button1.isEnabled = false

        fun updateButtonState() {
            val text1 = editTextView.text?.toString()?.trim()
            val text2 = editTextView1.text?.toString()?.trim()

            button1.isEnabled = !text1.isNullOrEmpty() && !text2.isNullOrEmpty() && text1 == text2

        }

        editTextView.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                updateButtonState()
            }

        })

        editTextView1.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                updateButtonState()
            }

        })

        button1?.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }






    }
}