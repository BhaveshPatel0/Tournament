package com.example.tournamentact.database.teammember

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [DataTeamMember::class], version = 1)
abstract class TeamMemberDataBase:RoomDatabase() {

    abstract fun TeamMemberDAO():TeamMemberDAO

}