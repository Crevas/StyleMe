package com.example.sethcreasman.styleme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.sethcreasman.styleme.Adapters.ImageAdapter;

public class MainActivity extends AppCompatActivity {

    //    Reference of toast to cancel it if already showing
    private Toast mToast;

    ;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


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
