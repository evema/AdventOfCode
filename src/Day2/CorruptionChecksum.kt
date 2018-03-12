package Day2

fun checkSum(input: String): Int {
   return input.split("\n")
            .map{ diffOfMinMax(it) }
            .sum()
}

fun diffOfMinMax(input: String): Int {
    val intValues = getIntList(input)

    return intValues.max()!!.minus(intValues.min()!!)
}

private fun getIntList(input: String): List<Int> {
    return input.split("\\s".toRegex())
            .map { it.toInt() }
}

fun checkSum2(input: String): Int {
    return input.split("\n")
            .map { evenlyDivision(it) }
            .sum()
}

fun evenlyDivision(input: String): Int {
    val intValues = getIntList(input)

    val pair = intValues.flatMap { divisor ->
        val dividends: List<Int> = intValues.filter { it % divisor == 0 }
        if (dividends.size == 2) {
            listOf<Pair<Int, Int>>(Pair(divisor, dividends.max()) as Pair<Int, Int>)
        } else {
            listOf()
        }
    }

    require(pair.size==1) { "not exactly one pair found" }

    val match: Pair<Int, Int> = pair.first()
    return match.second / match.first
}

fun evenlyDivision2(input: String): Int {
    val intValues = getIntList(input)

    for (i in intValues.indices) {
        for (j in intValues.indices) {
            if (i != j && intValues[i] % intValues[j] == 0)
                return intValues[i] / intValues[j]
        }
    }
    return 0
}