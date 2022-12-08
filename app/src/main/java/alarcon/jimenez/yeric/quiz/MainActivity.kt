package alarcon.jimenez.yeric.quiz

import alarcon.jimenez.yeric.quiz.databinding.ActivityMainBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.viewModels
import com.google.android.material.snackbar.Snackbar

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val quizViewModel: quizviewmodel by viewModels()




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate(Bundle?) called")
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d(TAG, "Got a QuizViewModel: $quizViewModel")


        binding.trueButton.setOnClickListener { view: View ->

            checkAnswer(true)
         }
        binding.falseButton.setOnClickListener { view: View ->

            checkAnswer(false)
        }
        binding.nextButton.setOnClickListener {

            quizViewModel.moveToNext()

            updateQuestion()

        }
        binding.backButton.setOnClickListener {

            quizViewModel.movetoBack()

            updateQuestion()

        }

        updateQuestion()

    }
    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart() called")
    }
    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume() called")
    }
    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause() called")
    }
    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop() called")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy() called")
    }

    private fun updateQuestion() {
        val questionTextResId = quizViewModel.currentQuestionText
        binding.questionTextView.setText(questionTextResId)
    }
    private fun checkAnswer(userAnswer: Boolean) {
        val correctAnswer = quizViewModel.currentQuestionAnswer
        val messageResId = if (userAnswer == correctAnswer) {
            val snack = Snackbar.make(findViewById(R.id.true_button),"correcto",Snackbar.LENGTH_LONG)
            snack.setBackgroundTint(getColor(R.color.verde))
            snack.show()

        } else {
            val snack = Snackbar.make(findViewById(R.id.false_button),"falso",Snackbar.LENGTH_LONG)
            snack.setBackgroundTint(getColor(R.color.rojo))
            snack.show()

        }

    }

}
