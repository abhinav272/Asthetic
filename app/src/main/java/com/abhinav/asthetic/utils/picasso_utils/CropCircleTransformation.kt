package com.abhinav.asthetic.utils.picasso_utils

import android.graphics.*
import com.squareup.picasso.Transformation


/**
 * Created by abhinav.sharma on 16/01/18.
 */
class CropCircleTransformation : Transformation {

    override fun transform(source: Bitmap): Bitmap {
        val size = Math.min(source.width, source.height)

        val width = ((source.width - size) / 2).toFloat()
        val height = ((source.height - size) / 2).toFloat()

        val bitmap = Bitmap.createBitmap(size, size, Bitmap.Config.ARGB_8888)

        val canvas = Canvas(bitmap)
        val paint = Paint()
        val shader = BitmapShader(source, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
        if (width != 0f || height != 0f) {
            // source isn't square, move viewport to center
            val matrix = Matrix()
            matrix.setTranslate(-width, -height)
            shader.setLocalMatrix(matrix)
        }
        paint.shader = shader
        paint.isAntiAlias = true

        val r = size / 2f
        canvas.drawCircle(r, r, r, paint)

        source.recycle()

        return bitmap
    }

    override fun key(): String {
        return "CropCircleTransformation()"
    }
}