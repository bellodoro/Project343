package example.com.project343;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by isahbellodoro on 10/5/15.
 */
public class userprofile  extends Activity implements{

    DatabaseOperations

    ImageButton imageButton4,textView,textView2,textView3,textView4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userprofile);


        imageButton4 = (ImageButton) findViewById(R.id.imageButton4);


        imageButton4.setOnClickListener(this);

    }


    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageButton:

                break;
            case R.id.imageButton4:
                startActivity(new Intent(this, searchbar.class));

                break;


        }
    }
}