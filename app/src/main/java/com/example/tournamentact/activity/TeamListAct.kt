package com.example.tournamentact.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.tournamentact.R
import com.example.tournamentact.adapter.AdapterTeamName
import com.example.tournamentact.database.teamname.TeamNameDataBase

class TeamListAct : AppCompatActivity() {
    private lateinit var ivAddTeam: ImageView
    private lateinit var tvNoTeamAdded: TextView
    private lateinit var btnAddMatch: Button
    private lateinit var rcvTeamDetail: RecyclerView
    private lateinit var database: TeamNameDataBase
    private lateinit var mAdapterTeamName: AdapterTeamName
    var selectedTournament = 0
    var TAG = "bhavesh"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_team_list)
        selectedTournament = intent.extras?.getInt("selectedTournament")!!
        bindView()
        bindClick()
    }

    private fun bindView() {
        ivAddTeam = findViewById(R.id.ivAddTeam)
        btnAddMatch = findViewById(R.id.btnAddMatch)
        tvNoTeamAdded = findViewById(R.id.tvNoTeamAdded)
        rcvTeamDetail = findViewById(R.id.rcvTeamDetail)
        database =
            Room.databaseBuilder(applicationContext, TeamNameDataBase::class.java, "TeamNameDB")
                .build()
    }

    private fun bindClick() {
        ivAddTeam.setOnClickListener {
            startActivity(
                Intent(this, AddTeamNameAct::class.java)
                    .putExtra("selectedTournament", selectedTournament)
            )
        }
        btnAddMatch.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    SelectMatchTeamAct::class.java
                ).putExtra("selectedTournament", selectedTournament)
            )
        }
    }

    override fun onResume() {
        super.onResume()
        Thread {
            val teamList = database.TeamNameDAO().getAllData(selectedTournament)
//            Log.d(TAG, "onResume: $teamList")
            runOnUiThread {
                if (teamList.isNotEmpty()) {
                    tvNoTeamAdded.visibility = View.GONE
                }
                mAdapterTeamName = AdapterTeamName(this, teamList)

                rcvTeamDetail.apply {
                    layoutManager = GridLayoutManager(this@TeamListAct, 3)
                    adapter = mAdapterTeamName
                }
            }
        }.start()
    }
}