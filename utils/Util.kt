package leetcode.utils

object Util {
    fun <T> printList(list: List<T>) {

        for(elem in list) {
            print("{$elem }")
        }
        println()
    }

    fun <T> printArr(arr: Array<T>) {
        for(elem in arr) {
            print("{$elem }")
        }
        println()
    }
}
