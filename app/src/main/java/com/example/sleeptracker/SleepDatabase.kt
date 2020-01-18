package com.example.sleeptracker

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Sleep::class], version = 1)
abstract class SleepDatabase: RoomDatabase(){
    //Create an instance of the DAO
    abstract fun sleepDao() : SleepDao

    companion object{
        //Create an instance of the RoomDatabase
        /*The Singleton Pattern guarantees a class has one instance only and
        a global point of access to it is provided by that class.Anytime
        multiple classes or clients request for that class,
        they get the same instance of the class.*/
        //Singleton prevents multiple instances of the database
        @Volatile
        private var INSTANCE : SleepDatabase? = null

        fun getDatabase(context: Context) : SleepDatabase{
            val tempDB = INSTANCE
            if(tempDB!= null){
                return tempDB
            }

            //we create an instance of the Database here
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    SleepDatabase::class.java,
                    "sleep_db"
                ).build()
                INSTANCE = instance

                return instance
            }
        }
    }
}