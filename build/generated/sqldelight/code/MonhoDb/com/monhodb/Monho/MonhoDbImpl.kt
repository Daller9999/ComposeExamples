package com.monhodb.Monho

import com.monhodb.Halls
import com.monhodb.ManhoQueries
import com.monhodb.MonhoDb
import com.monhodb.Movies
import com.monhodb.Sessions
import com.squareup.sqldelight.Query
import com.squareup.sqldelight.TransacterImpl
import com.squareup.sqldelight.`internal`.copyOnWriteList
import com.squareup.sqldelight.db.SqlDriver
import kotlin.Any
import kotlin.Int
import kotlin.String
import kotlin.Unit
import kotlin.collections.MutableList
import kotlin.reflect.KClass

internal val KClass<MonhoDb>.schema: SqlDriver.Schema
  get() = MonhoDbImpl.Schema

internal fun KClass<MonhoDb>.newInstance(driver: SqlDriver): MonhoDb = MonhoDbImpl(driver)

private class MonhoDbImpl(
  driver: SqlDriver
) : TransacterImpl(driver), MonhoDb {
  public override val manhoQueries: ManhoQueriesImpl = ManhoQueriesImpl(this, driver)

  public object Schema : SqlDriver.Schema {
    public override val version: Int
      get() = 1

    public override fun create(driver: SqlDriver): Unit {
      driver.execute(null, """
          |CREATE TABLE Movies (
          |	Name TEXT NOT NULL ,
          |	ProductYear TEXT NOT NULL ,
          |	Budget INT NOT NULL ,
          |	Country TEXT NOT NULL ,
          |	RusFees INT NOT NULL ,
          |	AllFees INT NOT NULL ,
          |	GenreName TEXT NOT NULL ,
          |	Time INT NOT NULL
          |)
          """.trimMargin(), 0)
      driver.execute(null, """
          |CREATE TABLE Genre(
          |    Name Text NOT NULL
          |)
          """.trimMargin(), 0)
      driver.execute(null, """
          |CREATE TABLE Halls(
          |    Name TEXT NOT NULL,
          |    SeatsCount INT NOT NULL
          |)
          """.trimMargin(), 0)
      driver.execute(null, """
          |CREATE TABLE Sessions(
          |    MovieName TEXT NOT NULL,
          |    HallName TEXT NOT NULL,
          |    Start INT NOT NULL,
          |    End INT NOT NULL,
          |    OccupiedSeats INT NOT NULL
          |)
          """.trimMargin(), 0)
    }

    public override fun migrate(
      driver: SqlDriver,
      oldVersion: Int,
      newVersion: Int
    ): Unit {
    }
  }
}

