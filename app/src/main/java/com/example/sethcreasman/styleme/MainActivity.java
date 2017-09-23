package com.example.sethcreasman.styleme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    public static final String LOG_TAG = "StyleMe-Main";

    //Initialize database object and CLothing API
    public DatabaseReference mDatabase;
    public ClothingDbApi CDBAPI = new ClothingDbApi();


    //    Reference of toast to cancel it if already showing
    private Toast mToast;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDatabase = FirebaseDatabase.getInstance().getReference();

        int i = 0;
        while ( i < 10 ){
            CDBAPI.getClothingItem("shirts", CDBAPI.buttonShirtLong, mDatabase);
            i++;
        }



        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                if (mToast != null) {
                    mToast.cancel();
                }

                mToast = Toast.makeText(MainActivity.this, "" + position,
                        Toast.LENGTH_SHORT);

                mToast.show();
            }
        });


    }
}
