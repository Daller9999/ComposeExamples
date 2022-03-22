package com.monhodb

import kotlin.String

public data class Genre(
  public val Name: String
) {
  public override fun toString(): String = """
  |Genre [
  |  Name: $Name
  |]
  """.trimMargin()
}
