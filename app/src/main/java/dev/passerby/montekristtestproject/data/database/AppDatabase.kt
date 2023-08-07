package dev.passerby.montekristtestproject.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import dev.passerby.montekristtestproject.data.JsonConverters
import dev.passerby.montekristtestproject.data.models.db.PersonInfoDbModel
import dev.passerby.montekristtestproject.data.models.db.PlanetInfoDbModel
import dev.passerby.montekristtestproject.data.models.db.StarshipInfoDbModel

@Database(
    entities = [PersonInfoDbModel::class, PlanetInfoDbModel::class, StarshipInfoDbModel::class],
    version = 2,
    exportSchema = false
)
@TypeConverters(JsonConverters::class)
abstract class AppDatabase : RoomDatabase() {

    companion object {

        private var db: AppDatabase? = null
        private val LOCK = Any()
        private const val DB_NAME = "main.db"

        fun getInstance(context: Context): AppDatabase {
            synchronized(LOCK) {
                db?.let { return it }
                val instance = Room.databaseBuilder(
                    context, AppDatabase::class.java, DB_NAME
                ).fallbackToDestructiveMigration().build()
                db = instance
                return instance
            }
        }
    }

    //dao
    abstract fun personInfoDao(): PersonInfoDao
    abstract fun planetInfoDao(): PlanetInfoDao
    abstract fun starshipInfoDao(): StarshipInfoDao
}