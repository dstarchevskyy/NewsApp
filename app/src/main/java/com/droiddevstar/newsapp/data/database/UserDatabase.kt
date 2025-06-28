package com.droiddevstar.newsapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.droiddevstar.newsapp.domain.dao.UserDao
import com.droiddevstar.newsapp.domain.entity.User

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class UserDatabase: RoomDatabase() {
    abstract fun getUserDao(): UserDao
}