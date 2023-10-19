package com.example.tournamentact.database.teammember

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.tournamentact.database.teamname.DataTeamName

@Dao
interface TeamMemberDAO {

    @Insert
    fun insertTeamMember(dataTeamMember: DataTeamMember)

    @Update
    fun updateTeamMember(dataTeamMember: DataTeamMember)

    @Delete
    fun deleteTeamMember(dataTeamMember: DataTeamMember)

    @Query("SELECT * FROM DataTeamMember where teamMemberID=:memberId")
    fun getAllData(memberId:Int):List<DataTeamMember>
}

