package com.bishaljung.studentmarksgeneratorweek4assign2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
class ResultPageActivity : AppCompatActivity() {
    private lateinit var studentMarksArrayList: ArrayList<Student>
        private lateinit var frstRank : EditText
     private lateinit var  scndRank : EditText
     private lateinit var  thrdRank : EditText
     private lateinit var textHigh : TextView
    private lateinit var frstHigh : EditText
    private lateinit var scndHigh : EditText
    private lateinit var  thrdHigh  : EditText
    private  lateinit var backBtn : Button
    private lateinit var stdntName : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_page)
        frstRank = findViewById(R.id.frstRank)
        scndRank = findViewById(R.id.scndRank)
        thrdRank = findViewById(R.id.thrdRank)
        textHigh = findViewById(R.id.textHigh)
        frstHigh = findViewById(R.id.frstHigh)
        scndHigh = findViewById(R.id.scndHigh)
        thrdHigh = findViewById(R.id.thrdHigh)
        backBtn = findViewById(R.id.btnBck)
        stdntName = findViewById(R.id.stdName)

        studentMarksArrayList = intent.getParcelableArrayListExtra("studentArrayList")!!
        val studentOne=studentMarksArrayList[0].name
        val studentOneAndroid=studentMarksArrayList[0].androidMarks
        val studentOneAPI=studentMarksArrayList[0].apiMarks
        val studentOneIOT=studentMarksArrayList[0].iotMarks
        val firstTotal=calculateTotal(studentOneAndroid,studentOneAPI,studentOneIOT)
        val studentTwo=studentMarksArrayList[1].name
        val studentTwoAndroid=studentMarksArrayList[1].androidMarks
        val studentTwoAPI=studentMarksArrayList[1].apiMarks
        val studentTwoIOT=studentMarksArrayList[1].iotMarks
        val secondTotal=calculateTotal(studentTwoAndroid,studentTwoAPI,studentTwoIOT)
        val studentThree=studentMarksArrayList[2].name
        val studentThreeAndroid=studentMarksArrayList[2].androidMarks
        val studentThreeAPI=studentMarksArrayList[2].apiMarks
        val studentThreeIOT=studentMarksArrayList[2].iotMarks
        val thirdTotal=calculateTotal(studentThreeAndroid,studentThreeAPI,studentThreeIOT)
        calculateHighestInAndroid(studentOne!!,studentTwo!!,studentThree!!,studentOneAndroid,studentTwoAndroid,studentThreeAndroid)
        calculateRank(studentOne, studentTwo, studentThree,firstTotal, secondTotal, thirdTotal)

    }
    override fun onBackPressed() {
        val intent = Intent(this, StudentMarksActivity::class.java)
        startActivity(intent)
    }

    private fun calculateTotal(
            androidMarks: Float,
            apiMarks: Float,
            iotMarks: Float
    ): Float {
        val total=(androidMarks + apiMarks + iotMarks) / 3
        return String.format("%.2f",total).toFloat()
    }
    private fun calculateHighestInAndroid(
            firstStudent: String,
            secondStudent: String,
            thirdStudent: String,
            firstStudentAndroid: Float,
            secondStudentAndroid: Float,
            thirdStudentAndroid: Float
    ) {
        if (firstStudentAndroid > secondStudentAndroid && firstStudentAndroid > thirdStudentAndroid) {
            frstHigh.setText( "$firstStudent has obtained $firstStudentAndroid Marks.").toString()
            if (secondStudentAndroid > thirdStudentAndroid) {
                scndHigh.setText( "$secondStudent has obtained $secondStudentAndroid Marks.").toString()
                thrdHigh.setText ( "$thirdStudent has obtained $thirdStudentAndroid Marks.").toString()
            } else {
                scndHigh.setText(  "$thirdStudent has obtained $thirdStudentAndroid Marks.").toString()
                thrdHigh.setText ("$secondStudent has obtained $secondStudentAndroid Marks.").toString()
            }
        } else if (secondStudentAndroid > firstStudentAndroid && secondStudentAndroid > thirdStudentAndroid) {
            frstHigh.setText("$secondStudent has obtained $secondStudentAndroid Marks.").toString()
            if (firstStudentAndroid > thirdStudentAndroid) {
                scndHigh.setText("$firstStudent has obtained $firstStudentAndroid Marks.").toString()
                thrdHigh.setText ("$thirdStudent has obtained $thirdStudentAndroid Marks.").toString()
            } else {
                scndHigh.setText("$thirdStudent has obtained $thirdStudentAndroid Marks.").toString()
                thrdHigh.setText("$firstStudent has obtained $firstStudentAndroid Marks.").toString()
            }
        } else if (thirdStudentAndroid > secondStudentAndroid && thirdStudentAndroid > firstStudentAndroid) {
            frstHigh.setText("$thirdStudent has obtained $thirdStudentAndroid Marks.").toString()
            if (secondStudentAndroid > firstStudentAndroid) {
                scndHigh.setText("$secondStudent has obtained $secondStudentAndroid Marks.").toString()
                thrdHigh.setText("$firstStudent has obtained $firstStudentAndroid Marks.").toString()
            } else {
                scndHigh.setText("$firstStudent has obtained $firstStudentAndroid Marks.").toString()
                thrdHigh.setText("$secondStudent has obtained $secondStudentAndroid Marks.").toString()
            }
        }
    }
    private fun calculateRank(
            studentOne: String,
            studentTwo: String,
            studentThree: String,
            firstTotal: Float,
            secondTotal: Float,
            thirdTotal: Float
    ) {
        if (firstTotal > secondTotal && firstTotal > thirdTotal) {
            frstRank.setText("$studentOne secured $firstTotal %").toString()
            if (secondTotal > thirdTotal) {
                scndRank.setText("$studentTwo secured $secondTotal %").toString()
                thrdRank.setText("$studentThree secured $thirdTotal %").toString()
            } else {
                scndRank.setText("$studentThree secured $thirdTotal %").toString()
                thrdRank.setText("$studentTwo secured $secondTotal %").toString()
            }
        } else if (secondTotal > firstTotal && secondTotal > thirdTotal) {
            frstRank.setText("$studentTwo secured $secondTotal %").toString()
            if (firstTotal > thirdTotal) {
                scndRank.setText("$studentOne secured $firstTotal %").toString()
                thrdRank.setText("$studentThree secured $thirdTotal %").toString()
            } else {
                scndRank.setText("$studentThree secured $thirdTotal %").toString()
                thrdRank.setText("$studentOne secured $firstTotal %").toString()
            }
        } else if (thirdTotal > secondTotal && thirdTotal > firstTotal) {
            frstRank.setText("$studentThree secured $thirdTotal %").toString()
            if (secondTotal > firstTotal) {
                scndRank.setText("$studentTwo secured $secondTotal %").toString()
                thrdRank.setText("$studentOne secured $firstTotal %").toString()
            } else {
                scndRank.setText("$studentOne secured $firstTotal %").toString()
                thrdRank.setText("$studentTwo secured $secondTotal %").toString()
            }
        }
        backBtn.setOnClickListener{
            intent = Intent(this, StudentMarksActivity::class.java )
            startActivity(intent)
        }

    }

}






