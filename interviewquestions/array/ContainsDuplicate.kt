package interviewquestions.array

class ContainsDuplicate {

    fun containsDuplicate(numbers: IntArray): Boolean {

        val set = mutableSetOf<Int>()
        for(num in numbers) {
            if(set.contains(num)) return true
            set.add(num)
        }

        return false
    }
}

