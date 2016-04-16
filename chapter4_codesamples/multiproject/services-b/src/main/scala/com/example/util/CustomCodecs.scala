package com.example.util

import java.util.UUID

import com.github.mauricio.async.db.RowData

trait CustomCodecs {
  implicit val uuidEncoder = new Database.db.Encoder[UUID] {
    def apply(index: Int, value: UUID, row: List[Any]) =
      row :+ value
  }

  implicit val uuidDecoder = new Database.db.Decoder[UUID] {
    def apply(index: Int, row: RowData): UUID = row(index) match {
      case value: UUID => value
    }
  }

}

