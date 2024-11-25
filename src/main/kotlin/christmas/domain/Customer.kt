package christmas.domain

class Customer(rawOrders: String) {
    val orders = rawOrders.split(',').map { menu ->
        val nameAndQuantity = menu.split('-')
        Menu(nameAndQuantity[0], nameAndQuantity[1].toInt())
    }

    fun getMatchedMenuBoard(): List<MenuBoard> {
        return orders.mapNotNull { menu ->
            MenuBoard.entries.find { menuBoard ->
                menu.menuName == menuBoard.menuName
            }
        }
    }
}