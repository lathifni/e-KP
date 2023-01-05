package id.ac.unand.e_kp.TugasBesarPribadi.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Instansi::class], version = 1, exportSchema = false)
abstract class InstansiDatabase: RoomDatabase() {
    abstract fun instansiDao(): InstansiDao

    companion object{
        @Volatile
        private var INSTANCE: InstansiDatabase? = null

        fun getDatabase(context: Context): InstansiDatabase{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    InstansiDatabase::class.java,
                    "instansi_db"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}