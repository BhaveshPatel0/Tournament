package com.example.tournamentact.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.room.Room
import com.example.tournamentact.R
import com.example.tournamentact.database.teammember.DataTeamMember
import com.example.tournamentact.database.teammember.TeamMemberDataBase

class TeamMemberDetailAct : AppCompatActivity() {
    private lateinit var edtMemberName: EditText
    private lateinit var edtMemberAge: EditText
    private lateinit var edtMemberType: EditText
    private lateinit var edtMemberBest: EditText
    private lateinit var btnAddMember: Button
    private lateinit var database: TeamMemberDataBase


    private var selectTeamName=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_team_member_detail)

        selectTeamName= intent.extras!!.getInt("selectTeamName")

        bindView()
        bindClick()
    }

    private fun bindView() {
        edtMemberName = findViewById(R.id.edtMemberName)
        edtMemberAge = findViewById(R.id.edtMemberAge)
        edtMemberType = findViewById(R.id.edtMemberType)
        edtMemberBest = findViewById(R.id.edtMemberBest)
        btnAddMember = findViewById(R.id.btnAddMember)

        database =
            Room.databaseBuilder(applicationContext, TeamMemberDataBase::class.java, "TeamMemberDB")
                .build()

    }

    private fun bindClick() {

        btnAddMember.setOnClickListener {

            val name = edtMemberName.text.toString()
            val age = edtMemberAge.text.toString()
            val type = edtMemberType.text.toString()
            val best = edtMemberBest.text.toString()
            edtMemberName.setText("")
            edtMemberAge.setText("")
            edtMemberBest.setText("")
            edtMemberType.setText("")

            when {
                name.isEmpty() -> {
                    Toast.makeText(this, "Please enter Name", Toast.LENGTH_SHORT).show()
                }

                age.isEmpty() -> {
                    Toast.makeText(this, "Please enter Age", Toast.LENGTH_SHORT).show()
                }

                type.isEmpty() -> {
                    Toast.makeText(this, "Please enter Type", Toast.LENGTH_SHORT).show()
                }

                best.isEmpty() -> {
                    Toast.makeText(this, "Please enter Best", Toast.LENGTH_SHORT).show()
                }

                else -> {
                    Thread {
                        database.TeamMemberDAO()
                            .insertTeamMember(DataTeamMember(0, name, age.toInt(), type, best,selectTeamName))
                    }.start()
                }
            }
        }
    }
}