
package edu.rockvalleycollege.week5

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        var txtName = findViewById<EditText>(R.id.txtName)
        var txtEmail = findViewById<EditText>(R.id.txtEmail)
        var txtShow = findViewById<TextView>(R.id.txtShow)
        var rbFemale = findViewById<RadioButton>(R.id.rbFemale)
        var rbMale = findViewById<RadioButton>(R.id.rbMale)
        var btnSubmit = findViewById<Button>(R.id.btnSubmit)
        var rbOther = findViewById<RadioButton>(R.id.rbOther)
        //Simple way to make a border ya know
        val borderTop = findViewById<EditText>(R.id.borderTop)
        val borderBottom = findViewById<EditText>(R.id.borderBottom)

        txtName.requestFocus()


        btnSubmit.setOnClickListener{
            if (rbFemale.isChecked) txtShow.text = "Hello, ${txtName.text}, the women's lounge is on the first floor. We will " +
                    "send the meeting agenda to email: ${txtEmail.text}"
            if (rbMale.isChecked) txtShow.text = "Hello, ${txtName.text}, the men's lounge is on the second floor. We will " +
                    "send the meeting agenda to email: ${txtEmail.text}"
            if (rbOther.isChecked) txtShow.text = "Hello, ${txtName.text}, the lounge is on the third floor. We will " +
                    "send the meeting agenda to email: ${txtEmail.text}"
            hideKeyboard()
            txtName.setText("")
            txtEmail.setText("")
            txtName.requestFocus()
        }

        findViewById<View>(android.R.id.content).setOnTouchListener{ _, event ->
            hideKeyboard()
            false
        }

    }

    fun hideKeyboard()
    {
        try
        {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
        } catch (e: Exception) {
            // TODO: handle exception
        }

    }




}