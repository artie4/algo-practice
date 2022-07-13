package leetcode.algo_1_path

class MaximumUnitsOnTruck {
    fun maximumUnits(boxTypes: Array<IntArray>, truckSize: Int): Int {
        boxTypes.sortByDescending { it[1] }
        var capacity = truckSize
        var units = 0
        for (boxIndex in 0..boxTypes.lastIndex) {
            val boxAmount = boxTypes[boxIndex][0]
            if (capacity > boxAmount) {
                capacity -= boxAmount
                units += boxAmount * boxTypes[boxIndex][1]
            } else {
                units += capacity * boxTypes[boxIndex][1]
                return units
            }
        }
        return units
    }
}

fun main() {
    val inst = MaximumUnitsOnTruck()
    assert(inst.maximumUnits(arrayOf(intArrayOf(3,2), intArrayOf(2,3), intArrayOf(4,1)), 8) == 15)
    assert(inst.maximumUnits(arrayOf(intArrayOf(3,2), intArrayOf(2,3), intArrayOf(4,4)), 8) == 26)
}