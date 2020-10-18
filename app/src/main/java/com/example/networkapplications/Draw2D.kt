package com.example.networkapplications

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import java.util.jar.Attributes

class Draw2D(context: Context, attributeSet: AttributeSet) : View(context, attributeSet) {

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val widthColumn: Float = (width / 2).toFloat()
        val paint = Paint()
        val rectF = RectF()
        rectF.set(0F, 0F,widthColumn, height.toFloat())
        paint.color = Color.GREEN
        paint.style = Paint.Style.FILL
        canvas.drawRect(rectF,paint)
        paint.reset()
        paint.color = Color.BLUE
        paint.style = Paint.Style.FILL
        rectF.set(widthColumn, 0F,widthColumn*2,height.toFloat())
        canvas.drawRect(rectF,paint)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {

        val desiredWidth  = suggestedMinimumWidth + paddingLeft + paddingRight
        val desiredHight = suggestedMinimumWidth +paddingTop + paddingBottom
        setMeasuredDimension(measureDimension(desiredWidth,widthMeasureSpec),
            measureDimension(desiredHight,heightMeasureSpec))
    }
    private fun measureDimension(desireSize: Int,measureSpec: Int): Int{
        var result: Int
        val specMode = MeasureSpec.getMode(measureSpec)
        val specSize = MeasureSpec.getSize(measureSpec)

        if(specMode == MeasureSpec.EXACTLY){
            result = specSize
        }else{
            result = desireSize
            if(specMode == MeasureSpec.AT_MOST){
                result = Math.min(result, specSize)
            }
        }
        return result
    }
}