import kotlin.io.path.Path
import kotlin.io.path.readLines
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

fun main() {
    var x = 50
    println(
        Path("src/Day01.txt")
            .readLines()
            .map {
                ( if(it.first() == 'L') -1 else 1 ) *
                it.slice(1 until it.length).toInt()
            }
            .map {
                dx ->
                val x1 = x + (dx / abs(dx))
                val x2 = x + dx
                x = x2 % 100
                (min(x1, x2)..max(x1, x2)).map { it % 100 }
            }
            .sumOf {
                sub -> sub.count { it == 0 }
            }
    )
}