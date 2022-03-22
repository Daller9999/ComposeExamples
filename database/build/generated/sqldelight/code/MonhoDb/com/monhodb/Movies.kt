package com.monhodb

import kotlin.Int
import kotlin.String

public data class Movies(
  public val Name: String,
  public val ProductYear: Int,
  public val Budget: Int,
  public val Country: String,
  public val RusFees: Int,
  public val AllFees: Int,
  public val GenreName: String,
  public val Time: Int
) {
  public override fun toString(): String = """
  |Movies [
  |  Name: $Name
  |  ProductYear: $ProductYear
  |  Budget: $Budget
  |  Country: $Country
  |  RusFees: $RusFees
  |  AllFees: $AllFees
  |  GenreName: $GenreName
  |  Time: $Time
  |]
  """.trimMargin()
}
