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
import com.example.tournamentact.activity.TeamMemberAct
import com.example.tournamentact.database.teamname.DataTeamName

class AdapterTeamName(val reqContext: Context, val listOfTeamName: List<DataTeamName>) :
    RecyclerView.Adapter<AdapterTeamName.HolderTeamName>() {

    class HolderTeamName(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTeamName: TextView = itemView.findViewById(R.id.tvTeamName)
        val tvTeamName1: TextView = itemView.findViewById(R.id.tvTeamName1)
        val llTeamName: LinearLayout = itemView.findViewById(R.id.llTeamName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        HolderTeamName(
            LayoutInflater.from(reqContext).inflate(R.layout.item_rcv_team_name, parent, false)

        )

    override fun getItemCount(): Int {
        return listOfTeamName.size
    }

    override fun onBindViewHolder(holder: HolderTeamName, position: Int) {
        val list = listOfTeamName[position]
        holder.tvTeamName.text = list.teamName
        holder.tvTeamName1.text = list.teamName
        holder.llTeamName.setOnClickListener {
            reqContext.startActivity(
                Intent(
                    reqContext,
                    TeamMemberAct::class.java
                ).putExtra("selectTeamName",list.id)
            )
        }
    }
}