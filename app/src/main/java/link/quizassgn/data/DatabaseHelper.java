package link.quizassgn.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import link.quizassgn.Questions;

import static link.quizassgn.data.QuizContract.QuestionEntry.*;

public class DatabaseHelper extends SQLiteOpenHelper {


    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "quiz.db";
    // tasks table name

    private SQLiteDatabase dbase;

    public DatabaseHelper (Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        this.dbase = db;

        String CREATE_QUESTIONS_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " ( "
                + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_QUESTION + " TEXT, " +
                COLUMN_ANSWER + " TEXT, " +
                COLUMN_OPTIONA + " TEXT, " +
                COLUMN_OPTIONB +" TEXT, " +
                COLUMN_OPTIONC + " TEXT)";

        db.execSQL(CREATE_QUESTIONS_TABLE);
        addQuestions();
        //db.close();
    }
    private void addQuestions() {
        Questions q1 = new Questions("The winner of the 1991 European Champion Cup was...?","Crvena Zvezda", "Barcelona ", "Milan", "Crvena Zvezda");
        this.addQuestion(q1);
        Questions q2 = new Questions("Mister No is ... ?", "Musician", "Comic book hero", "DJ", "Comic book hero");
        this.addQuestion(q2);
        Questions q3 = new Questions("Ivo Andric was awarded the Nobel prize for ...?","Literature", "Chemistry","Peace", "Literature" );
        this.addQuestion(q3);
        Questions q4 = new Questions("Capital city of Brasil is ... ?", "Rio Da Janeiro", "Sao Paolo", "Brasilia","Brasilia");
        this.addQuestion(q4);
        Questions q5 = new Questions("\"Adventure of Sherlock Holmes\" was written by ... ?","Agatha Christie","Stephen King","Arthur Conan Doyle","Arthur Conan Doyle");
        this.addQuestion(q5);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        // Create tables again
        onCreate(db);
    }
    // Adding new question
    public void addQuestion(Questions quest) {
        //SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_QUESTION, quest.getQuestion());
        values.put(COLUMN_ANSWER, quest.getAnswer());
        values.put(COLUMN_OPTIONA, quest.getOptionA());
        values.put(COLUMN_OPTIONB, quest.getOptionB());
        values.put(COLUMN_OPTIONC, quest.getOptionC());
        // Inserting Row
        dbase.insert(TABLE_NAME, null, values);
    }
    public List<Questions> getAllQuestions() {

        List<Questions> questionList = new ArrayList<Questions>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_NAME;
        dbase = this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Questions quest = new Questions();
                quest.setID(cursor.getInt(0));
                quest.setQuestion(cursor.getString(1));
                quest.setAnswer(cursor.getString(2));
                quest.setOptionA(cursor.getString(3));
                quest.setOptionB(cursor.getString(4));
                quest.setOptionC(cursor.getString(5));
                questionList.add(quest);
            } while (cursor.moveToNext());
        }
        // return quest list
        return questionList;
    }
    public int rowcount() {
        int row=0;
        String selectQuery = "SELECT  * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        row=cursor.getCount();
        return row;
    }
}
