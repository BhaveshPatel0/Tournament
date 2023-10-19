package com.example.tournamentact.database.teamname

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DataTeamName(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val teamName:String,
    val tournamentId : Int
)
