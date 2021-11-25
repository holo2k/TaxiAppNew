package com.example.taxiapp.ui.home

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.taxiapp.R
import com.example.taxiapp.databinding.FragmentHomeBinding
import com.example.taxiapp.email

class HomeFragment : Fragment() {


    lateinit var sharedPreferences: SharedPreferences
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {


        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        sharedPreferences = activity?.getSharedPreferences("main", Context.MODE_PRIVATE)!!
        val phone = sharedPreferences.getString("phone",null)
        val avatar = sharedPreferences.getString("avatar",null)
        val name = sharedPreferences.getString("name",null)
        Toast.makeText(requireContext(), phone, Toast.LENGTH_SHORT).show()


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}