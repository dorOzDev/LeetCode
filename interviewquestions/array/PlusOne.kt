package interviewquestions.array

class PlusOne {

    fun plusOne(digits: IntArray): IntArray {

        if(allNines(digits)) return getThousandMultiplyArray(digits.size)

        var carry = 1
        for(i in digits.size - 1 downTo 0) {
            digits[i] += carry
            carry = digits[i] / 10
            digits[i] %= 10
        }

        return digits
    }

    private fun getThousandMultiplyArray(size: Int): IntArray {
        val arr = IntArray(size + 1) { 0 }
        arr[0] = 1

        return arr
    }


    private fun allNines(digits: IntArray): Boolean {

        for(elem in digits) {
            if(elem != 9) return false
        }

        return true
    }
}