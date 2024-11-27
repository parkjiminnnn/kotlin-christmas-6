package christmas.domain

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import christmas.main
import christmas.utils.MenuBoard
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.assertThrows

class CustomerTest : NsTest() {

    @Test
    fun `올바르지 않은 주문 입력시 예외 발생`() {
        assertThrows<IllegalArgumentException> {
            Customer("라면-1")
        }
    }

    @Test
    fun `중복 주문 입력시 예외 발생`() {
        assertSimpleTest {
            runException("3", "티본스테이크-2,티본스테이크-1")
            assertThat(output()).contains("[ERROR] 중복된 주문입니다. 다시 입력해 주세요.")
        }
    }

    @Test
    fun `주문범위 초과시 예외 발생`() {
        assertSimpleTest {
            runException("3", "티본스테이크-21")
            assertThat(output()).contains("[ERROR] 메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다.")
        }
    }

    @Test
    fun `메뉴판에 없는 주문입력시 예외 발생`() {
        assertSimpleTest {
            runException("3", "라면-1")
            assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.")
        }
    }

    @Test
    fun getMatchedMenuBoard() {
        val excepted = listOf(MenuBoard.TAPAS, MenuBoard.ICECREAM)
        val result = Customer("타파스-1,아이스크림-1").getMatchedMenuBoard()

        assertEquals(excepted, result)
    }

    override fun runMain() {
        main()
    }
}