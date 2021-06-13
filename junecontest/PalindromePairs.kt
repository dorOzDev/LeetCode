package leetcode.junecontest


fun main() {

    val array = arrayOf("abcd","dcba","lls","s","sssll")
    print(PalindromePairs().palindromePairs(array))
}
class PalindromePairs {

    fun palindromePairs(words: Array<String>): List<List<Int>> {

        val indicesList = mutableListOf<List<Int>>()

        for(i in 0 until words.size - 1) {
            for(j in i + 1 until words.size) {
                if(isPalindrome(words[i] + words[j])) {
                    indicesList.add(listOf(i, j))
                }

                if(isPalindrome(words[j] + words[i])) {
                    indicesList.add(listOf(j, i))
                }
            }
        }

        return indicesList
    }

    private fun isPalindrome(str: String): Boolean {

        val size = str.length - 1

        for(i in 0 until str.length / 2) {
            if(str[i] != str[size - i]) return  false
        }

        return true;
    }
}