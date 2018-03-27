package Day5

fun countSteps(instructionString : String, rule: (Int) -> Int) : Int {
    val instructionList = instructionString.split("\n").map(String::toInt).toMutableList()

    var index = 0
    var stepsToExit = 0

    while (index < instructionList.size || index < 0) {
        val stepsToMove = instructionList[index]
        instructionList[index] = rule.invoke(stepsToMove)
        index += stepsToMove
        stepsToExit++
    }

    return stepsToExit
}

fun processListFirstRule(instructionString : String) : Int {
    return countSteps(instructionString, {i -> i.plus(1)})
}

fun processListSecondRule(instructionString : String) : Int {
    return countSteps(instructionString) {i  -> when { i >= 3 -> i.minus(1) else -> i.plus(1)}}
}