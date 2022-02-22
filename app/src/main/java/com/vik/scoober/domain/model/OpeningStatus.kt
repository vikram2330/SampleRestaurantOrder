package com.vik.scoober.domain.model

sealed class OpeningStatus(val value: Int, val text: String)
object Open: OpeningStatus(0, "Open")
object OrderAhead: OpeningStatus(1,"Order ahead")
object Close: OpeningStatus(2, "Closed")
