package christmas.domain

import christmas.dto.MenuDto
import christmas.utils.MenuBoard

class Customer(rawOrders: String) {
    val orders = validateOrders(rawOrders)

    private fun validateQuantity(rawQuantity: String): Int {
        val quantity = rawQuantity.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.")
        return quantity
    }

    private fun validateMenuName(menuName: String): String {
        val menuBoard = MenuBoard.entries.map { it.menuName }
        if (!menuBoard.contains(menuName)) throw IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.")
        return menuName
    }

    private fun validateOrders(rawOrders: String): List<MenuDto> {
        return rawOrders.split(',').map { menu ->
            val nameAndQuantity = menu.split('-')
            MenuDto(validateMenuName(nameAndQuantity[0]), validateQuantity(nameAndQuantity[1]))
        }
    }

    fun getMatchedMenuBoard(): List<MenuBoard> {
        return orders.mapNotNull { menu ->
            MenuBoard.entries.find { menuBoard ->
                menu.menuName == menuBoard.menuName
            }
        }
    }
}