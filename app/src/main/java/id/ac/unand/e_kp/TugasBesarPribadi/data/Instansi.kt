package id.ac.unand.e_kp.TugasBesarPribadi.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "instansi_table")
data class Instansi(
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    val name: String,
    val address: String,
    val status: Int
)