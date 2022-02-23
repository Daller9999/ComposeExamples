package com.monhodb

import com.squareup.sqldelight.Query
import com.squareup.sqldelight.Transacter
import kotlin.Any
import kotlin.Int
import kotlin.String
import kotlin.Unit

public interface ManhoQueries : Transacter {
  public fun getGenres(): Query<String>

  public fun <T : Any> getHalls(mapper: (Name: String, SeatsCount: Int) -> T): Query<T>

  public fun getHalls(): Query<Halls>

  public fun <T : Any> getSessions(mapper: (
    MovieName: String,
    HallName: String,
    Start: String,
    End: String,
    OccupiedSeats: Int
  ) -> T): Query<T>

  public fun getSessions(): Query<Sessions>

  public fun <T : Any> getMovies(mapper: (
    Name: String,
    ProductYear: Int,
    Budget: Int,
    Country: String,
    RusFees: Int,
    AllFees: Int,
    GenreName: String,
    Time: Int
  ) -> T): Query<T>

  public fun getMovies(): Query<Movies>

  public fun insertGenre(Name: String): Unit

  public fun insertMovie(
    Name: String,
    ProductYear: Int,
    Budget: Int,
    Country: String,
    RusFees: Int,
    AllFees: Int,
    GenreName: String,
    Time: Int
  ): Unit

  public fun insertHall(Name: String, SeatsCount: Int): Unit

  public fun insertSession(
    MovieName: String,
    HallName: String,
    Start: String,
    End: String,
    OccupiedSeats: Int
  ): Unit
}
