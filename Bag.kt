class Bag {
    var bagList = mutableListOf<Int>()
    private val bagSet = mutableSetOf<Int>()

    init {
        while (bagSet.size < 90) {
            bagSet.add((1..90).random())
        }
        bagList = bagSet.toMutableList()
    }

    fun pop(): Int {
        return bagList.removeAt(bagList.lastIndex)
    }
}