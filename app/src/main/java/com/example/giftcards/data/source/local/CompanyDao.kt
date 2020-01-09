package com.example.giftcards.data.source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.giftcards.domain.model.CompanyDTO
import io.reactivex.Single

@Dao
interface CompanyDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCompany(companies: List<CompanyDTO>)

    @Query("DELETE FROM company_table")
    fun deleteCompany()

    @Query("SELECT * from company_table")
    fun getCompany(): Single<List<CompanyDTO>>
}