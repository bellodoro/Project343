package example.com.project343;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Login extends Activity implements View.OnClickListener{

    Button bLogin;
            EditText etUsername, etPassword;
    TextView tvRgisterLink;
    private Login self;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);
        bLogin = (Button) findViewById(R.id.bLogin);
        tvRgisterLink = (TextView) findViewById(R.id.tvRigisterLink);

        bLogin.setOnClickListener(this);
        tvRgisterLink.setOnClickListener(this);
        self = this;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bLogin:

                break;

            case R.id.tvRigisterLink:
                Log.d("MSG", "tvRigisterLink is clicked!!!!!!!");

                startActivity(new Intent(self, Register.class));

                break;

        }
    }
}
