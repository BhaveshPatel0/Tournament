package com.example.tournamentact.database.teamname

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update


@Dao
interface TeamNameDAO {

    @Insert
    fun insertTeamName(dataTeamName: DataTeamName)

    @Update
    fun updateTeamName(dataTeamName: DataTeamName)

    @Delete
    fun deleteTeamName (dataTeamName: DataTeamName)

    @Query("SELECT * FROM DataTeamName where tournamentId=:tid ")
    fun getAllData(tid : Int): List<DataTeamName>
}