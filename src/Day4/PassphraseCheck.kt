package Day4

fun countValidPhrasesWithoutDuplicates(passPhrases : String) : Int {
    val phrases = getListOfPhrases(passPhrases)
    return phrases.filter { hasNoDuplicates(it) }.size
}

fun hasNoDuplicates (passPhrase : String) : Boolean {
    val listOfWords = getListOfWords(passPhrase)
    return listOfWords.size == listOfWords.distinct().size
}

fun countValidPhrasesWithoutAnagrams(passPhrases : String) : Int {
    val phrases = getListOfPhrases(passPhrases)
    return phrases.filter{ hasNoAnagram(it) }.size
}

fun hasNoAnagram(phrase : String) : Boolean {
    val listOfWords = getListOfWords(phrase)
    val letterOccurrenceMap = listOfWords.map { countLetterOccurrenceInWord(it) }

    return letterOccurrenceMap.size == letterOccurrenceMap.distinct().size
}

fun countLetterOccurrenceInWord(word : String) : Map<Char, Int> {
    return word.toList().groupingBy { it }.eachCount()
}

private fun getListOfPhrases(passPhrases: String): List<String> {
    return passPhrases.split("\n")
}

private fun getListOfWords(phrase : String) : List<String>{
    return phrase.split("\\s".toRegex())
}
