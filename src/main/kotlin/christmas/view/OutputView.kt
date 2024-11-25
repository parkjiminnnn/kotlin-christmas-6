package christmas.view

import christmas.dto.MenuDto

class OutputView {
    private fun discountPreviewMessage(reserveDate: Int) {
        println("12월 ${reserveDate}일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n")
    }

    private fun printOrders(orders: List<MenuDto>) {
        println("<주문 메뉴>")
        orders.forEach { menuDto ->
            println(menuDto.toString())
        }
        println()
    }

    private fun printBeforeDiscountPrice(beforeDiscountPrice: Int) {
        println("<할인 전 총주문 금액>")
        println("${beforeDiscountPrice}원\n")
    }

    private fun printFreeMenu(beforeDiscountPrice: Int) {
        println("<증정 메뉴>")
        if (beforeDiscountPrice >= 120000) return println("샴페인 1개\n")
        return println("없음\n")

    }

    private fun printDiscount(
        christmasDiscount: Int,
        weekdayDiscount: Int,
        weekendDiscount: Int,
        specialDiscount: Int,
        freeEventDiscount: Int
    ) {
        println("<혜택 내역>")
        if (christmasDiscount != 0) println("크리스마스 디데이 할인: ${christmasDiscount}원")
        weekDiscount(weekdayDiscount, weekendDiscount)
        if (specialDiscount != 0) println("특별 할인: ${specialDiscount}원")
        if (freeEventDiscount != 0) println("증정 이벤트: ${freeEventDiscount}원") else println("없음")
        isDiscount(christmasDiscount, weekdayDiscount, weekendDiscount, specialDiscount, freeEventDiscount)
    }

    private fun weekDiscount(weekdayDiscount: Int, weekendDiscount: Int) {
        if (weekdayDiscount != 0) println("평일 할인: ${weekdayDiscount}원")
        if (weekendDiscount != 0) println("주말 할인:${weekendDiscount}원")
    }

    private fun isDiscount(
        christmasDiscount: Int,
        weekdayDiscount: Int,
        weekendDiscount: Int,
        specialDiscount: Int,
        freeEventDiscount: Int
    ) {
        if (christmasDiscount != 0 && weekdayDiscount != 0 && weekendDiscount != 0 &&
            specialDiscount != 0 && freeEventDiscount == 0
        ) println("0원")
        println()
    }

    private fun printTotalDiscount(totalDiscount: Int) {
        println("<총혜택 금액>")
        println("${totalDiscount}원\n")
    }

    private fun printAfterDiscountPrice(afterDiscountPrice: Int) {
        println("<할인 후 예상 결제 금액>")
        println("${afterDiscountPrice}원\n")
    }

    private fun printEventBatch(batch: String) {
        println("<12월 이벤트 배지>")
        println(batch)
    }

    fun printTotalResult(
        reserveDate: Int,
        orders: List<MenuDto>,
        beforeDiscountPrice: Int,
        christmasDiscount: Int,
        weekdayDiscount: Int,
        weekendDiscount: Int,
        specialDiscount: Int,
        freeEventDiscount: Int,
        totalDiscount: Int,
        afterDiscountPrice: Int,
        batch: String
    ) {
        discountPreviewMessage(reserveDate)
        printOrders(orders)
        printBeforeDiscountPrice(beforeDiscountPrice)
        printFreeMenu(beforeDiscountPrice)
        printDiscount(christmasDiscount, weekdayDiscount, weekendDiscount, specialDiscount, freeEventDiscount)
        printTotalDiscount(totalDiscount)
        printAfterDiscountPrice(afterDiscountPrice)
        printEventBatch(batch)
    }
}