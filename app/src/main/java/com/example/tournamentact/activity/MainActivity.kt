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
import com.example.tournamentact.adapter.AdapterTournamentDetail
import com.example.tournamentact.database.tournament.TournamentDataBase

class MainActivity : AppCompatActivity() {
    private lateinit var ivAddTournament: ImageView
    private lateinit var tvNoCricketTournament: TextView
    private lateinit var rcvTournamentName: RecyclerView
    private lateinit var mAdapterTournamentDetail: AdapterTournamentDetail
    private lateinit var database: TournamentDataBase



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bindView()
        bindClick()

    }

    private fun bindView() {
        ivAddTournament = findViewById(R.id.ivAddTournament)
        tvNoCricketTournament = findViewById(R.id.tvNoCricketTournament)
        rcvTournamentName = findViewById(R.id.rcvTournamentName)
        database = Room.databaseBuilder(
            applicationContext,
            TournamentDataBase::class.java,
            "TournamentDB"
        ).build()
    }

    private fun bindClick() {
        ivAddTournament.setOnClickListener {

            startActivity(Intent(this, AddTournamentAct::class.java))

        }
    }

    override fun onResume() {
        super.onResume()

        Thread{
            val list= database.TournamentDetailDAO().getAllData()

            runOnUiThread {
                if (list.isNotEmpty()){
                    tvNoCricketTournament.visibility=View.GONE
                }
                mAdapterTournamentDetail = AdapterTournamentDetail(this,list)

                rcvTournamentName.apply {
                    layoutManager = GridLayoutManager(this@MainActivity, 1)
                    adapter = mAdapterTournamentDetail
                }
            }
        }.start()




    }
}