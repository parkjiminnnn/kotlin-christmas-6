package christmas.domain

import christmas.dto.MenuDto
import christmas.utils.MenuBoard

class Customer(rawOrders: String) {
    val orders = validateOrders(rawOrders)

    private fun validateQuantity(rawQuantity: String): Int {
        val quantity = rawQuantity.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.")
        if (quantity > 20) throw IllegalArgumentException("[ERROR] 메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다.")
        return quantity
    }

    private fun validateMenuName(menuName: String): String {
        val menuBoard = MenuBoard.entries.map { it.menuName }
        if (!menuBoard.contains(menuName)) throw IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.")
        return menuName
    }

    private fun validateDuplicateNames(rawOrders: String) {
        val menuNames = rawOrders.split(',').map { menu ->
            menu.split('-')[0]
        }
        if (menuNames.toSet().size != menuNames.size) throw IllegalArgumentException("[ERROR] 중복된 주문입니다. 다시 입력해 주세요.")
    }

    private fun validateOrders(rawOrders: String): List<MenuDto> {
        validateDuplicateNames(rawOrders)
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