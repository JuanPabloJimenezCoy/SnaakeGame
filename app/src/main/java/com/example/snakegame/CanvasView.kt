package com.example.snakegame

import android.view.View
import android.util.AttributeSet
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import com.example.snakegame.R

class CanvasView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val foodBitmap = BitmapFactory.decodeResource(resources, R.drawable.pez)
    private val levelImage: Bitmap = BitmapFactory.decodeResource(resources, R.drawable.mar)
    private val levelImageWidth = 2200
    private val levelImageHeight = 1100
    private val scaledLevelImage = Bitmap.createScaledBitmap(levelImage, levelImageWidth, levelImageHeight, true)

    private val levelColor = Paint().apply {
        color = Color.DKGRAY
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // Draw background
        canvas.drawColor(Color.BLACK)

        // Draw level
        canvas.drawBitmap(scaledLevelImage, 6f, 6f, null)

        // Draw snake from array
        for (i in Snake.bodyParts) {
            canvas.drawRect(
                i[0].toFloat(), i[1].toFloat(),
                i[0].toFloat() + 45, i[1].toFloat() + 45,
                Paint().apply { color = Snake.bodyColor }
            )
        }

        // Draw food from array
        canvas.drawBitmap(foodBitmap, Food.posX.toFloat(), Food.posY.toFloat(), null)
    }
}