package com.example.core_db_impl.data

import androidx.room.*
import com.example.core_utils.domain.model.CompanyDTO
import kotlinx.coroutines.flow.Flow

@Dao
interface CompanyDao {

    @Transaction
    suspend fun replaceCompany(companies: List<CompanyDTO>) {
        deleteCompany()
        insertCompany(companies)
    }

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCompany(companies: List<CompanyDTO>)

    @Query("DELETE FROM company_table")
    suspend fun deleteCompany()

    @Query("SELECT * from company_table")
    fun getCompany(): Flow<List<CompanyDTO>>
}