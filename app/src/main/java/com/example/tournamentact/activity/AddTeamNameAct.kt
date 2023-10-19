package com.example.tournamentact.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.room.Room
import com.example.tournamentact.R
import com.example.tournamentact.database.teamname.TeamNameDataBase
import com.example.tournamentact.database.teamname.DataTeamName

class AddTeamNameAct : AppCompatActivity() {
    private lateinit var edtTeamName: EditText
    private lateinit var btnAddTeam: Button
    private lateinit var database: TeamNameDataBase
    var selectedTournament = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_team_name)
        selectedTournament = intent.extras?.getInt("selectedTournament")!!
        bindView()
        bindClick()
    }

    private fun bindView() {
        edtTeamName = findViewById(R.id.edtTeamName)
        btnAddTeam = findViewById(R.id.btnAddTeam)

        database =
            Room.databaseBuilder(applicationContext, TeamNameDataBase::class.java, "TeamNameDB")
                .build()
    }

    private fun bindClick() {

        btnAddTeam.setOnClickListener {

            val teamName = edtTeamName.text.toString()
            edtTeamName.setText("")

            when {
                teamName.isEmpty() -> {
                    Toast.makeText(this, "Please enter Team Name", Toast.LENGTH_SHORT).show()
                }

                else -> {
                    Thread {
                        database.TeamNameDAO()
                            .insertTeamName(DataTeamName(0, teamName, selectedTournament))
                    }.start()
                }
            }
            finish()
        }
    }
}