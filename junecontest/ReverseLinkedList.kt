package leetcode.junecontest

import java.util.*

fun main() {

    val arr = arrayOf(1, 2, 3, 4, 5)
    val left = 2
    val right = 4

    val node = ReverseLinkedList().reverseBetween(createList(arr), left, right)
    printList(node)
}
// For testing
fun createList(arr: Array<Int>): ReverseLinkedList.ListNode {
    val head = ReverseLinkedList.ListNode(arr[0])
    var itr: ReverseLinkedList.ListNode? = head

    for(i in 1 until arr.size) {
        itr?.next = ReverseLinkedList.ListNode(arr[i])
        itr = itr?.next
    }

    return head
}
// For testing
fun printList(node: ReverseLinkedList.ListNode?) {
    var temp = node
    while(temp != null) {
        print("${temp.`val`} ")
        temp = temp.next
    }

    println()
}

class ReverseLinkedList {

    fun reverseBetween(head: ListNode?, left: Int, right: Int): ListNode? {

        val myLeft=  left - 1
        val myRight = right - 1
        var itr = head
        val stack = Stack<ListNode?>()
        val mid = (myLeft + myRight) / 2

        for(i in 0 until myLeft) {
            itr = itr?.next
        }

        for(i in myLeft..myRight) {
            when {
                i < mid -> {
                    stack.push(itr)
                }
                i > mid -> {
                    val leftNode = stack.pop()
                    val temp = itr?.`val` ?: 600
                    itr?.`val` = leftNode?.`val` ?: 600
                    leftNode?.`val` = temp
                }
                i == mid && ((myRight - myLeft + 1) % 2) == 0 -> {
                    stack.push(itr)
                }
            }

            itr = itr?.next
        }

        return head
    }

    class ListNode(var `val`: Int) {
        var next: ListNode? = null


    }
}