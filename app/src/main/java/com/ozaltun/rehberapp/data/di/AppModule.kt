package com.ozaltun.rehberapp.data.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ozaltun.rehberapp.data.repository.PersonRepository
import com.ozaltun.rehberapp.domain.room.dao.PersonDao
import com.ozaltun.rehberapp.domain.room.database.PersonDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun providePersonRepository(personDao: PersonDao): PersonRepository {
        return PersonRepository(personDao)
    }

    @Provides
    @Singleton
    fun providePersonDao(@ApplicationContext context:Context) : PersonDao{

        val db = Room.databaseBuilder(context,PersonDatabase::class.java,"persons").allowMainThreadQueries().build()
        return db.getPersonDao()
    }
}