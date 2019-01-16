package link.quizassgn;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import link.quizassgn.data.DatabaseHelper;

public class PlayQuizActivity extends AppCompatActivity {

    List<Questions> questionList;
    int score = 0;
    int questID = 0;
    Questions currentQuestion;
    TextView questionTextView;
    RadioButton rb1, rb2, rb3;
    Button nextBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_quiz);

        DatabaseHelper dbHelp = new DatabaseHelper(this);
        questionList = dbHelp.getAllQuestions();
        currentQuestion = questionList.get(questID);

        questionTextView = findViewById(R.id.questionTxtView);
        rb1 = findViewById(R.id.radio_btn_1);
        rb2 = findViewById(R.id.radio_btn_2);
        rb3 = findViewById(R.id.radio_btn_3);
        nextBtn = findViewById(R.id.button_next);

        setQuestionView();

       nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RadioGroup radioGroup = findViewById(R.id.radioGroup);
                RadioButton answer = findViewById(radioGroup.getCheckedRadioButtonId());
                radioGroup.clearCheck();

                if (answer != null && currentQuestion.getAnswer().contentEquals(answer.getText())) {
                    score++;
                }

                if (questID < 5 ){
                    currentQuestion = questionList.get(questID);
                    setQuestionView();
                }else{

                    Intent resultIntent = new Intent(PlayQuizActivity.this,ResultActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("score",score);
                    resultIntent.putExtras(bundle);
                    startActivity(resultIntent);
                    finish();

                  /* AlertDialog.Builder builder = new AlertDialog.Builder(PlayQuizActivity.this);
                    builder.setMessage("Your score is " + score + " of possible 5 points");
                    builder.setCancelable(false);
                    builder.setPositiveButton("New Game", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            recreate();
                        }
                    });

                            builder.setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    });

                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();*/
                }
            }
        });
    }

    private void setQuestionView() {
        questionTextView.setText(currentQuestion.getQuestion());
        rb1.setText(currentQuestion.getOptionA());
        rb2.setText(currentQuestion.getOptionB());
        rb3.setText(currentQuestion.getOptionC());
        questID++;
    }
}
