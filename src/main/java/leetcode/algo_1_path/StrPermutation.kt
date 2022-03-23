package leetcode.algo_1_path

class StrPermutation {
}

fun main() {
    permute("abc", "")
}

fun permute(str: String, answer: String) {

    if (str.isEmpty()) {
        print("$answer ")
        return
    }

    for (i in str.indices) {
        val ch = str[i]
        val leftSubString = str.substring(0, i)
        val rightSubString = str.substring(i+1)
        val other = leftSubString + rightSubString
        permute(other, answer + ch)
    }
}