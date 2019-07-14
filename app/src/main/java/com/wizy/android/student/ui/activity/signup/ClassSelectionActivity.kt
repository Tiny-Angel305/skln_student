package com.wizy.android.student.ui.activity.signup

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.wizy.android.student.R
import com.wizy.android.student.base.BaseToolbarActivity
import com.wizy.android.student.helper.AppConstants
import com.wizy.android.student.model.Choice
import com.wizy.android.student.model.Student
import com.wizy.android.student.ui.adapter.ClassAdapter
import kotlinx.android.synthetic.main.activity_class_selection.*


class ClassSelectionActivity : BaseToolbarActivity(), ClassAdapter.NextClickListener {
    private var student: Student? = null
    private var classes: MutableList<Choice> = arrayListOf()
    private var adapter: ClassAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_class_selection)
        getIntentData()
    }

    private fun getIntentData() {
        if (intent.hasExtra(AppConstants.INTENT_USER)) {
            student = intent.getSerializableExtra(AppConstants.INTENT_USER) as Student
            getClasses()
        } else {
            showIntentIsNull()
        }
    }

    private fun getClasses() {
        var studentClass = Choice()
        studentClass.name = Student.Standard.FIVE.toString()
        studentClass.colorString = "#171733"
        studentClass.image = R.drawable.five
        classes.add(studentClass)

        studentClass = Choice()
        studentClass.name = Student.Standard.SIX.toString()
        studentClass.colorString = "#8A89FA"
        studentClass.image = R.drawable.six
        classes.add(studentClass)

        studentClass = Choice()
        studentClass.name = Student.Standard.SEVEN.toString()
        studentClass.colorString = "#C06BA6"
        studentClass.image = R.drawable.seven
        classes.add(studentClass)

        studentClass = Choice()
        studentClass.name = Student.Standard.EIGHT.toString()
        studentClass.colorString = "#FA6B6C"
        studentClass.image = R.drawable.eight
        classes.add(studentClass)

        studentClass = Choice()
        studentClass.name = Student.Standard.NINE.toString()
        studentClass.colorString = "#007170"
        studentClass.image = R.drawable.nine
        classes.add(studentClass)

        studentClass = Choice()
        studentClass.name = Student.Standard.TEN.toString()
        studentClass.colorString = "#91A2B1"
        studentClass.image = R.drawable.ten
        classes.add(studentClass)

        studentClass = Choice()
        studentClass.name = Student.Standard.ELEVEN.toString()
        studentClass.colorString = "#7DD9FD"
        studentClass.image = R.drawable.eleven
        classes.add(studentClass)

        studentClass = Choice()
        studentClass.name = Student.Standard.TWELVE.toString()
        studentClass.colorString = "#FF5464"
        studentClass.image = R.drawable.twelve
        classes.add(studentClass)

        setUpRecyclerView()
    }

    private fun showIntentIsNull() {
        Toast.makeText(this, getString(R.string.intent_is_null), Toast.LENGTH_SHORT).show()
        this.finish()
    }

    private fun setUpRecyclerView() {
        if (classes.size > 0) {
            adapter = ClassAdapter(this, classes, this)
            val gridLayoutManager = GridLayoutManager(this, 2)
            gridLayoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
                override fun getSpanSize(position: Int): Int {
                    return when (position) {
                        classes.size -> {
                            2
                        }
                        else -> {
                            1
                        }
                    }
                }
            }
            rvClasses.layoutManager = gridLayoutManager
            rvClasses.adapter = adapter
        }
    }

    override fun onClickNext(standard: Student.Standard) {
        student?.standard = standard
        moveToNextActivity()
    }

    private fun moveToNextActivity() {
        startActivity(
            Intent(this, GreetingActivity::class.java)
                .putExtra(AppConstants.INTENT_USER, student)
        )
    }
}
