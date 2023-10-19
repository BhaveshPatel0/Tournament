package com.example.tournamentact.database.tournament

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface TournamentDetailDAO {

    @Insert
    fun insertTournamentDetail(dataTournamentDetail: DataTournamentDetail)

    @Update
    fun updateTournamentDetail(dataTournamentDetail: DataTournamentDetail)

    @Delete
    fun deleteTournamentDetail(dataTournamentDetail: DataTournamentDetail)

    @Query("SELECT * FROM DataTournamentDetail")
    fun getAllData(): List<DataTournamentDetail>
}