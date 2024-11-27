package christmas.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CalendarTest {

    @Test
    fun `예약 날짜가 숫자가 아니면 예외 발생`() {
        assertThrows<IllegalArgumentException> {
            Calendar("a")
        }
    }

    @Test
    fun `예약 날짜가 1-31이 아니면 예외 발생`() {
        assertThrows<IllegalArgumentException> {
            Calendar("0")
        }
    }


    @Test
    fun `주말이 맞는지 테스트`() {
        val calendar = Calendar("1")
        val excepted = true
        val result = calendar.isWeekend()

        assertEquals(excepted, result)
    }

    @Test
    fun `특별 할인 데이가 맞는지 테스트`() {
        val calendar = Calendar("3")
        val excepted = true
        val result = calendar.isSpecialDay()

        assertEquals(excepted, result)
    }
}
