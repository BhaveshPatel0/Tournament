package com.example.tournamentact.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tournamentact.R
import com.example.tournamentact.activity.TeamListAct
import com.example.tournamentact.database.tournament.DataTournamentDetail

class AdapterTournamentDetail(
    val reqContext: Context,
    val listOfDetail: List<DataTournamentDetail>
) : RecyclerView.Adapter<AdapterTournamentDetail.HolderTournamentDetail>() {

    class HolderTournamentDetail(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val tvTournamentName: TextView = itemView.findViewById(R.id.tvTournamentName)
        val tvVenue: TextView = itemView.findViewById(R.id.tvVenue)
        val tvDate: TextView = itemView.findViewById(R.id.tvDate)
        val tvFormat: TextView = itemView.findViewById(R.id.tvFormat)
        val llTournamentList: LinearLayout = itemView.findViewById(R.id.llTournamentList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        HolderTournamentDetail(
            LayoutInflater.from(reqContext)
                .inflate(R.layout.item_rcv_tourament_detail, parent, false)
        )

    override fun getItemCount(): Int {
        return listOfDetail.size
    }

    override fun onBindViewHolder(holder: HolderTournamentDetail, position: Int) {
        val list = listOfDetail[position]

        holder.tvTournamentName.text = list.name
        holder.tvVenue.text = list.venue
        holder.tvDate.text = list.date
        holder.tvFormat.text = list.format
        holder.llTournamentList.setOnClickListener {

            reqContext.startActivity(
                Intent(
                    reqContext,
                    TeamListAct::class.java
                ).putExtra("selectedTournament", list.id)
            )

        }

    }
}