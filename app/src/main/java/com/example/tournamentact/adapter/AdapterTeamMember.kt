package com.example.tournamentact.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tournamentact.R
import com.example.tournamentact.database.teammember.DataTeamMember
import com.example.tournamentact.database.teamname.DataTeamName

class AdapterTeamMember(val reqContext: Context, val listOfMember: List<DataTeamMember>) :
    RecyclerView.Adapter<AdapterTeamMember.HolderTeamMember>() {

    class HolderTeamMember(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvPlayerName:TextView=itemView.findViewById(R.id.tvPlayerName)
        val tvAge:TextView=itemView.findViewById(R.id.tvAge)
        val tvPlayerType:TextView=itemView.findViewById(R.id.tvPlayerType)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = HolderTeamMember(
        LayoutInflater.from(reqContext).inflate(
            R.layout.item_rcv_team_member, parent, false
        )
    )

    override fun getItemCount(): Int {
        return listOfMember.size
    }

    override fun onBindViewHolder(holder: HolderTeamMember, position: Int) {
        val list=listOfMember[position]
        holder.tvPlayerName.text=list.name
        holder.tvAge.text=list.age.toString()
        holder.tvPlayerType.text=list.type
    }
}