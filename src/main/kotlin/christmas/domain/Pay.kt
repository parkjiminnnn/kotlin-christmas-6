package christmas.domain

class Pay(private val calendar: Calendar, private val customer: Customer) {
    private val reserveDate = calendar.reserveDate
    private val matchedMenuBoard = customer.getMatchedMenuBoard()

    fun christmasDisCount(): Int {
        if (reserveDate in 1..25) {
            return -(1000 + (reserveDate - 1) * 100)
        }
        return 0
    }

     fun weekendDiscount(): Int {
        val mainQuantitySum = customer.orders.filter { order ->
            matchedMenuBoard.any { menuBoard ->
                menuBoard.menuType == "메인" && menuBoard.menuName == order.menuName
            }
        }.sumOf { it.quantity }
        if (calendar.isWeekend()) {
            return -(mainQuantitySum * 2023)
        }
        return 0
    }

    fun weekDayDiscount(): Int {
        val dessertQuantitySum = customer.orders.filter { order ->
            matchedMenuBoard.any { menuBoard ->
                menuBoard.menuType == "디저트" && menuBoard.menuName == order.menuName
            }
        }.sumOf { it.quantity }
        if (!calendar.isWeekend()) {
            return -(dessertQuantitySum * 2023)
        }
        return 0
    }

    fun specialDiscount(): Int {
        if (calendar.isSpecialDay()) return -1000
        return 0
    }

    fun beforeDiscountPrice(): Int {
        val menuPrices = matchedMenuBoard
        var totalPrice = 0
        customer.orders.forEachIndexed { index, menu ->
            totalPrice += menu.quantity * menuPrices[index].price
        }
        return totalPrice
    }

    fun totalDisCount(): Int {
        return weekendDiscount() + weekDayDiscount() + specialDiscount() + christmasDisCount() + freeEventDiscount()
    }

    fun freeEventDiscount(): Int {
        if (beforeDiscountPrice() >= 120000) return -25000
        return 0
    }

    fun getBatch(): String {
        val totalDiscount = -totalDisCount()
        return when {
            totalDiscount in 5000 until 10000 -> "별"
            totalDiscount in 10000 until 20000 -> "트리"
            totalDiscount >= 20000 -> "산타"
            else -> "없음"
        }
    }

    fun afterDiscountPrice(): Int {
        return beforeDiscountPrice() + totalDisCount()

    }
}