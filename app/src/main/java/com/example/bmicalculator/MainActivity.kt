package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCalc.setOnClickListener(){
            btnCalc()
        }
        btnReset.setOnClickListener() {
            reset()
        }
    }

    private fun btnCalc() {

        try {

            val weight: Double = weightValue.text.toString().toDouble()
            val height: Double = heightValue.text.toString().toDouble()

            val result: Double = weight / (height * height)

            if (result < 18.5) {
                imageView.setImageResource(R.drawable.under)
                txtValue.text = "%.2f (UnderWeight)".format((result))
            } else if (result > 18.5 && result < 24.9) {
                imageView.setImageResource(R.drawable.normal)
                txtValue.text = "%.2f (Normal)".format((result))
            } else {
                imageView.setImageResource(R.drawable.over)
                txtValue.text = "%.2f (Overweight)".format(((result)))
            }
        } catch (e:Exception)
        {
            val toast:Toast = Toast.makeText(this, "Invalid Input", Toast.LENGTH_LONG)

            toast.setGravity(Gravity.CENTER, 0,0);
            toast.show();
        }
    }

    public fun reset(){
        weightValue.setText("")
        heightValue.setText("")
    }

}
