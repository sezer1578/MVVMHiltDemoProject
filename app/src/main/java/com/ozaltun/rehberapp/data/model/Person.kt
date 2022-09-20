package com.ozaltun.rehberapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "persons")
data class Person(
    @PrimaryKey(autoGenerate = true)
    val personId: Int,
    val personName: String,
    val personNumber: String
) : Serializable