private class ManhoQueriesImpl(
  private val database: MonhoDbImpl,
  private val driver: SqlDriver
) : TransacterImpl(driver), ManhoQueries {
  internal val getGenres: MutableList<Query<*>> = copyOnWriteList()

  internal val getHalls: MutableList<Query<*>> = copyOnWriteList()

  internal val getSessions: MutableList<Query<*>> = copyOnWriteList()

  internal val getMovies: MutableList<Query<*>> = copyOnWriteList()

  public override fun getGenres(): Query<String> = Query(-1755946227, getGenres, driver, "Manho.sq",
      "getGenres", "SELECT * FROM Genre") { cursor ->
    cursor.getString(0)!!
  }

  public override fun <T : Any> getHalls(mapper: (Name: String, SeatsCount: Int) -> T): Query<T> =
      Query(359800829, getHalls, driver, "Manho.sq", "getHalls", "SELECT * FROM Halls") { cursor ->
    mapper(
      cursor.getString(0)!!,
      cursor.getLong(1)!!.toInt()
    )
  }

  public override fun getHalls(): Query<Halls> = getHalls { Name, SeatsCount ->
    Halls(
      Name,
      SeatsCount
    )
  }

  public override fun <T : Any> getSessions(mapper: (
    MovieName: String,
    HallName: String,
    Start: Int,
    End: Int,
    OccupiedSeats: Int
  ) -> T): Query<T> = Query(40898842, getSessions, driver, "Manho.sq", "getSessions",
      "SELECT * FROM Sessions") { cursor ->
    mapper(
      cursor.getString(0)!!,
      cursor.getString(1)!!,
      cursor.getLong(2)!!.toInt(),
      cursor.getLong(3)!!.toInt(),
      cursor.getLong(4)!!.toInt()
    )
  }

  public override fun getSessions(): Query<Sessions> = getSessions { MovieName, HallName, Start,
      End, OccupiedSeats ->
    Sessions(
      MovieName,
      HallName,
      Start,
      End,
      OccupiedSeats
    )
  }

  public override fun <T : Any> getMovies(mapper: (
    Name: String,
    ProductYear: String,
    Budget: Int,
    Country: String,
    RusFees: Int,
    AllFees: Int,
    GenreName: String,
    Time: Int
  ) -> T): Query<T> = Query(-1574706432, getMovies, driver, "Manho.sq", "getMovies",
      "SELECT * FROM Movies") { cursor ->
    mapper(
      cursor.getString(0)!!,
      cursor.getString(1)!!,
      cursor.getLong(2)!!.toInt(),
      cursor.getString(3)!!,
      cursor.getLong(4)!!.toInt(),
      cursor.getLong(5)!!.toInt(),
      cursor.getString(6)!!,
      cursor.getLong(7)!!.toInt()
    )
  }

  public override fun getMovies(): Query<Movies> = getMovies { Name, ProductYear, Budget, Country,
      RusFees, AllFees, GenreName, Time ->
    Movies(
      Name,
      ProductYear,
      Budget,
      Country,
      RusFees,
      AllFees,
      GenreName,
      Time
    )
  }

  public override fun insertGenre(Name: String): Unit {
    driver.execute(727131473, """
    |INSERT INTO Genre (Name)
    |VALUES(?)
    """.trimMargin(), 1) {
      bindString(1, Name)
    }
    notifyQueries(727131473, {database.manhoQueries.getGenres})
  }

  public override fun insertMovie(
    Name: String,
    ProductYear: String,
    Budget: Int,
    Country: String,
    RusFees: Int,
    AllFees: Int,
    GenreName: String,
    Time: Int
  ): Unit {
    driver.execute(732977918, """
    |INSERT INTO Movies (Name, ProductYear, Budget, Country, RusFees, AllFees, GenreName, Time)
    |VALUES (?, ?, ?, ?, ?, ?, ?, ?)
    """.trimMargin(), 8) {
      bindString(1, Name)
      bindString(2, ProductYear)
      bindLong(3, Budget.toLong())
      bindString(4, Country)
      bindLong(5, RusFees.toLong())
      bindLong(6, AllFees.toLong())
      bindString(7, GenreName)
      bindLong(8, Time.toLong())
    }
    notifyQueries(732977918, {database.manhoQueries.getMovies})
  }

  public override fun insertHall(Name: String, SeatsCount: Int): Unit {
    driver.execute(1408955051, """
    |INSERT INTO Halls (Name, SeatsCount)
    |VALUES (?, ?)
    """.trimMargin(), 2) {
      bindString(1, Name)
      bindLong(2, SeatsCount.toLong())
    }
    notifyQueries(1408955051, {database.manhoQueries.getHalls})
  }

  public override fun insertSession(
    MovieName: String,
    HallName: String,
    Start: Int,
    End: Int,
    OccupiedSeats: Int
  ): Unit {
    driver.execute(758440676, """
    |INSERT INTO Sessions (MovieName, HallName, Start, End, OccupiedSeats)
    |VALUES(?, ?, ?, ?, ?)
    """.trimMargin(), 5) {
      bindString(1, MovieName)
      bindString(2, HallName)
      bindLong(3, Start.toLong())
      bindLong(4, End.toLong())
      bindLong(5, OccupiedSeats.toLong())
    }
    notifyQueries(758440676, {database.manhoQueries.getSessions})
  }
}
