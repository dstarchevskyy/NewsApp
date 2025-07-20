package com.droiddevstar.newsapp.util

import android.os.Build
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle
import java.util.*

class DateTimeUtil {
    companion object {
        fun formatDateTimeToHumanReadable(dateTimeString: String?): String? {
            return try {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    // For Android O and above (API 26+)
                    val parser: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS")
                    val formatter: DateTimeFormatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)

                    val localDateTime: LocalDateTime = LocalDateTime.parse(dateTimeString, parser)
                    val zonedDateTime: ZonedDateTime = ZonedDateTime.of(localDateTime, ZoneId.systemDefault())

                    zonedDateTime.format(formatter)
                } else {
                    // For older Android versions
                    val parser = SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSS", Locale.getDefault())
                    val formatter: DateFormat = SimpleDateFormat.getDateTimeInstance(
                        SimpleDateFormat.MEDIUM,
                        SimpleDateFormat.MEDIUM,
                        Locale.getDefault()
                    )

                    val date: Date? = parser.parse(dateTimeString ?: return null)
                    formatter.format(date ?: Calendar.getInstance().time)
                }
            } catch (e: Exception) {
                null
            }
        }
    }
}