package link.quizassgn.data;

import android.provider.BaseColumns;

public class QuizContract {

    public static class QuestionEntry implements BaseColumns {

        public static final String TABLE_NAME = "questions";
        // tasks Table Columns names
        public static final String _ID = "id";
        public static final String COLUMN_QUESTION = "question";
        public static final String COLUMN_ANSWER = "answer"; //correct option
        public static final String COLUMN_OPTIONA= "optiona"; //option a
        public static final String COLUMN_OPTIONB= "optionb"; //option b
        public static final String COLUMN_OPTIONC= "optionc"; //option c
    }
}
