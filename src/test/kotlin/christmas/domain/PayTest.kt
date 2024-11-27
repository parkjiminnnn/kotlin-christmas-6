package christmas.domain

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class PayTest {
    private val calendar = Calendar("3")
    private val customer = Customer("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1")
    private val pay = Pay(calendar, customer)

    @Test
    fun `크리스마스 할인 테스트`() {
        val excepted = -1200
        val result = pay.christmasDisCount()

        assertEquals(excepted, result)
    }

    @Test
    fun `주말 할인 테스트`() {
        val excepted = 0
        val result = pay.weekendDiscount()

        assertEquals(excepted, result)
    }

    @Test
    fun `평일 할인 테스트`() {
        val excepted = -4046
        val result = pay.weekDayDiscount()

        assertEquals(excepted, result)
    }

    @Test
    fun `특별 할인 테스트`() {
        val excepted = -1000
        val result = pay.specialDiscount()

        assertEquals(excepted, result)
    }

    @Test
    fun `할인 전 주문금엑 테스트`() {
        val excepted = 142000
        val result = pay.beforeDiscountPrice()

        assertEquals(excepted, result)
    }

    @Test
    fun `총 혜택 금액 테스트`() {
        val excepted = -31246
        val result = pay.totalDisCount()

        assertEquals(excepted, result)
    }

    @Test
    fun `증정 이벤트 테스트`() {
        val excepted = -25000
        val result = pay.freeEventDiscount()

        assertEquals(excepted, result)
    }

    @Test
    fun `증정 배지 테스트`() {
        val excepted = "산타"
        val result = pay.getBatch()

        assertEquals(excepted, result)
    }

    @Test
    fun `할인 후 예상 결제 금액 테스트`() {
        val excepted = 135754
        val result = pay.afterDiscountPrice()

        assertEquals(excepted, result)
    }
}