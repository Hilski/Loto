class Card {

    var card = mutableListOf<Int>()

    init {
        //Получаем 15 уникальных чисел для карточки
        val setNumber = mutableSetOf<Int>()
        while (setNumber.size < 15) {
            setNumber.add((1..90).random())
        }
        val toListNumber = setNumber.toList()
        //Создаем три строки карточки
        val clearCardLine1 = MutableList<Int>(4) { 0 }
        val clearCardLine2 = MutableList<Int>(4) { 0 }
        val clearCardLine3 = MutableList<Int>(4) { 0 }
        //Добавляем в них сгенерированные числа
        for (i in 0..4) clearCardLine1.add(toListNumber[i])
        for (i in 5..9) clearCardLine2.add(toListNumber[i])
        for (i in 10..14) clearCardLine3.add(toListNumber[i])
        //Перемешиваем
        val shuffledClearCardLine1 = clearCardLine1.shuffled()
        val shuffledClearCardLine2 = clearCardLine2.shuffled()
        val shuffledClearCardLine3 = clearCardLine3.shuffled()
        //Создаем карточку
        card.addAll(shuffledClearCardLine1 + shuffledClearCardLine2 + shuffledClearCardLine3)
    }
}