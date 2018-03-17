package Day3

import java.lang.Math.*

fun calculateIt(input: Int): Int {

    if (input ==1 ) return 0

    // ____________
    //  _________  |
    // |  _____  | |
    // | |  _  | | |
    // | | |___| | |
    // | |_______|#|
    // |___________|
    //
    // |---------|
    // side len of square containing all former spiral
    val innerSquareSideLength = {
        val rooted = ceil(sqrt(input.toDouble())).toInt()
        if ( rooted % 2 == 0 ) rooted - 1
        else rooted - 2
    }()
//    print(" innerSquare "+innerSquareSideLength)
//    require(input>innerSquareSideLength*innerSquareSideLength && input<=(innerSquareSideLength+2)*(innerSquareSideLength+2))


    // . . . . . . .
    // . _________ .
    // .|  _____  |.
    // .| |  _  | |.
    // #| | |___| |.
    //  | |_______|.
    //  |__________.
    //
    // distance to the start of the square containing the element
    val offsetInOuterSquare = input - innerSquareSideLength * innerSquareSideLength
//    print(" offsetInOuterSquare "+offsetInOuterSquare)
//    require(offsetInOuterSquare>=0&&offsetInOuterSquare<(innerSquareSideLength+2)*(innerSquareSideLength+2)-innerSquareSideLength*innerSquareSideLength)

    //   _________ #
    //  |  _____  |#
    //  | |  _  | |#
    //  | | |___| |#
    //  | |_______|#
    //  |__________#
    //
    // len of a strip = innerSquare+1 = outerSquare-1
    val stripLength = innerSquareSideLength+1
    val offsetOnStrip = (offsetInOuterSquare-1)%stripLength
//    print(" offsetInSide "+offsetOnStrip)
//    require(offsetOnStrip>=0 && offsetOnStrip<stripLenght)

    //   _________ .|
    //  |  _____  |.|
    //  | |  _  | |.|
    //  | | |___| |#| center of strip
    //  | |_______|.|
    //  |__________.|
    //
    // number of steps to the "center" of the strip
    val sideSteps = abs(offsetOnStrip+1-(stripLength)/2)
//    print(" sideSteps "+sideSteps)
//    require(sideSteps>=0 && sideSteps <= (innerSquareSideLength/2+1))

    //   _________  |
    //  |  _____  | |
    //  | |  _  | | |
    //  | | |#_*|*|*| steps towards the center
    //  | |_______| |
    //  |___________|
    // steps toward the center
    val stepsTowardsCenter = (innerSquareSideLength+1)/2
    return sideSteps + stepsTowardsCenter
}