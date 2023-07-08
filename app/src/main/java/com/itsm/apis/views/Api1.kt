package com.itsm.apis.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.itsm.apis.R
import com.itsm.apis.databinding.FragmentApi1Binding
import com.itsm.apis.viewmodels.Api1VM


class Api1 : Fragment() {

    private val langOpts = arrayListOf<String>("","")
    private val vm: Api1VM by activityViewModels()
    private var _binding: FragmentApi1Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentApi1Binding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this@Api1.requireActivity().title = "Translate API"
        binding.eng.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked){
                langOpts[0] = "en"
                langOpts[1] = "es"
            }

        }
        binding.esp.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked){
                langOpts[0] = "es"
                langOpts[1] = "en"
            }

        }
        binding.eng!!.isChecked = true

        binding.btnTranslate.setOnClickListener {
            var text = binding.text.text.toString()
            vm.translate(text,langOpts[0],langOpts[1], lifecycleScope)
        }
        vm.translation.observe(viewLifecycleOwner, Observer {
            if(it != null)
                binding.translation.text = "Texto traducido: ${it!!}"
        })

    }

}