//class ResultPageActivity : AppCompatActivity() {
//    private lateinit var frstRank : EditText
//    private lateinit var  scndRank : EditText
//    private lateinit var  thrdRank : EditText
//    private lateinit var textHigh : TextView
//    private lateinit var frstHigh : EditText
//    private lateinit var scndHigh : EditText
//    private lateinit var  thrdHigh  : EditText
//    private  lateinit var backBtn : Button
//    private lateinit var stdntName : TextView
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_result_page)
//        frstRank = findViewById(R.id.frstRank)
//        scndRank = findViewById(R.id.scndRank)
//        thrdRank = findViewById(R.id.thrdRank)
//        textHigh = findViewById(R.id.textHigh)
//        frstHigh = findViewById(R.id.frstHigh)
//        scndHigh = findViewById(R.id.scndHigh)
//        thrdHigh = findViewById(R.id.thrdHigh)
//        backBtn = findViewById(R.id.btnBck)
//        stdntName = findViewById(R.id.stdName)
//
//
//
//        var intent = intent
//
//        if(intent.extras!= null){
//            val studname = intent.getStringExtra("studname")
//            val stdName = intent.getStringExtra("stdName")
////            frstRank.text= "$studname $stdName get Highest Marks"
//
//            stdntName.text = "$studname $stdName"
//        }
//        else{
//            stdntName.text = "No Student Selected"
//        }
//
//
//

//    }
//}