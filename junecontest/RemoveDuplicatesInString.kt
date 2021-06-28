package leetcode.junecontest

import java.util.*


fun main() {
    var str = Stack<Char>()
    print(str.peek())
}
class RemoveDuplicatesInString {

    fun removeDuplicates(s: String): String {

        val stack = Stack<Char>()

        for(char in s) {
            if(stack.isNotEmpty()) {
                if(char == stack.peek()) stack.pop()

                else stack.push(char)
            }
            else stack.push(char)
        }

        return createString(stack)
    }

    private fun createString(stack: Stack<Char>): String {
        val charArray = CharArray(stack.size)
        var index = stack.size - 1
        while(stack.isNotEmpty()) {
            charArray[index] = stack.pop()
            index--
        }

        return String(charArray)
    }
}