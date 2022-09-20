package com.ozaltun.rehberapp.domain.room.database

import androidx.room.Database

import androidx.room.RoomDatabase
import com.ozaltun.rehberapp.data.model.Person
import com.ozaltun.rehberapp.domain.room.dao.PersonDao

@Database(entities = [Person::class], version = 1, exportSchema = false)
abstract class PersonDatabase : RoomDatabase() {

    abstract fun getPersonDao(): PersonDao
}