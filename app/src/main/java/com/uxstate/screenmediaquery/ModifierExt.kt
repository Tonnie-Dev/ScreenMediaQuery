package com.uxstate.screenmediaquery

import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import com.uxstate.DimensionsComparator


fun Modifier.mediaQuery(comparator:DimensionsComparator, modifier: Modifier): Modifier = composed{


    //context inside a composable =LocalContext.current
    val screenWidth =
        LocalContext.current.resources.displayMetrics.widthPixels.dp / LocalDensity.current.density

    val screenHeight =
        LocalContext.current.resources.displayMetrics.heightPixels.dp / LocalDensity.current.density

     if (comparator.compare(screenWidth,screenHeight)){

        this.then(modifier)
    }else{this}
}