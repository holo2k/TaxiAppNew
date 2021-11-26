package com.example.taxiapp

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.taxiapp.databinding.ActivityMenuBinding
import com.example.taxiapp.databinding.FragmentDashboardBinding
import com.example.taxiapp.ui.dashboard.DashboardFragment

class MenuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMenuBinding
    lateinit var sharedPreferences: SharedPreferences
    private var _binding: FragmentDashboardBinding? = null
    lateinit var email_text: TextView
    lateinit var name_text: TextView
    lateinit var imageView: ImageView
    lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPreferences = getSharedPreferences("main", Context.MODE_PRIVATE)!!
        val id = sharedPreferences.getString("id",null)
        val avatar = sharedPreferences.getString("avatar",null)
        val name = sharedPreferences.getString("Name",null)
        name_text = findViewById(R.id.tvName)
        imageView = findViewById(R.id.imgAvatar)
        name_text.text = name
        Glide.with(applicationContext).load(avatar).circleCrop().into(imageView)
        imageView.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?){
                val intent = Intent(this@MenuActivity, FragmentDashboardBinding::class.java)
            }
        })
        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_menu)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.


        navView.setupWithNavController(navController)
    }


}

