package leetcode.julycontest.weekthree

import leetcode.julycontest.weekthree.ReverseNodesInKGroups.ListNode

fun main() {

    val head = ListNode(1)
    var temp = head
    for(i in 2..6) {
        temp.next = ListNode(i)
        temp = temp.next ?: temp
    }

    val k = 2
    val list = ReverseNodesInKGroups().reverseKGroup(head, k)
    list.print()
}

class ReverseNodesInKGroups {

    fun reverseKGroup(head: ListNode, k: Int): ListNode {
        // Simple optimization if k == 1 the solution is running at time and space complexity of O(1)
        // Other wise the solution is time complexity of O(n) and space complexity of O(1)
        if(k == 1) return head
        val listSize = head.count()
        var newHead = head
        var node = Node(head, head)
        // Reverse sublist
        for(i in 0 until (listSize / k)) {
            if(i == 0) {
                node = reverseSubList(node.head, k)
                newHead = node.head
            }
            else {
                val nextHead = node.tail.next ?: node.tail
                val nextNode = reverseSubList(nextHead, k)

                node.tail.next = nextNode.head
                node = nextNode
            }
        }

        return newHead
    }

    // Returns the new head of the sub list
    private fun reverseSubList(head: ListNode, k: Int): Node {

        var curr = head
        var next = curr.next
        var i = 1
        while (next != null && i < k) {
            val tempNext = next.next
            next.next = curr
            curr = next
            next = tempNext
            ++i
        }
        head.next = next
        return Node(curr, head)
    }

    data class Node(val head: ListNode, val tail: ListNode)

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }
}

fun ListNode.print() {

    var temp: ListNode? = this

    while(temp != null) {
        print("${temp.`val`} ")
        temp = temp.next
    }
    println()
}

fun ListNode.count(): Int {

    var count = 0
    var temp: ListNode? = this

    while(temp != null) {
        count++
        temp = temp.next
    }

    return count
}