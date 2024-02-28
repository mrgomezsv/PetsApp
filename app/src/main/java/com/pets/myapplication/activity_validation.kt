package com.pets.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText

class activity_validation : AppCompatActivity() {

    private lateinit var editText1: EditText
    private lateinit var editText2: EditText
    private lateinit var editText3: EditText
    private lateinit var editText4: EditText
    private lateinit var editText5: EditText
    private lateinit var editText6: EditText
    private lateinit var buttonValidate: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_validation)

        editText1 = findViewById(R.id.editText1)
        editText2 = findViewById(R.id.editText2)
        editText3 = findViewById(R.id.editText3)
        editText4 = findViewById(R.id.editText4)
        editText5 = findViewById(R.id.editText5)
        editText6 = findViewById(R.id.editText6)
        buttonValidate = findViewById(R.id.buttonValidate)

        setupVerificationCodeEditTexts()
        setupButtonValidation()

        goHome()
    }

    private fun goHome(){
        val buttonValidate: Button = findViewById(R.id.buttonValidate)
        buttonValidate.setOnClickListener {
            val intent = Intent(this, activity_home::class.java)
            startActivity(intent)
        }
    }

    private fun setupVerificationCodeEditTexts() {
        val editTexts = listOf(editText1, editText2, editText3, editText4, editText5, editText6)
        editTexts.forEachIndexed { index, editText ->
            setupNumericEditText(editText)
            if (index < editTexts.size - 1) {
                editText.addTextChangedListener(createVerificationCodeTextWatcher(editText, editTexts[index + 1]))
            }
        }
    }

    private fun setupNumericEditText(editText: EditText) {
        editText.inputType = android.text.InputType.TYPE_CLASS_NUMBER
    }

    private fun createVerificationCodeTextWatcher(currentEditText: EditText, nextEditText: EditText): TextWatcher {
        return object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                if (!s.isNullOrEmpty() && s.length == 1) {
                    // Si se ha ingresado un número, pasar automáticamente al siguiente EditText
                    nextEditText.requestFocus()
                }
            }
        }
    }

    private fun setupButtonValidation() {
        val editTexts = listOf(editText1, editText2, editText3, editText4, editText5, editText6)
        editTexts.forEach { editText ->
            editText.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable?) {
                    val allFilled = editTexts.all { it.text.isNotEmpty() }
                    buttonValidate.isEnabled = allFilled
                }
            })
        }
    }
}
