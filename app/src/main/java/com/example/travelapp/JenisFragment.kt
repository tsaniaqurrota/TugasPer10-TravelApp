package com.example.travelapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.travelapp.databinding.ActivityMainBinding
import com.example.travelapp.databinding.FragmentJenisBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

/**
 * A simple [Fragment] subclass.
 * Use the [JenisFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class JenisFragment : Fragment() {
    private lateinit var binding: FragmentJenisBinding

    private val jenis = arrayOf(
        "First Class Ticket",
        "Business Class Ticket",
        "Economy Class Ticket"
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentJenisBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            val adapterJenis = ArrayAdapter(
                requireActivity(),
                android.R.layout.simple_spinner_item,jenis
            )
            adapterJenis.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

            spinnerJenisTiket.adapter = adapterJenis

            spinnerJenisTiket.onItemSelectedListener=
                object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(
                        parent: AdapterView<*>?,
                        view: View?,
                        position: Int,
                        id: Long
                    ) {
                        val selectedJenis = jenis[position]

                        Log.d("Jenis Tiket", selectedJenis)
                    }
                    override fun onNothingSelected(parent: AdapterView<*>?) {
                    }
                }

            btnBuyJenis.setOnClickListener {
                val selectedJenis = spinnerJenisTiket.selectedItem.toString()
                if (selectedJenis.isNotBlank()) {
                    findNavController().navigateUp()
                }
            }
        }
    }
}
