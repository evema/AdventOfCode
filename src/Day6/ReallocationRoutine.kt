package Day6

fun countStepsToCycle(blocks : String) : Int {

    val blockList = getMutableListOfBlocks(blocks)
    val configurationList: MutableList<List<Int>> = getListOfConfigurations(blockList)

    return configurationList.size
}

private fun getListOfConfigurations(blockList: MutableList<Int>): MutableList<List<Int>> {
    val configurationList: MutableList<List<Int>> = mutableListOf()
    var configurationIsUnique = true

    while (configurationIsUnique) {
        val configuration = reallocateBlocks(blockList)

        if (configurationList.contains(configuration)) {
            configurationIsUnique = false
        }

        configurationList.add(configuration)
    }
    return configurationList
}

private fun getMutableListOfBlocks(blocks: String): MutableList<Int> {
    val blockList = blocks.split("\t").map { it.toInt() }.toMutableList()
    return blockList
}


fun reallocateBlocks(blockList: MutableList<Int>): List<Int> {
    val size = blockList.size
    var maxValue: Int? = blockList.max()
    var index = blockList.indexOf(maxValue)

    blockList[index] = 0

    while (maxValue != 0) {
        blockList[(index + 1) % size]++
        index++
        maxValue = maxValue?.minus(1)
    }

    return blockList.toList()
}

fun countStepsOfEndlessLoop(blocks : String) : Int {
    val blockList = getMutableListOfBlocks(blocks)
    val configurationList: MutableList<List<Int>> = getListOfConfigurations(blockList)

    val duplicatedConfiguration = configurationList.last()
    val indexOfFirstOccurrence = configurationList.indexOfFirst { it.equals(duplicatedConfiguration) }

    return configurationList.lastIndex - indexOfFirstOccurrence
}
