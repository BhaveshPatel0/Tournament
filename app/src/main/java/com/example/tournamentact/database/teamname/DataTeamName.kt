package com.example.tournamentact.database.teamname

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class DataTeamName(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val teamName:String,
    val tournamentId : Int
):Serializable
