package com.droiddevstar.newsapp.domain.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.droiddevstar.newsapp.domain.entity.User

@Dao
interface UserDao {

    @Insert
    fun addUser(user: User)

    @Delete
    fun deleteUSer(user: User)

    @Query("SELECT * FROM user WHERE email=:email")
    fun getUserByEmail(email: String): User?

    @Query("SELECT * FROM user WHERE email=:email and password=:password")
    fun login(
        email: String,
        password: String
    ): User?
}