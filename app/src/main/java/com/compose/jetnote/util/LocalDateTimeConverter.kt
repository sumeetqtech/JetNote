package com.compose.jetnote.util

import androidx.room.TypeConverter
import org.threeten.bp.LocalDateTime
import org.threeten.bp.format.DateTimeFormatter

class LocalDateTimeConverter {
    private val formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME

    @TypeConverter
    fun fromLocalDateTime(dateTime: LocalDateTime?): String? = dateTime?.format(formatter)

    @TypeConverter
    fun toLocalDateTime(dateTime: String?): LocalDateTime? =
        dateTime?.let { LocalDateTime.parse(it, formatter) }
}