package com.example.tournamentact.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.tournamentact.R
import com.example.tournamentact.adapter.AdapterSelectTeam
import com.example.tournamentact.adapter.AdapterTeamName
import com.example.tournamentact.database.teamname.DataTeamName
import com.example.tournamentact.database.teamname.TeamNameDataBase

class SelectMatchTeamAct : AppCompatActivity() {
    private lateinit var rcvSelectTeam: RecyclerView
    private lateinit var btnOk: Button
    private lateinit var database: TeamNameDataBase
    private lateinit var mAdapterSelectTeam: AdapterSelectTeam

    var selectTeam=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_match_team)
        selectTeam=intent.extras?.getInt("selectedTournament")!!
        bindView()
        bindClick()
    }
    private fun bindView() {
        rcvSelectTeam = findViewById(R.id.rcvSelectTeam)
        btnOk = findViewById(R.id.btnOk)
        database =
            Room.databaseBuilder(applicationContext, TeamNameDataBase::class.java, "TeamNameDB")
                .build()
        Thread {
            val teamList = database.TeamNameDAO().getAllData(selectTeam)
            Log.d("TAG", "bindView:$teamList")
            runOnUiThread {
                mAdapterSelectTeam = AdapterSelectTeam(this,teamList)
                rcvSelectTeam.apply {
                    layoutManager = GridLayoutManager(this@SelectMatchTeamAct,3)
                    adapter = mAdapterSelectTeam
                }
            }
        }.start()
    }
    private fun bindClick() {
    }
}