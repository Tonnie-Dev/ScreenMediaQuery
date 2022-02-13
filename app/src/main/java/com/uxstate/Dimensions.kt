package com.uxstate

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

sealed class Dimensions {

    object Width : Dimensions()
    object Height : Dimensions()


}

//how to compare values
sealed class DimensionsOperator {


    object LessThan : DimensionsOperator()
    object GreaterThan : DimensionsOperator()
}

class DimensionsComparator(
    val operator: DimensionsOperator,
    private val dimension: Dimensions,
    val value: Dp


    /*Here we want to check the width(i.e. Dimension)
    is less than (i.e. DimensionsOperator)
    400.dp (i.e. the value)*/
) {

    fun compare(screenWidth: Dp, screenHeight: Dp): Boolean {

        //check Dimen width
        return if (dimension is Dimensions.Width) {
            when (operator) {
                is DimensionsOperator.GreaterThan -> screenWidth > value
                is DimensionsOperator.LessThan -> screenWidth < value
            }

            //Else check height
        } else {

            when (operator) {

                is DimensionsOperator.GreaterThan -> screenHeight > value
                is DimensionsOperator.LessThan -> screenHeight < value
            }
        }
    }
}

@Composable
fun MediaQuery(comparator: DimensionsComparator, content: @Composable () -> Unit) {

    //context inside a composable =LocalContext.current
    val screenWidth =
        LocalContext.current.resources.displayMetrics.widthPixels.dp / LocalDensity.current.density

    val screenHeight =
        LocalContext.current.resources.displayMetrics.heightPixels.dp / LocalDensity.current.density

    //show composable if compare() returns true

    if (comparator.compare(screenWidth = screenWidth, screenHeight = screenHeight)) {

        content()

    }

}


infix fun Dimensions.lessThan(value: Dp): DimensionsComparator {


    return DimensionsComparator(
        operator = DimensionsOperator.LessThan,
        dimension = this,
        value = value
    )
}
