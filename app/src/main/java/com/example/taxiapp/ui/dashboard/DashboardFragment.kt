package com.example.taxiapp.ui.dashboard

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.taxiapp.R
import com.example.taxiapp.databinding.FragmentDashboardBinding
import com.example.taxiapp.databinding.FragmentHomeBinding
import com.example.taxiapp.email
import org.w3c.dom.Text

class DashboardFragment : Fragment() {

    lateinit var sharedPreferences: SharedPreferences
    private var _binding: FragmentDashboardBinding? = null
    lateinit var email_text:TextView
    lateinit var name_text:TextView
    lateinit var imageView: ImageView

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root
        sharedPreferences = activity?.getSharedPreferences("main", Context.MODE_PRIVATE)!!
        val id = sharedPreferences.getString("id",null)
        val avatar = sharedPreferences.getString("avatar",null)
        val name = sharedPreferences.getString("name",null)
        name_text = root.findViewById(R.id.tvName)
        imageView = root.findViewById(R.id.imgAvatar)

        name_text.text= name
        Glide.with(requireActivity()).load(avatar).into(imageView)
        Toast.makeText(requireContext(), avatar, Toast.LENGTH_SHORT).show()


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}