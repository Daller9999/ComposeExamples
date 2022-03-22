package com.monhodb

import kotlin.Int
import kotlin.String

public data class Halls(
  public val Name: String,
  public val SeatsCount: Int
) {
  public override fun toString(): String = """
  |Halls [
  |  Name: $Name
  |  SeatsCount: $SeatsCount
  |]
  """.trimMargin()
}
