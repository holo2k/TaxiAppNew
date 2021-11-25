package com.example.taxiapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import java.util.regex.Pattern

class SignUpActivity : AppCompatActivity() {
    lateinit var user_name: EditText
    lateinit var emailreg: EditText
    lateinit var password_reg:EditText
    lateinit var password_aqq:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        user_name = findViewById(R.id.etName)
        emailreg = findViewById(R.id.etEmailreg)
        password_reg = findViewById(R.id.etPass)
        password_aqq = findViewById(R.id.etPassRepeat)
    }

    val pattern = ("[a-z0-9]{1,256}" +
            "\\@"+
            "[a-z0-9]{1,10}" +
            "\\."+
            "[a-z]{1,3}")


    fun EmailValid (email:String):Boolean{
        return Pattern.compile(pattern).matcher(email).matches()}

    fun btnRegistration(view: View)
    {
        if(user_name.text.isNotEmpty() &&
            emailreg.text.isNotEmpty() &&
            password_reg.text.isNotEmpty()&&
            password_aqq.text.isNotEmpty()) {
            if(password_reg.text.toString().equals(password_aqq.text.toString()))
            {
                if(EmailValid(emailreg.text.toString()))
                {
                    val auth = Intent(this, SignInActivity::class.java)
                    startActivity(auth)
                }
                else
                {
                    val alert = AlertDialog.Builder(this,)
                        .setTitle("Неверно введённый Email")
                        .setPositiveButton("OK",null)
                        .create()
                        .show()
                }

            }
            else
            {
                val alert = AlertDialog.Builder(this,)
                    .setTitle("Пароли не совпадают")
                    .setPositiveButton("OK",null)
                    .create()
                    .show()
            }
        }
        else
        {
          val alert = AlertDialog.Builder(this,)
              .setTitle("Ошибка входа")
              .setMessage("У вас есть пустые поля")
              .setPositiveButton("OK",null)
              .create()
              .show()
        }
    }
}