package example.com.project343;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;


public class MainActivity extends Activity implements View.OnClickListener{

    DatabaseOperations databaseOperations;
    list<String> TableData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        databaseOperations = new DatabaseOperations(this);
        TableData = databaseOperations.getFriendList();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,TableData);
        setListAdapter(adapter);
    }
}


        Button bLogout;
    EditText etName, etAge, etUsername,etgander;

    public Button getbLogout() {
        return bLogout;
    }

    public void setbLogout(Button bLogout) {
        this.bLogout = bLogout;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String[] list ={""};

        ArrayAdapter<String> Adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);
        setListAdapter(adapter);
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
