package com.example.tournamentact.database.tournament

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DataTournamentDetail(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val venue: String,
    val date: String,
    val format: String,
    val ballType: String,
    val wicketType: String
)
