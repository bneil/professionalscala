package com.example.util

import io.getquill.naming.SnakeCase
import io.getquill.source.async.postgres.PostgresAsyncSource

object Database {
  object db extends PostgresAsyncSource[SnakeCase]
}

