package leetcode.algo_1_path

import kotlin.collections.HashMap

class MapSum {

    private val map = HashMap<String, Int>()

    fun insert(key: String, `val`: Int) {
        map[key] = `val`
    }

    fun sum(prefix: String): Int {
        return map.filterKeys { it.startsWith(prefix) }.values.sum()
    }
}

fun main() {
    val mapSum = MapSum()
    mapSum.insert("mappp", 1)
    mapSum.insert("mapp", 2)
    mapSum.insert("map", 3)
    mapSum.insert("ap", 3)
    assert(mapSum.sum("map") == 6)
    assert(mapSum.sum("p") == 0)
    assert(mapSum.sum("ap") == 3)
}