package com.example.taxiapp.ui.dashboard

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.taxiapp.*
import com.example.taxiapp.databinding.FragmentDashboardBinding
import com.example.taxiapp.net.ApiRet
import com.example.taxiapp.net.MyRetrofit
import org.w3c.dom.Text
import retrofit2.Call
import retrofit2.Response

class DashboardFragment : Fragment() {

    lateinit var sharedPreferences: SharedPreferences
    private var _binding: FragmentDashboardBinding? = null
    lateinit var email_text:TextView
    lateinit var name_text:TextView
    lateinit var imageView: ImageView
    lateinit var poezdkiRecyclerView: RecyclerView
    lateinit var button:Button

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
        poezdkiRecyclerView = root.findViewById(R.id.poezdkiRecycler)
        val feel = MyRetrofit().getRetrofit()
        val api_ret = feel.create(ApiRet::class.java)
        val feel_call:retrofit2.Call<feelings> = api_ret.getFeel()
        feel_call.enqueue(object:retrofit2.Callback<feelings>
        {
            override fun onResponse(call: Call<feelings>, response: Response<feelings>) {
                if(response.isSuccessful){
                    val data = response.body()?.data
                    poezdkiRecyclerView.layoutManager = (GridLayoutManager(requireContext(),1))
                    poezdkiRecyclerView.adapter = data?.let{PoezdkiAdapter(requireContext(),it)}
                    poezdkiRecyclerView.adapter = data?.let{PoezdkiAdapter(requireContext(),it)}
                }
            }

            override fun onFailure(call: Call<feelings>, t: Throwable) {
                Toast.makeText(requireContext(), t.localizedMessage, Toast.LENGTH_SHORT).show()
            }

        })

        button = root.findViewById(R.id.btnExit)
        button.setOnClickListener()
        {
            val alert =
                AlertDialog.Builder(requireActivity())
                    .setTitle("Предупреждение")
                    .setMessage("Вы точно хотите выйти?")
                    .setPositiveButton("Да"){dialog, which -> startActivity(Intent(activity, SignInActivity::class.java)) }
                    .setNegativeButton("Нет",null)
                    .create()
                    .show()

        }


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}