package leetcode.junecontest

import java.util.*

class MinimumNumberOfRefuelingStops {

    fun minRefuelStopsHelper(target: Int, startFuel: Int, stations: Array<IntArray>): Int {

        var currFuel = startFuel
        var refules = 0
        var prevMilesNeeded = 0
        val priorityQueue = PriorityQueue<Int>(Collections.reverseOrder())

        for(station in stations) {
            val (miles, fuel) = station
            currFuel -= (miles - prevMilesNeeded)

            while(currFuel < 0) {
                if(priorityQueue.isEmpty()) return -1

                currFuel += priorityQueue.remove()
                refules++
            }

            prevMilesNeeded = miles
            priorityQueue.add(fuel)
        }

        val remainMiles = target - stations[stations.size - 1][0]
        while(currFuel < remainMiles) {

            if(priorityQueue.isEmpty()) return -1

            currFuel += priorityQueue.remove()
            refules++
        }

        return refules
    }

    fun minRefuelStops(target: Int, startFuel: Int, stations: Array<IntArray>): Int {

        if (stations.isEmpty()) {
            if(target <= startFuel) return 0

            return -1
        }

        return minRefuelStopsHelper(target, startFuel, stations)
    }
}

