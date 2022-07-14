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