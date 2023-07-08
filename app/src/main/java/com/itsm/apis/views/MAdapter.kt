package com.iot.sensors.views

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.itsm.apis.databinding.NbaItemBinding
import com.itsm.apis.models.Team

class MAdapter(private val teams: List<Team>): RecyclerView.Adapter<MAdapter.MViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MViewHolder {

        return MViewHolder(
            NbaItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MViewHolder, position: Int) {
        val item = teams[position]
        holder.bind(item)

    }

    override fun getItemCount(): Int {
        return teams.size
    }

    inner class MViewHolder(private val binding: NbaItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(t: Team){
            binding.abr.text = "Abreviación: ${t.abbreviation}"
            binding.city.text = "Ciudad: ${t.city}"
            binding.confer.text = "Confencia: ${t.conference}"
            binding.division.text = "División: ${t.division}"
            binding.fullName.text = "Nombre Completo: ${t.full_name}"
            binding.name.text = "Nombre: ${t.name}"
        }

    }
}