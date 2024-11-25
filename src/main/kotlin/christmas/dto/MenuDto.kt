package christmas.dto

data class MenuDto(
    val menuName: String,
    val quantity:Int
) {
    override fun toString(): String {
        return "$menuName ${quantity}개"
    }
}
