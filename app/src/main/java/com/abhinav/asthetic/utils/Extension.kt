package com.abhinav.asthetic.utils

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.abhinav.asthetic.utils.picasso_utils.CropCircleTransformation
import com.abhinav.asthetic.utils.picasso_utils.RoundedCornersTransformation
import com.squareup.picasso.Picasso
import com.squareup.picasso.RequestCreator
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by abhinav.sharma on 08/01/18.
 */

fun ViewGroup.inflate(layoutRes: Int): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, false)
}

val Context.picasso: Picasso get() = Picasso.get()

fun ImageView.load(path: String, request: (RequestCreator) -> RequestCreator) {
    request(context.picasso.load(path)).into(this)
}

fun ImageView.loadRoundedCorner(path: String, request: (RequestCreator) -> RequestCreator) {
    request(context.picasso.load(path).transform(RoundedCornersTransformation(20, 5)))
            .into(this)
}

fun ImageView.loadCircular(path: String, request: (RequestCreator) -> RequestCreator) {
    request(context.picasso.load(path).transform(CropCircleTransformation())).into(this)
}

fun ClosedRange<Int>.random() =
        Random().nextInt(endInclusive - start) + start

fun Date.getFormatedDate(): String = SimpleDateFormat("EEE, MMM d, ''yy", Locale.getDefault()).format(this)