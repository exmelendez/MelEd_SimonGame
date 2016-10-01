package nyc.c4q.eddie.simongame;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button blueBt = (Button) findViewById(R.id.blueBt);

        blueBt.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                blueBt.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                return false;
            }
        });

        blueBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });

        //Button sound
        final MediaPlayer buttonSound = MediaPlayer.create(this, R.raw.s1);

        //button reference
        Button button = (Button) this.findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                buttonSound.start();
                startActivity(new Intent(MainActivity.this));

            }

        });

    }

    public void buttonClicked (View v){
//        v.setBackgroundColor();



    }
}
