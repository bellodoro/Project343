package example.com.project343;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;


public class Register extends Activity implements View.OnClickListener {

    Button bRigister,searchbarb;
    EditText etName, etUsername, etAge, etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        etName =(EditText) findViewById(R.id.etName);
        etUsername =(EditText) findViewById(R.id.etUsername);
        etAge = (EditText) findViewById(R.id.etAge);
        etPassword =(EditText) findViewById(R.id.etPassword);
        bRigister = (Button) findViewById(R.id.bRegister);


        bRigister.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bRegister:

                break;
            case R.id.viewfrd:
                startActivity(new Intent(this,searchbar.class));

                break;
        }
    }
}
