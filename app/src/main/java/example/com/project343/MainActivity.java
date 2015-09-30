package example.com.project343;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends Activity implements View.OnClickListener{

    Button bLogout;
    EditText etName, etAge, etUsername,etgander;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = (EditText) findViewById(R.id.etName);
        etAge = (EditText) findViewById(R.id.etAge);
        etUsername =(EditText) findViewById(R.id.etUsername);
        etgander =(EditText) findViewById(R.id.etgander);



       bLogout =(Button) findViewById(R.id.bLogout);

       bLogout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.bLogout:

                startActivity(new Intent(this, Login.class));

                break;

        }
    }
}
