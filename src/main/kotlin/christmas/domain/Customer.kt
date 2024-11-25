package christmas.domain

class Customer(rawOrders: String) {
    val order = rawOrders.split(',').map { menu ->
        val nameAndQuantity = menu.split('-')
        Menu(nameAndQuantity[0], nameAndQuantity[1].toInt())
    }

}