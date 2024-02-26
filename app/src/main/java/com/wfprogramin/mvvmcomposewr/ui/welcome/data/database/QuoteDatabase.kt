package com.wfprogramin.mvvmcomposewr.ui.welcome.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.wfprogramin.mvvmcomposewr.ui.welcome.data.database.dao.QuoteDao
import com.wfprogramin.mvvmcomposewr.ui.welcome.data.database.entities.QuoteEntity


@Database(entities = [QuoteEntity::class], version = 1)
abstract class QuoteDatabase : RoomDatabase(){

    abstract fun getQuoteDao():QuoteDao
}