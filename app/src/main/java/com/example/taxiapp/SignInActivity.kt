package com.example.taxiapp

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import retrofit2.Call
import retrofit2.Response
import java.util.regex.Pattern.compile

lateinit var email: EditText
lateinit var password:EditText
lateinit var sharedPreferences: SharedPreferences
class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        email = findViewById(R.id.etEmail)
        password = findViewById(R.id.etPass)
        sharedPreferences = getSharedPreferences("main", MODE_PRIVATE)


    }

    val pattern = ("[a-z0-9]{1,256}" +
            "\\@"+
            "[a-z0-9]{1,10}" +
            "\\."+
            "[a-z]{1,3}")


    fun EmailValid (email:String):Boolean{
        return compile (pattern).matcher(email).matches()}

    fun btnRegister(view: View)
    {
        val reg = Intent(this, SignUpActivity::class.java)
        startActivity(reg)
    }
    fun btnConnect(view: View)
    {
        if(email.text.isNotEmpty() && password.text.isNotEmpty())
        {
            if(EmailValid(email.text.toString()))
            {
                val getApi = Obj.getRetrofit()
                var hashMap:HashMap<String,String> = HashMap<String,String>()
                hashMap.put("email",email.text.toString())
                hashMap.put("password", password.text.toString())
                val log_call: retrofit2.Call<login> = getApi.getAuth(hashMap)
                log_call.enqueue(object:retrofit2.Callback<login>{
                    override fun onResponse(call: Call<login>, response: Response<login>) {
                        if(response.isSuccessful)
                        {
                            val editor =  sharedPreferences.edit()
                            editor.putString("id",response.body()?.id)
                            editor.putString("avatar",response.body()?.avatar)
                            editor.putString("Name",response.body()?.nickName)
                            editor.apply()
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
                    .setTitle("Неверно введённый Email")
                    .setPositiveButton("OK",null)
                    .create()
                    .show()
            }
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