package com.wfprogramin.mvvmcomposewr.ui.welcome.core

import android.content.Context
import androidx.room.Room
import com.wfprogramin.mvvmcomposewr.ui.welcome.data.database.QuoteDatabase
import com.wfprogramin.mvvmcomposewr.ui.welcome.data.values.Const
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, QuoteDatabase::class.java, Const.QUOTE_DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideQuoteDao(db:QuoteDatabase) = db.getQuoteDao()
}