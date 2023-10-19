package com.example.tournamentact.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.tournamentact.R
import com.example.tournamentact.adapter.AdapterTeamName
import com.example.tournamentact.database.teamname.DataTeamName
import com.example.tournamentact.database.teamname.TeamNameDataBase

class SelectMatchTeamAct : AppCompatActivity() {
    private lateinit var rcvSelectTeam: RecyclerView
    private lateinit var btnOk: Button
    private lateinit var database: TeamNameDataBase
    private lateinit var mAdapterTeamName: AdapterTeamName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_match_team)
        bindView()
        bindClick()
    }

    private fun bindView() {
        rcvSelectTeam = findViewById(R.id.rcvSelectTeam)
        btnOk = findViewById(R.id.btnOk)

        database =
            Room.databaseBuilder(applicationContext, TeamNameDataBase::class.java, "TeamNameDB")
                .build()


    }

    private fun bindClick() {


    }
}