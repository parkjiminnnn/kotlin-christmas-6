package christmas.controller

import christmas.domain.Calendar
import christmas.domain.Customer
import christmas.domain.Pay
import christmas.utils.Validate.validateOrders
import christmas.utils.Validate.validateReserveDate
import christmas.view.InputView
import christmas.view.OutputView

class RestaurantController {
    private val inputView = InputView()
    private val outputView = OutputView()
    fun run() {
        inputView.helloMessage()
        val calendar = inputReserveDate()

        val customer = inputOrders()

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

    private fun inputReserveDate(): Calendar {
        while (true) {
            try {
                val reserveDate = inputView.inputExceptedDayMessage()
                validateReserveDate(reserveDate)
                return Calendar(reserveDate)
            } catch (e: IllegalArgumentException) {
                println(e)
            }
        }
    }

    private fun inputOrders(): Customer {
        while (true) {
            try {
                val rawOrders = inputView.inputOrderMessage()
                validateOrders(rawOrders)
                return Customer(rawOrders)
            } catch (e: IllegalArgumentException) {
                println(e)
            }
        }
    }
}
