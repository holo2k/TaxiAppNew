package com.example.taxiapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AlertDialog

class SignUpActivity : AppCompatActivity() {
    lateinit var user_name: EditText
    lateinit var phone_number: EditText
    lateinit var password_reg:EditText
    lateinit var password_aqq:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        user_name = findViewById(R.id.etName)
        phone_number = findViewById(R.id.etPhone)
        password_reg = findViewById(R.id.etPass)
        password_aqq = findViewById(R.id.etPassRepeat)
    }

    fun btnRegistration(view: View)
    {
        if(user_name.text.isNotEmpty() &&
            phone_number.text.isNotEmpty() &&
            password_reg.text.isNotEmpty()&&
            password_aqq.text.isNotEmpty()) {
            if(password_reg.text.toString().equals(password_aqq.text.toString()))
            {
                if(phone_number.text.length == 11 || phone_number.text.length == 10)
                {

                }
                else
                {
                    val alert = AlertDialog.Builder(this,)
                        .setTitle("Ошибка входа")
                        .setMessage("В поле телефон недопустимое количество символов")
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