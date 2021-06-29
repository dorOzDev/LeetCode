package leetcode.junecontest

import kotlin.system.measureTimeMillis

fun main() {

    val permutations: List<String>
    val timeInMils = measureTimeMillis {
        val n = 8
        permutations = GenerateParentheses().generateParenthesis(n)
    }

    println(permutations)
    println(timeInMils)

}

class GenerateParentheses {

    companion object {
        private const val CLOSING_PARENTHESES = ')'
        private const val OPEN_PARENTHESES = '('
    }

    fun generateParenthesis(n: Int): List<String> {

        val list = mutableListOf<String>()
        generate(n, 0, "", list)
        return list
    }

    private fun generate(openParenthesisCount: Int, closeParenthesisCount: Int, str: String, list: MutableList<String>){

        if(openParenthesisCount == 0 && closeParenthesisCount == 0) list.add(str)

        if(openParenthesisCount > 0) {
            generate(openParenthesisCount - 1, closeParenthesisCount + 1, str + OPEN_PARENTHESES, list)
        }

        if(closeParenthesisCount > 0) {
            generate(openParenthesisCount, closeParenthesisCount - 1, str + CLOSING_PARENTHESES, list)
        }
    }
}