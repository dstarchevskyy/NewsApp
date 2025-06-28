package com.droiddevstar.newsapp.data.repository

import com.droiddevstar.newsapp.domain.dao.UserDao
import com.droiddevstar.newsapp.domain.entity.User
import javax.inject.Inject
import com.droiddevstar.newsapp.util.Result
import com.droiddevstar.newsapp.util.Result.*
import java.util.UUID

class AuthRepository @Inject constructor(
    private val userDao: UserDao
) {
    suspend fun login(
        email: String,
        password: String
    ): Result {
        val loginUser: User? = userDao.login(
            email = email,
            password = password
        )

        val result = if (loginUser == null) {
            Failure<Unit>("Login failure. Check creadentials", null)
        } else {
            Success<Unit>("Success")
        }

        return result
    }

    suspend fun register(
        email: String,
        password: String,
        userName: String
    ): Result {
        if (userDao.getUserByEmail(email = email) != null) {
            return Failure<Unit>("User already exists")
        }

        val user = User(
            id = UUID.randomUUID().toString(),
            userName = userName,
            email = email,
            password = password
        )
        userDao.addUser(user = user)
        return Success<Unit>("success register")
    }
}