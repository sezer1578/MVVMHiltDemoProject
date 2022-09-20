package com.ozaltun.rehberapp.domain.room.dao

import androidx.room.*
import com.ozaltun.rehberapp.data.model.Person

@Dao
interface PersonDao {

    @Query("SELECT * FROM persons")
    suspend fun getAllPersons(): List<Person>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPerson(person: Person)

    @Query("SELECT * FROM persons WHERE personName like '%' || :word || '%'")
    fun searchPerson(word: String): List<Person>

    @Update
    suspend fun updatePerson(person: Person)

    @Delete
    suspend fun deletePerson(person: Person)

}