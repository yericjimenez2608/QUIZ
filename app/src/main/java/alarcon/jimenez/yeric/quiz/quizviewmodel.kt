package alarcon.jimenez.yeric.quiz

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel


const val CURRENT_INDEX_KEY = "CURRENT_INDEX_KEY"
class quizviewmodel (private val savedStateHandle: SavedStateHandle): ViewModel() {
    private val questionBank = listOf(
        PREGUNTAS(R.string.primera, false),
        PREGUNTAS(R.string.segunda, false),
        PREGUNTAS(R.string.tercera, false),
        PREGUNTAS(R.string.cuarta, true),
        PREGUNTAS(R.string.quinta, true),
        PREGUNTAS(R.string.sexta, false),
        PREGUNTAS(R.string.septima, false),
        PREGUNTAS(R.string.octava, false),
        PREGUNTAS(R.string.novena, false),
        PREGUNTAS(R.string.decima, false))

    private var currentIndex
        get() = savedStateHandle.get(CURRENT_INDEX_KEY) ?: 0
        set(value) = savedStateHandle.set(CURRENT_INDEX_KEY, value)

    private var pre = 0
    val currentQuestionAnswer: Boolean
        get() = questionBank[currentIndex].answer
    val currentQuestionText: Int
        get() = questionBank[currentIndex].textResId
    fun moveToNext() {
        if (pre < 9){
            pre += 1
        }else{
            pre = 0
        }
        currentIndex = pre
    }
    fun movetoBack(){
        if (pre > 0){
            pre -= 1
        }else{
            pre = 9
        }
        currentIndex = pre
    }
}