package com.example.tournamentact.database.teammember

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.net.IDN

@Entity
data class DataTeamMember(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val name:String,
    val age:Int,
    val type:String,
    val best:String,
    val teamMemberID:Int
)
