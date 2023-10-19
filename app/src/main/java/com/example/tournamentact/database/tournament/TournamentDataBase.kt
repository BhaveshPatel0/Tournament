package com.example.tournamentact.database.tournament

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [DataTournamentDetail::class], version = 1)
abstract class TournamentDataBase : RoomDatabase() {

    abstract fun TournamentDetailDAO(): TournamentDetailDAO

}