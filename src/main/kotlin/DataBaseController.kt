import com.monhodb.Halls
import com.monhodb.MonhoDb
import com.monhodb.Movies
import com.monhodb.Sessions
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.sqlite.driver.asJdbcDriver
import com.zaxxer.hikari.HikariDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

// https://flaviocopes.com/mysql-how-to-install/

object DataBaseController {

    private val database = MonhoDb(getSqlDriver())
    private val queries = database.manhoQueries
    private val scope = CoroutineScope(Dispatchers.IO)

    fun init() {
        scope.launch {
            try {
                MonhoDb.Schema.create(getSqlDriver())
            } catch (ex: Exception) {
                ex.printStackTrace()
            }
        }
    }

    private fun getSqlDriver(): SqlDriver {
        val ds = HikariDataSource()
        ds.jdbcUrl = "jdbc:mysql://localhost:3306/monho"
        ds.driverClassName = "com.mysql.cj.jdbc.Driver"
        ds.username = "root"
        ds.password = "Macbook2019daler"
        return ds.asJdbcDriver()
    }

    fun addGenre(string: String) {
        scope.launch {
            queries.insertGenre(string)
        }
    }

    fun addMovie(
        name: String,
        year: String,
        budget: Int,
        country: String,
        moneyRu: Int,
        moneyWorld: Int,
        genre: String,
        time: Int
    ) {
        scope.launch {
            queries.insertMovie(name, year, budget, country, moneyRu, moneyWorld, genre, time)
        }
    }

    fun addHall(name: String, seatsCount: Int) {
        scope.launch {
            queries.insertHall(name, seatsCount)
        }
    }

    fun addSession(movieName: String, hallName: String, start: Int, end: Int, occupiedSeats: Int) {
        scope.launch {
            queries.insertSession(movieName, hallName, start, end, occupiedSeats)
        }
    }

    fun getGenres(): List<String> {
        return queries.getGenres().executeAsList()
    }

    fun getSessions(): List<Sessions> {
        return queries.getSessions().executeAsList()
    }

    fun getHalls(): List<Halls> {
        return queries.getHalls().executeAsList()
    }

    fun getMovies(): List<Movies> {
        return queries.getMovies().executeAsList()
    }

}