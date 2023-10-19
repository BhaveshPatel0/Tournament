package com.example.tournamentact.database.teamname

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [DataTeamName::class], version = 1)
abstract class TeamNameDataBase:RoomDatabase() {

    abstract fun TeamNameDAO():TeamNameDAO

}