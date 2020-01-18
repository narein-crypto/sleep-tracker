package com.example.sleeptracker

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface SleepDao {
    @Insert
    suspend fun insertSleep(sleep : Sleep)

    @Query("SELECT * FROM sleep")
    fun getSleep() : LiveData<List<Sleep>>

    @Query("SELECT * FROM sleep WHERE id = :sleep_id")
    fun getASleep(sleep_id: Int): Sleep

    @Update
    suspend fun updateSleep(sleep: Sleep)

    @Delete
    suspend fun deleteSleep(sleep: Sleep)

    @Query("DELETE FROM sleep WHERE id = :sleep_id")
    suspend fun deleteASleep(sleep_id: Int)
}