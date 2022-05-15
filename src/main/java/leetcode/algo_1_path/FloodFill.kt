package leetcode.algo_1_path


class FloodFill {
    fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, newColor: Int): Array<IntArray> {
        fill(image, sr, sc, newColor, image[sr][sc])
        return image
    }

    fun fill(image: Array<IntArray>, sr: Int, sc: Int, newColor: Int, prevColor: Int) {
        if (image[sr][sc] == newColor) return
        image[sr][sc] = newColor
        if (sr + 1 < image.size && image[sr + 1][sc] == prevColor) {
            fill(image, sr + 1, sc, newColor, prevColor)
        }
        if (sr - 1 >= 0 && image[sr - 1][sc] == prevColor) {
            fill(image, sr - 1, sc, newColor, prevColor)
        }
        if (sc + 1 < image[0].size && image[sr][sc + 1] == prevColor) {
            fill(image, sr, sc + 1, newColor, prevColor)
        }
        if (sc - 1 >= 0 && image[sr][sc - 1] == prevColor) {
            fill(image, sr, sc - 1, newColor, prevColor)
        }
    }
}

fun main() {
    val inst = FloodFill()
    val image = arrayOf(
            intArrayOf(0,0,0),
            intArrayOf(0,2,0),
            intArrayOf(0,0,0)
    )
    inst.floodFill(image, 0,0, 1)
    printMatrix(image)

    val image2 = arrayOf(
            intArrayOf(0,0,0),
            intArrayOf(0,1,1)
    )
    inst.floodFill(image2, 1,1, 1)
    printMatrix(image2)
}

fun printMatrix(matrix: Array<IntArray>) {
    matrix.forEach { arr ->
        println(arr.joinToString(" "))
    }
}