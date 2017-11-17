package com.agrawalsuneet.loaderspack.basicviews

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.agrawalsuneet.loaderspack.R

/**
 * Created by suneet on 11/15/17.
 */


class CircleView : View {

    var circleRadius: Int = 15

    var circleColor: Int = 0

    constructor(context: Context, circleRadius: Int, circleColor: Int) : super(context) {
        this.circleRadius = circleRadius
        this.circleColor = circleColor
    }

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        initAttributes(attrs)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr)


    fun initAttributes(attrs: AttributeSet) {

        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.CircleView, 0, 0)

        this.circleRadius = typedArray.getDimensionPixelSize(R.styleable.CircleView_circleRadius, 30)
        this.circleColor = typedArray.getColor(R.styleable.CircleView_circleColor, 0)

        typedArray.recycle()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        setMeasuredDimension(2 * circleRadius, 2 * circleRadius)
    }


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        var paint = Paint()
        paint.isAntiAlias = true
        paint.style = Paint.Style.FILL
        paint.color = circleColor

        canvas!!.drawCircle(circleRadius.toFloat(), circleRadius.toFloat(), circleRadius.toFloat(), paint)
    }


}