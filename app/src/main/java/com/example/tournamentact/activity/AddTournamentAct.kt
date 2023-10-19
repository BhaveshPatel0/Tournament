package com.example.tournamentact.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.room.Room
import com.example.tournamentact.R
import com.example.tournamentact.database.tournament.DataTournamentDetail
import com.example.tournamentact.database.tournament.TournamentDataBase

class AddTournamentAct : AppCompatActivity() {
    private lateinit var edtTournamentName: EditText
    private lateinit var edtTournamentVenue: EditText
    private lateinit var edtTournamentDate: EditText
    private lateinit var edtTournamentFormat: EditText
    private lateinit var edtBallType: EditText
    private lateinit var edtWicketType: EditText

    private lateinit var btnOK: Button
    private lateinit var database: TournamentDataBase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_tournament)
        bindView()
        bindClick()
    }

    private fun bindView() {

        edtTournamentName = findViewById(R.id.edtTournamentName)
        edtTournamentVenue = findViewById(R.id.edtTournamentVenue)
        edtTournamentDate = findViewById(R.id.edtTournamentDate)
        edtTournamentFormat = findViewById(R.id.edtTournamentFormat)
        edtBallType = findViewById(R.id.edtBallType)
        edtWicketType = findViewById(R.id.edtWicketType)

        btnOK = findViewById(R.id.btnOK)

        database = Room.databaseBuilder(
            applicationContext,
            TournamentDataBase::class.java,
            "TournamentDB"
        ).build()


    }

    private fun bindClick() {
        btnOK.setOnClickListener {
            val name = edtTournamentName.text.toString()
            val venue = edtTournamentVenue.text.toString()
            val date = edtTournamentDate.text.toString()
            val format = edtTournamentFormat.text.toString()
            val ballType = edtBallType.text.toString()
            val wicketType = edtWicketType.text.toString()
            edtTournamentName.setText("")
            edtTournamentVenue.setText("")
            edtTournamentDate.setText("")
            edtTournamentFormat.setText("")
            edtBallType.setText("")
            edtWicketType.setText("")

//            if (name.isEmpty()){
//                Toast.makeText(this, "Please Enter Name", Toast.LENGTH_SHORT).show()
//            }
//            else{
//                Thread{
//                    val tournament=DataTournamentDetail(name, venue, date, format, ballType, wicketType)
//                    database.TournamentDetailDAO().insertTournamentDetail(tournament)
//                }.start()
//            }

            when{
                name.isEmpty()->{
                    Toast.makeText(this, "Please enter Name", Toast.LENGTH_SHORT).show()
                }
                venue.isEmpty()->{
                    Toast.makeText(this, "Please enter Venue", Toast.LENGTH_SHORT).show()
                }
                date.isEmpty()->{
                    Toast.makeText(this, "Please enter Date", Toast.LENGTH_SHORT).show()
                }
                format.isEmpty()->{
                    Toast.makeText(this, "Please enter Format", Toast.LENGTH_SHORT).show()
                }
                ballType.isEmpty()->{
                    Toast.makeText(this, "Please enter Ball Type", Toast.LENGTH_SHORT).show()
                }
                wicketType.isEmpty()->{
                    Toast.makeText(this, "Please enter Wicket Type", Toast.LENGTH_SHORT).show()
                }
                else->{
                    Thread{
                    val tournament=
                        DataTournamentDetail(0,name, venue, date, format, ballType, wicketType)
                    database.TournamentDetailDAO().insertTournamentDetail(tournament)
                }.start()
                }
            }
            finish()
        }
    }
}