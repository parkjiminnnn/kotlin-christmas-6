package christmas.domain

class Calendar(val reserveDate: Int) {
    private val weekend = listOf(1, 2, 8, 9, 15, 16, 22, 23, 29, 30)
    private val specialDays = listOf(3, 10, 17, 24, 25, 31)

    fun isWeekend(): Boolean {
        return weekend.contains(reserveDate)
    }

    fun isSpecialDay(): Boolean {
        return specialDays.contains(reserveDate)
    }
}