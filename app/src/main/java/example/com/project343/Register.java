package example.com.project343;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;


public class Register extends Activity{

    Button REG;
    EditText USER_NAME,CON_PASS, USER_PASS, USER_FNAME,USER_GENDER,USER_HUBBY;
    String user_name,user_pass,con_pass,user_gender,user_hubby,user_fname;
    Context ctx = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        USER_NAME =(EditText) findViewById(R.id.etName);
        CON_PASS = (EditText) findViewById(R.id.etAge);
        USER_PASS =(EditText) findViewById(R.id.etPassword);
        REG = (Button) findViewById(R.id.bRegister);
        USER_FNAME = (EditText) findViewById(R.id.etUsername);
        USER_GENDER = (EditText) findViewById(R.id.etgander);
        USER_HUBBY = (EditText) findViewById(R.id.ethubby);
        REG.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {
                user_name = USER_NAME.getText().toString();
                user_pass = USER_PASS.getText().toString();
                con_pass = CON_PASS.getText().toString();
                user_gender = USER_GENDER.getText().toString();
                user_hubby = USER_HUBBY.getText().toString();
                user_fname = USER_FNAME.getText().toString();


                if (!(user_pass.equals(con_pass))) {
                    Toast.makeText(getBaseContext(), "password are not matching", Toast.LENGTH_LONG).show();
                    USER_NAME.setText("");
                    USER_PASS.setText("");
                    CON_PASS.setText("");
                    USER_HUBBY.setText("");
                    USER_GENDER.setText("");
                    USER_FNAME.setText("");

                } else {
                    DatabaseOperations DB = new DatabaseOperations(ctx);
                    DB.putInformation(DB,user_name,user_pass);
                    Toast.makeText(getBaseContext(), "Registration Success", Toast.LENGTH_LONG).show();
                    finish();
                }


            }

        });
    }}