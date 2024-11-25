package christmas.domain

class Pay(private val calendar: Calendar, private val customer: Customer) {
    private val reserveDate = calendar.reserveDate
    private val matchedMenuBoard = customer.getMatchedMenuBoard()

    fun christmasDisCount(): Int {
        if (reserveDate in 1..25) {
            return 1000 + (reserveDate - 1) * 100
        }
        return 0
    }

    fun weekendDiscount(): Int {
        val menuNames = matchedMenuBoard.map { it.menuName }
        if (calendar.isWeekend()) {
            val count = menuNames.count { it.contains("메인") }
            return -(count * 2023)
        }
        return 0
    }

    fun weekDayDiscount(): Int {
        val menuNames = matchedMenuBoard.map { it.menuName }
        val count = menuNames.count { it.contains("디저트") }
        if (!calendar.isWeekend()) {
            return -(count * 2023)
        }
        return 0
    }

    fun specialDiscount(): Int {
        if (calendar.isSpecialDay()) return -1000
        return 0
    }

    private fun totalOrderPrice(): Int {
        val menuPrices = matchedMenuBoard
        var totalPrice = 0
        customer.orders.forEachIndexed { index, menu ->
            totalPrice += menu.quantity * menuPrices[index].price
        }
        return totalPrice
    }

    fun totalDisCount(): Int {
        return weekendDiscount() + weekDayDiscount() + specialDiscount() + christmasDisCount()
    }
}