package id.ac.unand.e_kp.TugasBesarPribadi.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface InstansiDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addInstansi(instansi: Instansi)

    @Query("SELECT * FROM instansi_table ORDER BY id ASC")
    fun readAllData(): List<Instansi>

    @Query("SELECT * FROM instansi_table WHERE id LIKE :cariId LIMIT 1")
    fun findById(cariId: Int): Instansi

    @Query("DELETE FROM instansi_table")
    fun deleteAll()
}