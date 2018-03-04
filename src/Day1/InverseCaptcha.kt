package Day1


fun inverseCaptcha(input: String) : Int {
    return sumDuplicates(input, -1)
}

fun inverseCaptchaHalfAround(input: String) : Int {
    return sumDuplicates(input, input.length / 2)
}

private fun sumDuplicates(input: String, offset: Int): Int {

    var sum = 0

    for (i in input.indices) {
        var previousIndex = modulo((i - offset), input.length)
        var next = input[i]
        if (next == input[previousIndex]) sum += next.toString().toInt()
    }
    return sum
}

// -1 % 4 returns -1 in Kotlin -> must return 3 for this purpose
fun modulo(i: Int, n: Int): Int {
    val mod = i % n
    return when (mod < 0) {
        true -> mod + n
        false -> mod
    }
}