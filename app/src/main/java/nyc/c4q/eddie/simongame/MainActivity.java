package nyc.c4q.eddie.simongame;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button redBtn;
    private Button blueBtn;
    private Button greenBtn;
    private Button yellowBtn;
    private Button startBtn;
    private Handler time;
    private int gameRound = 0;
    private List<Integer> startingNumArray = new ArrayList<Integer>();
    private int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startBtn = (Button) findViewById(R.id.startBt);
        redBtn = (Button) findViewById(R.id.redBt);
        blueBtn = (Button) findViewById(R.id.blueBt);
        yellowBtn = (Button) findViewById(R.id.yellowBt);
        greenBtn = (Button) findViewById(R.id.greenBt);

        redBtn.setOnClickListener(this);
        blueBtn.setOnClickListener(this);
        greenBtn.setOnClickListener(this);
        yellowBtn.setOnClickListener(this);

        redBtn.setEnabled(false);
        blueBtn.setEnabled(false);
        greenBtn.setEnabled(false);
        yellowBtn.setEnabled(false);

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                beginGame(true);
                startBtn.setClickable(false);
                startBtn.setText(String.valueOf(gameRound));


            }
        });
    }




    /**
     * @param button:      get reference view that is going to be used for changing the background color to a lighter one
     * @param main_color:  original color
     * @param hover_color: a lighter color
     * @param indexTime:   to delay the first button, second... and so on
     */
    public void flashUpButtons(final Button button, final int main_color, final int hover_color, final int indexTime) {
        time = new Handler();
        time.postDelayed(new Runnable() {
            @Override
            public void run() {
                button.setBackgroundColor(getResources().getColor(hover_color));
            }
        }, 900 * indexTime);
        time.postDelayed(new Runnable() {
            public void run() {
                button.setBackgroundColor(getResources().getColor(main_color));
            }
        }, 900 * indexTime + 500); // will go back after a half of a second
    }

    /**
     * Restart everything
     */
    public void beginGame(boolean reset) {

        if (reset){
            /**
             * Enabling all buttons again
             */
            redBtn.setEnabled(true);
            greenBtn.setEnabled(true);
            blueBtn.setEnabled(true);
            yellowBtn.setEnabled(true);
            gameRound = 0;
            gameRound++;
        }


        //startingNumArray = new ArrayList<>(); // clicked  Start button and create an empty array
        // Generate random number depending on your level and add them in to starting array


        //Generate random numbers according to the level

        //for (int i = 0; i < gameRound; i++) { // it will make + 1
            Random nums = new Random();
            int colorNum = nums.nextInt(4);
            // add a random number
            startingNumArray.add(colorNum); // run gameRound times and add the numbers into an array
        //}



        //make buttons to blink
        matchingColors(startingNumArray); // match numbers to colors

    }



    public void validateUserInput(int colorNumber) {
        if (startingNumArray.get(index) == colorNumber) {
            index++;

            // if all checks matches the size of the array it means you won
            if (index == startingNumArray.size()) {

                // and you will go to the next level
                gameRound++;
                index = 0;

                //Changes the start button where it shows the round
                startBtn.setText(String.valueOf(gameRound));
                beginGame(false);

            }
        } else {
            /**
             * if you lose then we have to reset the game level and disable all buttons until
             * you press start
             * Start button cannot be disabled because you wouldn't be able to restart the game
             */

            Toast.makeText(MainActivity.this, "You Lost!", Toast.LENGTH_SHORT)
                    .show();
            startingNumArray.clear();
            startBtn.setText("START");
            redBtn.setEnabled(false);
            greenBtn.setEnabled(false);
            blueBtn.setEnabled(false);
            yellowBtn.setEnabled(false);
            startBtn.setClickable(true);

        }

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.redBt:
                validateUserInput(0);
                break;
            case R.id.greenBt:
                validateUserInput(1);
                break;
            case R.id.blueBt:
                validateUserInput(2);
                break;
            case R.id.yellowBt:
                validateUserInput(3);
                break;
        }
    }

    public void matchingColors(List<Integer> givenArray) {
        for (int index = 0; index < givenArray.size(); index++) {

            switch (givenArray.get(index)) {
                case 0:
                    flashUpButtons(redBtn, R.color.red, R.color.hover_red, index + 1);
                    break;
                case 1:
                    flashUpButtons(greenBtn, R.color.green, R.color.hover_green, index + 1);
                    break;
                case 2:
                    flashUpButtons(blueBtn, R.color.blue, R.color.hover_blue, index + 1);
                    break;
                case 3:
                    flashUpButtons(yellowBtn, R.color.yellow, R.color.hover_yellow, index + 1);
                    break;
            }
        }

    }
}







