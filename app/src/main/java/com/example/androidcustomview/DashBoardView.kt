package com.example.androidcustomview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View


class DashBoardView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val path = Path()
    private val radius = 150f.px

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {

        path.addCircle(width / 2f, height / 2f, radius, Path.Direction.CCW)
        path.addRect(
            width / 2f - radius,
            height / 2f,
            width / 2f + radius,
            height / 2f + 2 * radius,
            Path.Direction.CCW
        )
        path.fillType = Path.FillType.EVEN_ODD

    }

    override fun onDraw(canvas: Canvas) {
        canvas.drawPath(path, paint)
    }
}