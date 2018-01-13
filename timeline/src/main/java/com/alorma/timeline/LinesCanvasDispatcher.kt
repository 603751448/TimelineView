package com.alorma.timeline

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.os.Build
import android.view.View

internal class LinesCanvasDispatcher : CanvasDispatcher {

    private val rect = Rect()

    private val linesPaint = Paint().apply {
        isAntiAlias = true
        color = Color.RED
        strokeWidth = 1f
    }

    override fun init() {

    }

    override fun drawCanvas(canvas: Canvas, view: View) {
        canvas.getClipBounds(rect)

        val centerX = rect.centerX()
        val centerY = rect.centerY()

        val canvasPaddingStart = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) view.paddingStart else view.paddingLeft
        val canvasPaddingEnd = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) view.paddingEnd else view.paddingRight

        // V lines
        val top = 0f
        val bottom = rect.bottom.toFloat()

        canvas.drawLine(((centerX.toFloat()) / 3) + canvasPaddingStart, top, ((centerX.toFloat()) / 3) + canvasPaddingStart, bottom, linesPaint)
        canvas.drawLine(centerX.toFloat(), top, centerX.toFloat(), bottom, linesPaint)
        canvas.drawLine(centerX + ((centerX.toFloat()) / 3) * 2 - canvasPaddingEnd, top, centerX + ((centerX.toFloat()) / 3) * 2 - canvasPaddingEnd, bottom, linesPaint)

        // H lines
        val left = 0f
        val right = rect.right.toFloat()
        canvas.drawLine(left, ((centerY.toFloat()) / 3) + view.paddingTop, right, ((centerY.toFloat()) / 3) + view.paddingTop, linesPaint)
        canvas.drawLine(left, centerY.toFloat(), right, centerY.toFloat(), linesPaint)
        canvas.drawLine(left, centerY + ((centerY.toFloat()) / 3) * 2 -view. paddingBottom, right, centerY + ((centerY.toFloat()) / 3) * 2 - view.paddingBottom, linesPaint)
    }
}