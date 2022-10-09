class Gamer(_countCards: Int) {
    private val countCards = _countCards
    val cards = List(countCards) { Card() }
}