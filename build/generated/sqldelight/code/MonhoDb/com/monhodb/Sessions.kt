package com.monhodb

import kotlin.Int
import kotlin.String

public data class Sessions(
  public val MovieName: String,
  public val HallName: String,
  public val Start: Int,
  public val End: Int,
  public val OccupiedSeats: Int
) {
  public override fun toString(): String = """
  |Sessions [
  |  MovieName: $MovieName
  |  HallName: $HallName
  |  Start: $Start
  |  End: $End
  |  OccupiedSeats: $OccupiedSeats
  |]
  """.trimMargin()
}
