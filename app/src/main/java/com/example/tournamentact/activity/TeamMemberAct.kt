package com.example.tournamentact.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.tournamentact.R
import com.example.tournamentact.adapter.AdapterTeamMember
import com.example.tournamentact.database.teammember.TeamMemberDataBase

class TeamMemberAct : AppCompatActivity() {
    private lateinit var ivAddTeamMember: ImageView
    private lateinit var tvNoTeamMember: TextView
    private lateinit var rcvTeamMember: RecyclerView
    private lateinit var database: TeamMemberDataBase
    private lateinit var mAdapterTeamMember: AdapterTeamMember

    var selectTeamName = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_team_member)
        selectTeamName = intent.extras!!.getInt("selectTeamName")
        bindView()
        bindClick()
    }

    private fun bindView() {
        ivAddTeamMember = findViewById(R.id.ivAddTeamMember)
        tvNoTeamMember = findViewById(R.id.tvNoTeamMember)
        rcvTeamMember = findViewById(R.id.rcvTeamMember)
        database =
            Room.databaseBuilder(applicationContext, TeamMemberDataBase::class.java, "TeamMemberDB")
                .build()
    }

    private fun bindClick() {
        ivAddTeamMember.setOnClickListener {
            startActivity(Intent(this, TeamMemberDetailAct::class.java).putExtra("selectTeamName",selectTeamName))
        }

    }

    override fun onResume() {
        super.onResume()



        Thread {

            val teamMemberList = database.TeamMemberDAO().getAllData(selectTeamName)

            runOnUiThread {
                if (teamMemberList.isNotEmpty()) {
                    tvNoTeamMember.visibility = View.GONE
                }
                mAdapterTeamMember = AdapterTeamMember(this, teamMemberList)

                rcvTeamMember.apply {
                    layoutManager = GridLayoutManager(this@TeamMemberAct, 1)
                    adapter = mAdapterTeamMember
                }

            }
        }.start()
    }

}

