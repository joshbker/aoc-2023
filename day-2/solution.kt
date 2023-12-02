import java.nio.file.Files
import java.nio.file.Path

val limits = mutableMapOf("red" to 12, "green" to 13, "blue" to 14)

fun part1() {
    println("PART 1: " + Files.readAllLines(Path.of("input.txt")).sumOf { input ->
        val (game, rolls) = input.split(": ")
        if (rolls.split("; ").any { set ->
                set.split(", ").any { subset ->
                    val (value, colour) = subset.split(" ")
                    limits[colour]?.let { value.toInt() > it } == true
                }
            }) 0 else game.replace("Game ", "").toInt()
    })
}

fun part2() {
    limits.replaceAll { _, _ -> 0 }
    println("PART 2: " + Files.readAllLines(Path.of("input.txt")).sumOf { input ->
        input.split(": ")[1].split("; ")
            .flatMap { it.split(", ").map { subset -> subset.split(" ").let { (value, colour) -> colour to value.toInt() } } }
            .forEach { (colour, value) -> limits[colour]?.takeIf { value > it }?.let { limits[colour] = value } }
        limits.values.fold(1) { acc, i -> acc * i }
            .also { limits.replaceAll { _, _ -> 0 } }
    })
}

fun main() {
    part1()
    part2()
}
