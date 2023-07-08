package com.itsm.apis.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.iot.sensors.views.MAdapter
import com.itsm.apis.R
import com.itsm.apis.databinding.FragmentApi2Binding
import com.itsm.apis.models.Team
import com.itsm.apis.viewmodels.Api2VM


class Api2 : Fragment() {

    private var _binding: FragmentApi2Binding? = null
    private val binding get() = _binding!!

    private val vm: Api2VM by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentApi2Binding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this@Api2.requireActivity().title = "NBA TEAMS API"
        vm.getAll(lifecycleScope)
        vm.list.observe(viewLifecycleOwner, Observer {
            if (it!=null) {
                binding.list.adapter = MAdapter(it)
                binding.list.layoutManager = LinearLayoutManager(this@Api2.requireContext())
            }
        })
    }
}