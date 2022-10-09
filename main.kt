import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

suspend fun main() {
    var gameOver = false
    var countCards = 0
    println("Игра ЛОТО\n" +
            "В игре принимают участие три игрока\n" +
            "У каждого игрока может быть несколько карточек\n" +
            "Для удобства зрительного восприятия в консоль выводится информация только о карточках №1 каждого игрока\n" +
            "Введите количество карточек у игроков")
    while (countCards <= 0) {
        var n = readLine()?.toIntOrNull() ?: return
        countCards = n
        if (n > 0) break
        println("Введенное число меньше или равно 0, введите число больше 0")
    }

    runBlocking {
        launch {
            val gamer1 = Gamer(countCards)
            Generator.sharedFlow.takeWhile { !gameOver }.collect {
                val number = it
                println("Игрок 1 отмечает номер $number")
                println(gamer1.cards[0].card.slice(0..8))
                println(gamer1.cards[0].card.slice(9..17))
                println(gamer1.cards[0].card.slice(18..26))
                for (q in 0 until countCards) {
                    for (i in 0..26) {
                        if (gamer1.cards[q].card[i] == number) gamer1.cards[q].card[i] = 0
                    }
                    if (gamer1.cards[q].card.sum() == 0) {
                        println("Победил игрок 1, билет №${q + 1}")
                        gameOver = true
                    }
                    delay(10)
                }
            }
        }

        launch {
            val gamer2 = Gamer(countCards)
            Generator.sharedFlow.takeWhile { !gameOver }.collect {
                val number = it
                println("Игрок 2 отмечает номер $number")
                println(gamer2.cards[0].card.slice(0..8))
                println(gamer2.cards[0].card.slice(9..17))
                println(gamer2.cards[0].card.slice(18..26))
                for (q in 0 until countCards) {
                    for (i in 0..26) {
                        if (gamer2.cards[q].card[i] == number) gamer2.cards[q].card[i] = 0
                    }
                    if (gamer2.cards[q].card.sum() == 0) {
                        println("Победил игрок 2, билет №${q + 1}")
                        gameOver = true
                    }
                    delay(10)
                }
            }
        }
        launch {
            val gamer3 = Gamer(countCards)
            Generator.sharedFlow.takeWhile { !gameOver }.collect {
                val number = it
                println("Игрок 3 отмечает номер $number")
                println(gamer3.cards[0].card.slice(0..8))
                println(gamer3.cards[0].card.slice(9..17))
                println(gamer3.cards[0].card.slice(18..26))
                for (q in 0 until countCards) {
                    for (i in 0..26) {
                        if (gamer3.cards[q].card[i] == number) gamer3.cards[q].card[i] = 0
                    }
                    if (gamer3.cards[q].card.sum() == 0) {
                        println("Победил игрок 3, билет №${q + 1}")
                        gameOver = true
                    }
                    delay(10)
                }
            }
        }
    }
}