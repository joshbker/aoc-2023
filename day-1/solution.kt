import java.nio.file.Files
import java.nio.file.Path

val numberMap = mapOf(
    "one" to "1",
    "two" to "2",
    "three" to "3",
    "four" to "4",
    "five" to "5",
    "six" to "6",
    "seven" to "7",
    "eight" to "8",
    "nine" to "9",
    "1" to "1",
    "2" to "2",
    "3" to "3",
    "4" to "4",
    "5" to "5",
    "6" to "6",
    "7" to "7",
    "8" to "8",
    "9" to "9"
)

fun main() {
    println(Files.readAllLines(Path.of("input.txt"))
        .mapNotNull { (numberMap[it.findAnyOf(numberMap.keys)?.second] + numberMap[it.findLastAnyOf(numberMap.keys)?.second]).toInt() }
        .sum())
}
