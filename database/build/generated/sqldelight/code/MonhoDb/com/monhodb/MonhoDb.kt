package com.monhodb

import com.monhodb.Monho.newInstance
import com.monhodb.Monho.schema
import com.squareup.sqldelight.Transacter
import com.squareup.sqldelight.db.SqlDriver

public interface MonhoDb : Transacter {
  public val manhoQueries: ManhoQueries

  public companion object {
    public val Schema: SqlDriver.Schema
      get() = MonhoDb::class.schema

    public operator fun invoke(driver: SqlDriver): MonhoDb = MonhoDb::class.newInstance(driver)
  }
}
