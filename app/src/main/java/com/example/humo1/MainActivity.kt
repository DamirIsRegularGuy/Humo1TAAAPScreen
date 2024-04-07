package com.example.humo1

import android.os.Bundle
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

class MainActivity : AppCompatActivity() {
    private var editTextView: EditText? = null
    private var textView: TextView? = null
    private var button: Button? = null
    private var checkBox: CheckBox? = null
    private var switcher: SwitchMaterial? = null
    private var radbutton: RadioButton? = null
    private var colorgroup: RadioGroup? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.vie3)

        editTextView = findViewById<EditText>(R.id.text_edit)
        textView = findViewById<TextView>(R.id.text_view)
        button = findViewById<Button>(R.id.first_button)
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


    }
}