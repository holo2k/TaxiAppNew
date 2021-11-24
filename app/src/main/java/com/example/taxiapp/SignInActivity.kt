package com.example.taxiapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.taxiapp.net.ApiRet
import com.example.taxiapp.net.MyRetrofit
import retrofit2.Call
import retrofit2.Response

lateinit var phone: EditText
lateinit var password:EditText
class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        phone = findViewById(R.id.etPhone)
        password = findViewById(R.id.etPass)

    }

    fun btnRegister(view: View)
    {
        val reg = Intent(this, SignUpActivity::class.java)
        startActivity(reg)
    }
    fun btnConnect(view: View)
    {
        if(phone.text.isNotEmpty() && password.text.isNotEmpty())
        {
            val log = MyRetrofit().getRetrofit()
            val getApi=log.create(ApiRet::class.java)
            var hashMap:HashMap<String,String> = HashMap<String,String>()
            hashMap.put("phone",phone.text.toString())
            hashMap.put("password", password.text.toString())
            val log_call: retrofit2.Call<login> = getApi.getAuth(hashMap)
            log_call.enqueue(object:retrofit2.Callback<login>{
                override fun onResponse(call: Call<login>, response: Response<login>) {
                    if(response.isSuccessful)
                    {
                        val menu = Intent(this@SignInActivity, MenuActivity::class.java)
                        startActivity(menu)
                    }
                    else {
                        Toast.makeText(this@SignInActivity, "Неверный пароль", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<login>, t: Throwable) {
                    Toast.makeText(this@SignInActivity,t.message,Toast.LENGTH_LONG).show()

                }

            })

        }
        else
        {
            val alert = AlertDialog.Builder(this)
                .setTitle("Ошибка входа")
                .setMessage("У вас есть пустые поля")
                .setPositiveButton("OK",null)
                .create()
                .show()
        }
    }
    fun btnHelp(view: View) {}
}