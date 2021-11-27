package com.example.taxiapp.ui.taxi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.taxiapp.*
import com.example.taxiapp.databinding.FragmentTaxiBinding

class TaxiFragment : Fragment() {


    lateinit var recyclerView: RecyclerView
    private var _binding:FragmentTaxiBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        _binding = FragmentTaxiBinding.inflate(inflater, container, false)
        val root: View = binding.root

        recyclerView = root.findViewById(R.id.carRecycler)
        recyclerView.adapter = listOfCars.listOfCars?.let { CarsAdapter(requireContext()!!, it) }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}