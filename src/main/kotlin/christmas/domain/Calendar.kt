package christmas.domain

class Calendar(rawReserveDate: String) {
    private val weekend = listOf(1, 2, 8, 9, 15, 16, 22, 23, 29, 30)
    private val specialDays = listOf(3, 10, 17, 24, 25, 31)
    val reserveDate = validateReserveDate(rawReserveDate)

    private fun validateReserveDate(rawReserveDate: String): Int {
        val reserveDate = rawReserveDate.toIntOrNull()
        if (reserveDate == null || reserveDate !in 1..31)
            throw IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.")

        return reserveDate
    }

    fun isWeekend(): Boolean {
        return weekend.contains(reserveDate)
    }

    fun isSpecialDay(): Boolean {
        return specialDays.contains(reserveDate)
    }
}