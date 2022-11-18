package com.example.kotlin8last

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import com.example.kotlin8last.databinding.FragmentThirdBinding

class ThirdFragment : Fragment() {

    private var binding: FragmentThirdBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentThirdBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        clickAdd()
    }

    private fun clickAdd() {
        binding?.btnAddThirdFragment?.setOnClickListener {
            val url = binding?.etImage?.text.toString().trim { it <= ' ' }
            val name = binding?.etName?.text.toString()
            val family = binding?.etFamily?.text.toString()
            val age = binding?.etAge?.text.toString()
            val bundle = Bundle()

            if (url.isEmpty() && name.isEmpty() && family.isEmpty() && age.isEmpty()) {
                binding?.etImage?.error = "URL is empty"
                binding?.etName?.error = "Name is empty"
                binding?.etFamily?.error = "Family is empty"
                binding?.etAge?.error = "Age is empty"
            } else if (url.isEmpty()) {
                binding?.etImage?.error = "Add URL"
            } else if (name.isEmpty()) {
                binding?.etName?.error = "Add name"
            } else if (family.isEmpty()) {
                binding?.etFamily?.error = "Family is empty"
            } else if (age.isEmpty()) {
                binding?.etAge?.error = "Age is empty"
            } else {
                val model = RecyclerModel(url, name, age.toInt(), family)
                bundle.putSerializable("OK", model)
                setFragmentResult("back", bundle)
//                findNavController().navigate(R.id.action_thirdFragment_to_recyclerFragment,bundle)
                findNavController().popBackStack()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}