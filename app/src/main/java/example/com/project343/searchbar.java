package example.com.project343;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by isahbellodoro on 9/26/15.
 */
public class searchbar extends ListActivity {



    //ArrayList that will hold the original Data
    ArrayList<HashMap<String, Object>> players;
    LayoutInflater inflater;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        //get the LayoutInflater for inflating the customomView
        //this will be used in the custom adapter
        inflater=(LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //these arrays are just the data that
        //I'll be using to populate the ArrayList
        //You can use our own methods to get the data
        String names[]={"Omar","Theo","Hanna","Bello",
                "Jolly","Wesley","Pj","Sajak"};

        String teams[]={"Male","Male","Female",
                "Female","Male","Male",
                "male","Male"};
        Integer[] photos={R.drawable.omar,R.drawable.theo,
                R.drawable.hanna,R.drawable.bello,
                R.drawable.jolly,R.drawable.wesley,
                R.drawable.pj,R.drawable.sajak};

        players=new ArrayList<HashMap<String,Object>>();

        //temporary HashMap for populating the
        //Items in the ListView
        HashMap<String , Object> temp;

        //total number of rows in the ListView
        int noOfPlayers=names.length;

        //now populate the ArrayList players
        for(int i=0;i<noOfPlayers;i++)
        {
            temp=new HashMap<String, Object>();

            temp.put("name", names[i]);
            temp.put("gender", teams[i]);
            temp.put("photo", photos[i]);

            //add the row to the ArrayList
            players.add(temp);
        }

           /*create the adapter
           *first param-the context
            *second param-the id of the layout file
            you will be using to fill a row
            *third param-the set of values that
            will populate the ListView */
        final CustomAdapter adapter=new CustomAdapter(this,R.layout.player_list,players);

        //finally,set the adapter to the default ListView
        setListAdapter(adapter);


    }


    //define your custom adapter
    private class CustomAdapter extends ArrayAdapter<HashMap<String, Object>>
    {
        // boolean array for storing
        //the state of each CheckBox
        boolean[] checkBoxState;


        ViewHolder viewHolder;

        public CustomAdapter(Context context, int textViewResourceId,
                             ArrayList<HashMap<String, Object>> players) {

            //let android do the initializing :)
            super(context, textViewResourceId, players);

            //create the boolean array with
            //initial state as false
            checkBoxState=new boolean[players.size()];
        }


        //class for caching the views in a row
        private class ViewHolder
        {
            ImageView photo;
            TextView name,gender;
            CheckBox checkBox;
        }


        public CustomAdapter(Context context, int resource, boolean[] checkBoxState) {
            super(context, resource);
            this.checkBoxState = checkBoxState;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {

            if(convertView==null)
            {
                convertView=inflater.inflate(R.layout.player_list, null);
                viewHolder=new ViewHolder();

                //cache the views
                viewHolder.photo=(ImageView) convertView.findViewById(R.id.photo);
                viewHolder.name=(TextView) convertView.findViewById(R.id.name);
                viewHolder.gender=(TextView) convertView.findViewById(R.id.gender);
                viewHolder.checkBox=(CheckBox) convertView.findViewById(R.id.checkBox);

                //link the cached views to the convertview
                convertView.setTag( viewHolder);


            }
            else
                viewHolder=(ViewHolder) convertView.getTag();


            int photoId=(Integer) players.get(position).get("photo");

            //set the data to be displayed
            viewHolder.photo.setImageDrawable(getResources().getDrawable(photoId));
            viewHolder.name.setText(players.get(position).get("name").toString());
            viewHolder.gender.setText(players.get(position).get("gender").toString());

            //VITAL PART!!! Set the state of the
            //CheckBox using the boolean array
            viewHolder.checkBox.setChecked(checkBoxState[position]);


            //for managing the state of the boolean
            //array according to the state of the
            //CheckBox

            viewHolder.checkBox.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {
                    if(((CheckBox)v).isChecked())
                        checkBoxState[position]=true;
                    else
                        checkBoxState[position]=false;

                }
            });

            //return the view to be displayed
            return convertView;
        }

    }
}
