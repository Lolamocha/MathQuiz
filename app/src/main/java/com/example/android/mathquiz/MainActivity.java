package com.example.android.mathquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;




public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // This method returns the score for the  A question
    public int A_correct_answer1(int score) {
        //Casting the radio button for the A question
        RadioButton A_correct_answer1 = findViewById(R.id.A_correct_answer1);
        //Adds two point, only if A_correct_answer1 is selected
        if (A_correct_answer1.isChecked()) {
            score += 2;
        }
        return score;
    }

    // This method returns the score for the B question
    public int B_correct_answer3(int score) {
        //Casting the radio button for the B question
        RadioButton B_correct_answer3 = findViewById(R.id.B_correct_answer3);
        //Adds two point, only if B_correct_answer3 is selected
        if (B_correct_answer3.isChecked()) {
            score += 2;
        }
        return score;
    }

    // This method returns the score for the C question
    public int C_correct_answer2(int score) {
        //Casting the radio button for the C question
        RadioButton C_correct_answer2 = findViewById(R.id.C_correct_answer2);
        //Adds two point, only if C_correct_answer2 is selected
        if (C_correct_answer2.isChecked()) {
            score += 2;
        }
        return score;
    }

    //This method checks answers for the E question, and returns score for each correct answer
    public int E_question(int score) {
        //Casting the check boxes for the E question
        CheckBox questionEa1 = findViewById(R.id.E_answer1);
        CheckBox questionEa2 = findViewById(R.id.E_answer2);
        CheckBox questionEa3 = findViewById(R.id.E_answer3);
        CheckBox questionEa4 = findViewById(R.id.E_answer4);

        //Adds one point for each correct answer
        if (!questionEa1.isChecked() && questionEa2.isChecked() && questionEa3.isChecked() && questionEa4.isChecked()) {
            score += 1;
        }
        return score;
    }

    // This method is called when the submitBTN is clicked.
    public void submitScore(View view) {
        EditText enterName = findViewById(R.id.enter_name);
        String  playerName = enterName.getText().toString();

        RadioButton A_correct_answer1 = findViewById(R.id.A_correct_answer1);
        boolean aPressedQuestion = A_correct_answer1.isChecked();

        RadioButton B_correct_answer3 = findViewById(R.id.B_correct_answer3);
        boolean bPressedQuestion = B_correct_answer3.isChecked();

        RadioButton C_correct_answer2 = findViewById(R.id.C_correct_answer2);
        boolean cPressedQuestion = C_correct_answer2.isChecked();

        CheckBox E_answer1 = findViewById(R.id.E_answer1);
        boolean eCheckAnswer1 = E_answer1.isChecked();
        CheckBox E_answer2 = findViewById(R.id.E_answer2);
        boolean eCheckAnswer2 = E_answer2.isChecked();
        CheckBox E_answer3 = findViewById(R.id.E_answer3);
        boolean eCheckAnswer3 = E_answer3.isChecked();
        CheckBox E_answer4 = findViewById(R.id.E_answer4);
        boolean eCheckAnswer4 = E_answer4.isChecked();

        int score = calculateScore(aPressedQuestion, bPressedQuestion, cPressedQuestion,
                eCheckAnswer1, eCheckAnswer2, eCheckAnswer3, eCheckAnswer4);

        String playerMessage = gameSummary(score, playerName);
        displayMessage(playerMessage);
    }

    //This string is called to show the game summary
    private void displayMessage(String message) {
        TextView gameSummary = findViewById(R.id.game_summary);
        gameSummary.setText(message);
    }
    //This method calculates the score
    private int calculateScore(boolean aPressedQuestion, boolean bPressedQuestion, boolean cPressedQuestion,
                               boolean eCheckAnswer1, boolean eCheckAnswer2, boolean eCheckAnswer3, boolean eCheckAnswer4) {
        int score = 0;
        if (aPressedQuestion) {
            score += 2;
        }
        if (bPressedQuestion) {
            score += 2;
        }
        if (cPressedQuestion) {
            score += 2;
        }
        if (eCheckAnswer1) {
            score += 1;
        }
        if (eCheckAnswer2) {
            score += 1;
        }
        if (eCheckAnswer3) {
            score += 1;
        }
        if (eCheckAnswer4) {
            score += 1;
        }
        return score;
    }
    //Game Summary called when player clicks submit
    private String gameSummary(int score, String playerName){
       // imageView.setBackgroundResource(R.drawable.my_image);
       // imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

        //Toast toast = Toast.makeText(test.this,"bbb", Toast.LENGTH_LONG);
        //toast.setGravity(Gravity.CENTER, 0, 0);
        //toast.show();

        String scoreMessage = "Well done " + playerName + "!" + "\nYour score is : \n" + score + " out of 10!";
        Toast toast = Toast.makeText(this, "Well done "+ playerName + "!" +
                        "\nYour score is : " + score + " out of 10!", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();


       // Toast.makeText(this, "Well done "+ playerName + "!" +
               // "\nYour score is : " + score + " out of 10!", Toast.LENGTH_LONG).show();

        return scoreMessage;
    }

    //Click Reset to reset quiz
    public void resetQuiz(View view) {
        finish();
        startActivity(getIntent());
    }
}
