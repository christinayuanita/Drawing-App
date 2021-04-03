package com.example.drawingapp

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.core.content.ContextCompat
import androidx.core.view.get
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.dialog_brush_size.*

class MainActivity : AppCompatActivity() {

    private var mImageButtonCurrentPaint : ImageButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawing_view.setSizeForBrush(20.toFloat())

        mImageButtonCurrentPaint = paintColors[2] as ImageButton
        mImageButtonCurrentPaint!!.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.palette_pressed))

        brushBtn.setOnClickListener {
            showBrushSizeChooserDialog()
        }
    }

    private fun showBrushSizeChooserDialog(){
        val brushDialog = Dialog(this)
        brushDialog.setContentView(R.layout.dialog_brush_size)
        brushDialog.setTitle("Brush Size: ")

        val smallBtn = brushDialog.smallBrushBtn
        smallBtn.setOnClickListener {
            drawing_view.setSizeForBrush(10.toFloat())
            brushDialog.dismiss()
        }

        val mediumBtn = brushDialog.mediumBrushBtn
        mediumBtn.setOnClickListener {
            drawing_view.setSizeForBrush(20.toFloat())
            brushDialog.dismiss()
        }

        val largeBtn = brushDialog.largeBrushBtn
        largeBtn.setOnClickListener {
            drawing_view.setSizeForBrush(30.toFloat())
            brushDialog.dismiss()
        }

        brushDialog.show()
    }
}