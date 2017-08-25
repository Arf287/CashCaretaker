package com.adammcneilly.cashcaretaker.daos

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.adammcneilly.cashcaretaker.entities.Account
import io.reactivex.Flowable

/**
 * Database access for Account entities.
 */
@Dao
interface AccountDAO {
    @Query("SELECT * FROM account")
    fun getAll(): Flowable<List<Account>>

    @Insert
    fun insert(accounts: List<Account>): List<Long>

    @Delete
    fun delete(account: Account): Int
}