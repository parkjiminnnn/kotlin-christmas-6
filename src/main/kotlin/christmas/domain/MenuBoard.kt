package christmas.domain

enum class MenuBoard(val menuType: String,val menuName: String, val price: Int) {
    MUSHROOMSOUP("애피타이저", "양송이수프", 6000),
    TAPAS("애피타이저", "타파스", 5500),
    CAESARSALAD("애피타이저", "시저샐러드", 8000),
    TONESTEAK("메인", "티본스테이크", 55000),
    BARBECUERIBS("메인", "바비큐립", 54000),
    SEAFOODPASTA("메인", "해산물파스타", 35000),
    CHRISTMASPASTA("메인", "크리스마스파스타", 25000),
    CHOCOLATECAKE("디저트", "초코케이크", 15000),
    ICECREAM("디저트", "아이스크림", 5000),
    ZEROCOKE("음료", "제로콜라", 3000),
    REDWINE("음료", "레드와인", 60000),
    CHAMPAGNE("음료", "샴페인", 25000)
}