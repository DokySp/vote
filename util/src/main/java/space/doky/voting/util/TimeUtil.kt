package space.doky.voting.util

import java.text.SimpleDateFormat
import java.util.Date

object TimeUtil {
    fun getCurrentDisplayTime(): String {
        val dateFormat = "yyyy.MM.dd"
        // TODO: LocalDate로 변경
        val date = Date(System.currentTimeMillis())
        val simpleDateFormat = SimpleDateFormat(dateFormat)
        val simpleDate: String = simpleDateFormat.format(date)
        return simpleDate
    }
}