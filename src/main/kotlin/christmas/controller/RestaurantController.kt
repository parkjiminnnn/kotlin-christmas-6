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
        val calendar = inputReserveDate()
        val customer = inputOrders()
        val pay = Pay(calendar, customer)

        displayResult(calendar, customer, pay)
    }

    private fun displayResult(calendar: Calendar, customer: Customer, pay: Pay) {
        printDiscountPreview(calendar)
        printOrderDetails(customer)
        printPriceDetails(pay)
        printDiscountDetails(pay)
        printSummary(pay)
    }

    private fun printDiscountPreview(calendar: Calendar) {
        outputView.discountPreviewMessage(calendar.reserveDate)
    }

    private fun printOrderDetails(customer: Customer) {
        outputView.printOrders(customer.orders)
    }

    private fun printPriceDetails(pay: Pay) {
        val beforeDiscountPrice = pay.beforeDiscountPrice()
        outputView.printBeforeDiscountPrice(beforeDiscountPrice)
        outputView.printFreeMenu(beforeDiscountPrice)
    }

    private fun printDiscountDetails(pay: Pay) {
        val christmasDiscount = pay.christmasDisCount()
        val weekdayDiscount = pay.weekDayDiscount()
        val weekendDiscount = pay.weekendDiscount()
        val specialDiscount = pay.specialDiscount()
        val freeEventDiscount = pay.freeEventDiscount()

        outputView.printDiscount(
            christmasDiscount, weekdayDiscount,
            weekendDiscount, specialDiscount, freeEventDiscount
        )
    }

    private fun printSummary(pay: Pay) {
        outputView.printTotalDiscount(pay.totalDisCount())
        outputView.printAfterDiscountPrice(pay.afterDiscountPrice())
        outputView.printEventBatch(pay.getBatch())
    }

    private fun inputReserveDate(): Calendar {
        while (true) {
            try {
                val reserveDate = inputView.inputExceptedDayMessage()
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
                return Customer(rawOrders)
            } catch (e: IllegalArgumentException) {
                println(e)
            }
        }
    }
}
