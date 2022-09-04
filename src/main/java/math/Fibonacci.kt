package math


class Fibonacci {
}

fun main() {}

fun fibonacci() = sequence {
    var params = Pair(0, 1)
    while (true) {
        yield(params.first)
        params = Pair(params.second, params.first + params.second)
    }
}