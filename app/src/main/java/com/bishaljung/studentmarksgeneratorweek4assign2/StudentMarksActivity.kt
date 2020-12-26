package com.bishaljung.studentmarksgeneratorweek4assign2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AlertDialog
class StudentMarksActivity : AppCompatActivity() {
    var counter = 0
    private lateinit var  stdListView : ListView
    private lateinit var studentid : EditText
    private lateinit var studentName : EditText
    private lateinit var iotMarks : EditText
    private lateinit var ApiMarks : EditText
    private lateinit var AndroMarks : EditText
    private lateinit var builder: AlertDialog.Builder
    private  lateinit var proceed: Button
    private val studentArrayList = ArrayList<Student>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_marks)
//        binding of the varibles with views
        studentid = findViewById(R.id.stdId)
        studentName = findViewById(R.id.stdName)
        iotMarks = findViewById(R.id.iotMarks)
        ApiMarks = findViewById(R.id.ApiMarks)
        AndroMarks = findViewById(R.id.AndroMarks)
        proceed = findViewById(R.id.btnProc)
        stdListView = findViewById(R.id.stdListView)
        btnAddClick()
    }
    private fun btnAddClick() {
        proceed.setOnClickListener {
            if (inputValidation()) {
                counter++
                val ID = studentid.text.toString()
                val name = studentName.text.toString()
                val androidMarks = AndroMarks.text.toString().toFloat()
                val apiMarks = ApiMarks.text.toString().toFloat()
                val iotMarks = iotMarks.text.toString().toFloat()
                studentArrayList.add(Student(ID,name, androidMarks, apiMarks, iotMarks))
                if (counter == 3) {
                    val intent=Intent(this,ResultPageActivity::class.java)
                    intent.putExtra("studentArrayList",studentArrayList)
                    startActivity(intent)
//                student = Student(ID, name, androidMarks, apiMarks, iotMarks)
//                Toast.makeText(this,"$counter",Toast.LENGTH_SHORT).show()
//                    resultAlert()
                    finish()
                }
                addNewStudent()
            } else {
                return@setOnClickListener
            }
        }
    }

    private fun inputValidation(): Boolean {
        var valid = true
        when {
            TextUtils.isEmpty(studentid.text.toString()) -> {
                studentid.error = "ID cannot be empty"
                studentid.requestFocus()
                valid = false
            }
            TextUtils.isEmpty(studentName.text.toString()) -> {
                studentName.error = "Name cannot be empty"
                studentName.requestFocus()
                valid = false
            }
            TextUtils.isEmpty(AndroMarks.text.toString()) -> {
                AndroMarks.error = "Android marks cannot be empty"
                AndroMarks.requestFocus()
                valid = false
            }
            TextUtils.isEmpty(ApiMarks.text.toString()) -> {
                ApiMarks.error = "API marks cannot be empty"
                ApiMarks.requestFocus()
                valid = false
            }
            TextUtils.isEmpty(iotMarks.text.toString()) -> {
                iotMarks.error = "IOT marks cannot be empty"
                iotMarks.requestFocus()
                valid = false
            }
        }
        return valid
    }
    private fun resultAlert() {
        builder = AlertDialog.Builder(this)
        builder.setTitle("Calculate Final Result")
        builder.setIcon(android.R.drawable.ic_input_get)
        builder.setMessage("Result of all three students is recorded. Click Yes to view final result")
        builder.setPositiveButton("Yes") { _, _ ->
            val intent = Intent(this, ResultPageActivity::class.java)
            startActivity(intent)
            finish()
        }
        builder.setNegativeButton("No") { dialogInterface, _ ->
            counter = 2
            dialogInterface.cancel()
        }
        val alertDialog: AlertDialog = builder.create()
        alertDialog.setCancelable(false)
        alertDialog.show()
    }
    private fun addNewStudent(){
        studentid.setText("")
        studentName.setText("")
        AndroMarks.setText("")
        ApiMarks.setText("")
        iotMarks.setText("")
        studentid.requestFocus()
    }
}

//class StudentMarksActivity : AppCompatActivity() {
//    private lateinit var  stdListView : ListView
//    private lateinit var studentid : EditText
//    private lateinit var studentName : EditText
//    private lateinit var iotMarks : EditText
//    private lateinit var ApiMarks : EditText
//    private lateinit var AndroMarks : EditText
//
//    private val students = arrayOf(
//            "Manish BC",
//            "Ujjwal Humagain",
//            "Success Bhattrai"
//    )
//
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_student_marks)
//
//        studentid = findViewById(R.id.stdId)
//        studentName = findViewById(R.id.stdName)
//        iotMarks = findViewById(R.id.iotMarks)
//        ApiMarks = findViewById(R.id.ApiMarks)
//        AndroMarks = findViewById(R.id.AndroMarks)
////        proceed = findViewById(R.id.btnProceed)
//        stdListView = findViewById(R.id.stdListView)
//        val stdnameview = mutableMapOf<String, String>()
//        for (i in students.indices step 1){
//            stdnameview[students[i]] = students[i]
//        }
//
//        val adapter = ArrayAdapter(
//            this, android.R.layout.simple_list_item_1, stdnameview.keys.toTypedArray()
//        )
//        stdListView.adapter = adapter
//        stdListView.setOnItemClickListener { parent, view, position, id ->
//
//
//            val intent = Intent(this, ResultPageActivity::class.java)
//            startActivity(intent)
//
//            val studname = parent.getItemAtPosition(position).toString()
//            intent.putExtra("studname", studname)
//            startActivity(intent)
//
//        }
//
//
//    }
//}

















































































//            val iot : String = iotMarks.getText().toString()
//            intent.putExtra("Iot Marks" , iot)
//            val api : String = ApiMarks.getText().toString()
//            intent.putExtra("Api Marks", api)
//
//            val andro : String = AndroMarks.getText().toString()
//            intent.putExtra("Andro Marks", andro)
//
//            val stdID = studentid.getText()
//            intent.putExtra("Student ID", stdID)
//
//            val stdentName : String = studentName.getText().toString()
//            intent.putExtra("Student Name", stdentName)