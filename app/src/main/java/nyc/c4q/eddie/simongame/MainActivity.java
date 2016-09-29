package nyc.c4q.eddie.simongame;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        TextView scoreBoard = (TextView)findViewById(R.id.score_board);
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
    }

    public void buttonClicked (View v){
//        v.setBackgroundColor();



    }
}
