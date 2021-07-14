package leetcode.julycontest.weektwo

import java.lang.StringBuilder


fun main() {

    val s = "badc"
    val t = "baba"

    print(IsomorphicStrings().isIsomorphic(s, t))
}
class IsomorphicStrings {
    
    fun isIsomorphic(s: String, t: String): Boolean {

        val mapFirsToSec = mutableMapOf<Char, Char>()
        val mapSecToFirst = mutableMapOf<Char, Char>()

        for(i in s.indices) {
            if(mapFirsToSec.containsKey(s[i]) && mapFirsToSec[s[i]] != t[i]) return false

            if(mapSecToFirst.containsKey(t[i]) && mapSecToFirst[t[i]] != s[i]) return false

            mapFirsToSec[s[i]] = t[i]
            mapSecToFirst[t[i]] = s[i]
        }
        return true
    }
}