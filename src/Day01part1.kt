import kotlin.io.path.Path
import kotlin.io.path.readLines

fun main() {
    var ans = 0
    var pos = 50
    Path("src/Day01.txt")
        .readLines()
        .map {
            (if(it.first() == 'L') -1 else 1) *
            it.slice(1 until it.length).toInt()
        }
        .forEach {
            pos = (pos + it + 100) % 100
            println(pos)
            if(pos == 0) ans++
        }
    println(ans)
}
