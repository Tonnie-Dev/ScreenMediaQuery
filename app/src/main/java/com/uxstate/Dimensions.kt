package com.uxstate

import androidx.compose.ui.unit.Dp

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
    ){

        fun compare(screenWidth: Dp, screenHeight: Dp): Boolean {

            //check Dimen width
            return if (dimension is Dimensions.Width){
                when(operator){
                    is Dimensions.DimensionsOperator.GreaterThan -> screenWidth > value
                    is  Dimensions.DimensionsOperator.LessThan -> screenWidth <value
                }

                //Else check height
            }else{

                when(operator){

                    is Dimensions.DimensionsOperator.GreaterThan -> screenHeight> value
                    is Dimensions.DimensionsOperator.LessThan -> screenHeight<value
                }
            }
        }
    }
