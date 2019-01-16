package link.quizassgn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        //get RatingBar object
        RatingBar ratingBar = findViewById(R.id.ratingBar);
        ratingBar.setNumStars(5);
        //ratingBar.setStepSize(1f);

        //get TextView
        TextView resultTextView = findViewById(R.id.result_textView);

        //get score
        Bundle bundle = getIntent().getExtras();
        int score = bundle.getInt("score");
        //display score
        ratingBar.setRating(score);

        switch (score){
            case 0: resultTextView.setText(R.string.res0);
                break;
            case 1: resultTextView.setText(R.string.res1);
                break;
            case 2: resultTextView.setText(R.string.res2);
                break;
            case 3: resultTextView.setText(R.string.res3);
                break;
            case 4: resultTextView.setText(R.string.res4);
                break;
            case 5: resultTextView.setText(R.string.res5);
                break;
        }
    }
}
