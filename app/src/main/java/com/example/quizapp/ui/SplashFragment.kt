package com.example.quizapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation
import com.example.quizapp.R
import com.example.quizapp.db.Quiz
import com.example.quizapp.db.QuizDatabase
import com.example.quizapp.utils.BaseFragment
import com.example.quizapp.utils.PrefManager
import kotlinx.coroutines.launch

class SplashFragment : BaseFragment() {

    private lateinit var tvWelcome: TextView
    private var prefManager: PrefManager? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        prefManager = PrefManager(context)
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_splash, container, false)
        tvWelcome = view.findViewById(R.id.logo_welcome)
        addQuestionsToDB()
        return view
    }

    override fun onResume(){
        super.onResume()
        tvWelcome.postDelayed({
            if (!prefManager?.isFirstTimeLaunch()!!) {
                Navigation.findNavController(requireView()).navigate(R.id.action_splashFragment_to_homeFragment)
            }else{
                Navigation.findNavController(requireView()).navigate(R.id.action_splashFragment_to_welcomeFragment)
            }
        }, 1000)
    }

    fun addQuestionsToDB(){
        val quiz1 = Quiz(1L,"1) What is Android?","A. an open-source operating system", "B. a web browser","C. a web server","D. None of the above","a","Answer: (a) an open-source operating system\n" +
                "\n" +
                "Explanation: Android is an open-source operating system and is mainly popular for Smartphones and Tablets.")
        val quiz2 = Quiz(2L,"2) What is the Android SDK?", "A. an operating system","B. a mobile application","C. a set of tools","D. None of the above","c","Answer: (c) a set of tools\n" +
                "\n" +
                "Explanation: To develop a mobile application, Android developers require some tools and this requirement is satisfied by “Android SDK” which is a set of tools that are used for developing or writing apps.")
        val quiz3 = Quiz(3L,"3) What is DDMS in android?","A. Dalvik memory server", "B. Device memory server","C. Dalvik monitoring services","D. Dalvik debug monitor services","d","Answer: (d) Dalvik debug monitor services\n" +
                "\n" +
                "Explanation: DDMS provides port forwarding, screen capturing, memory mapping, logcat, calls, SMS etc.")
        val quiz4 = Quiz(4L,"4) Is it possible activity without UI in android?","A. No, it's not possible", "B. We can't say","C. Yes,it's possible","D. None of the above","c","Answer: (c) Yes,it's possible\n" +
                "\n" +
                "Explanation: Without UI, we can call an activity, It will do some background functionalities.")
        val quiz5 = Quiz(5L,"5) What is off-line synchronization in android?","A. Synchronization with internet", "B. Synchronization without internet","C. Background synchronization","D. None of the above","b","Answer: (b) Synchronization without internet\n" +
                "\n" +
                "Explanation: Synchronization without internet in which we can take the application data without internet.")
        val quiz6 = Quiz(6L,"6) What is the use of content provider in android?","A. To share the data between applications", "B. To send the data from an application to another application","C. To store the data in a database","D. None of the above","a","Answer: (a) To share the data between applications\n" +
                "\n" +
                "Explanation: Content provider is used to share the data between applications.")
        val quiz7 = Quiz(7L,"7) What is android view group?","A. Base class of building blocks", "B. Layouts","C. Collection of views and other child views","D. None of the above","c","Answer: (c) Collection of views and other child views\n" +
                "\n" +
                "Explanation: View Group is collaborating with views and other child views,It is an invisible container and base classes for layouts.")
        val quiz8 = Quiz(8L,"8) In android, mini activities are also known as","A. Fragment", "B. Adapter","C. Activity","D. None of the above","a","Answer: (a) Fragment\n" +
                "\n" +
                "Explanation: In android, mini activities are also known as Fragments.")
        val quiz9 = Quiz(9L,"9) Who manages data sharing between applications?","A. Telephony managers", "B. Content providers","C. Location manager","D. Activity manager","b","Answer: (b) Content providers\n" +
                "\n" +
                "Explanation: Data sharing between applications is managed by content providers.")
        val quiz10 = Quiz(10L,"10) Identify the parent class of activity.","A. contextThemeWrapper", "B. context","C. object","D. None of the above","a","Answer: (a) contextThemeWrapper\n" +
                "\n" +
                "Explanation: The contextThemeWrapper class is the parent class of activity.")
        val quiz11 = Quiz(11L,"11) Identify among the following which is not a state in the service lifecycle.","A. Running", "B. Start","C. Paused","D. Destroyed","c","Answer: (c) Paused\n" +
                "\n" +
                "Explanation: Paused is not a state in the service lifecycle.")
        val quiz12 = Quiz(12L,"12) Choose the built-in database of Android.","A. MySQL", "B. Oracle","C. SQLite","D. None of the above","c","Answer: (c) SQLite\n" +
                "\n" +
                "Explanation: SQLite Is the built-in database of Android.")
        val quiz13 = Quiz(13L,"13) The full form of ANR is.","A. Application not responding", "B. Application not rendering","C. Application not reacting","D. Application not reachable","a","Answer: (a) Application not responding\n" +
                "\n" +
                "Explanation: ANR stands for Application not responding.")
        val quiz14 = Quiz(14L,"14) Identify the layout in which Android arranges its children into rows and columns.", "A. FrameLayout", "B. RelativeLayout","C. TableLayout","D. All of the above","c","Answer: (c) TableLayout\n" +
                "\n" +
                "Explanation: TableLayout arranges its children into rows and columns.")
        val quiz15 = Quiz(15L,"15) Transient data in Android is.","A. Secure Data", "B. Permanent data","C. Logical data","D. Temporary data","c","Answer: (c) Logical data\n" +
                "\n" +
                "Explanation: Transient data in Android is logical data.")

        launch {
            context?.let {
                QuizDatabase(it)
                    .getQuizDao().deleteAllQuiz()
                QuizDatabase(it)
                    .getQuizDao().addQuizzes(quiz1,quiz2,quiz3,quiz4,quiz5,quiz6,quiz7,quiz8,
                        quiz9,quiz10,quiz11,quiz12,quiz13,quiz14,quiz15)
            }
        }
    }
}