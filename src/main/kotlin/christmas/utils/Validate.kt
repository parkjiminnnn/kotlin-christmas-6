//package christmas.utils
//
//import christmas.dto.MenuDto
//
//object Validate {
//
//    fun validateReserveDate(rawReserveDate: String): Int {
//        val reserveDate = rawReserveDate.toIntOrNull()
//        if (reserveDate == null || reserveDate !in 1..31)
//            throw IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.")
//
//        return reserveDate
//    }
//
//    private fun validateQuantity(rawQuantity: String): Int {
//        val quantity = rawQuantity.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.")
//        return quantity
//    }
//
//    private fun validateMenuName(menuName: String): String {
//        val menuBoard = MenuBoard.entries.map { it.menuName }
//        if (!menuBoard.contains(menuName)) throw IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.")
//        return menuName
//    }
//
//    fun validateOrders(rawOrders: String): List<MenuDto> {
//        return rawOrders.split(',').map { menu ->
//            val nameAndQuantity = menu.split('-')
//            MenuDto(validateMenuName(nameAndQuantity[0]), validateQuantity(nameAndQuantity[1]))
//        }
//    }
//}