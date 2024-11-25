package christmas.controller

import christmas.domain.Calendar
import christmas.domain.Customer
import christmas.domain.Pay
import christmas.view.InputView
import christmas.view.OutputView

class RestaurantController {
    private val inputView = InputView()
    private val outputView = OutputView()
    fun run() {
        inputView.helloMessage()
        val reserveDate = inputView.inputExceptedDayMessage()
        val rawOrders = inputView.inputOrderMessage()

        val customer = Customer(rawOrders)
        val calendar = Calendar(reserveDate.toInt())
        val pay = Pay(calendar, customer)


        outputView.printTotalResult(
            reserveDate = calendar.reserveDate,
            orders = customer.orders,
            beforeDiscountPrice = pay.beforeDiscountPrice(),
            christmasDiscount = pay.christmasDisCount(),
            weekdayDiscount = pay.weekDayDiscount(),
            weekendDiscount = pay.weekendDiscount(),
            specialDiscount = pay.specialDiscount(),
            totalDiscount = pay.totalDisCount(),
            afterDiscountPrice = pay.afterDiscountPrice(),
            batch = pay.getBatch(),
            freeEventDiscount = pay.freeEventDiscount()
        )


    }
}