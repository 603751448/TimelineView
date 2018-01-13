package com.alorma.timeline

import android.graphics.Canvas
import android.view.View

interface CanvasDispatcher {
    fun init()
    fun drawCanvas(canvas: Canvas, view: View)
}