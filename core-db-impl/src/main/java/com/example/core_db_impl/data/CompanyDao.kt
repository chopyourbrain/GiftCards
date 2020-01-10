package com.example.core_db_impl.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.core_utils.domain.model.CompanyDTO
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