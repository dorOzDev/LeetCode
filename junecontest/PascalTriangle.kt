package leetcode.junecontest

fun main() {

    util.printList(PascalTriangle().generate(5))
}

class PascalTriangle {

    fun generate(numRows: Int): List<List<Int>> {

        val list = mutableListOf<List<Int>>()
        var prevList = listOf(1)

        list.add(prevList)
        for(i in 1 until numRows) {
            val row = mutableListOf<Int>()

            row.add(1)

            val iterator = prevList.listIterator()
            var prevElem = iterator.next()
            while(iterator.hasNext()) {
                val currElem = iterator.next()
                row.add(prevElem + currElem)
                prevElem = currElem
            }

            row.add(1)
            list.add(row)
            prevList = row
        }

        return list
    }
}