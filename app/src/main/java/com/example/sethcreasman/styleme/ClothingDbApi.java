package com.example.sethcreasman.styleme;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.Random;

/**
 * Created by LucasVasquez on 9/22/17.
 */

public class ClothingDbApi {
    private final String LOG__TAG = "ClothingAPI";


    /**
     * The Firebase Database instance needs to be initiated
     *
     * Example:
     *
     * public DatabaseReference mDatabase; ///Create the Object
     * mDatabase = FirebaseDatabase.getInstance().getReference(); ///Initiate the object
     *
     */

    //Shirts
    public String[] buttonShirtShort = new String[]{"0001","0002","0003"};
    public String[] buttonShirtLong = new String[]{"0004","0005","0006"};
    public String[] tShirtShort = new String[]{"0007","0008","0009"};
    public String[] tShirtLong = new String[]{"0010","0011","0012"};

    //Pants
    public String[] pants = new String[]{"1001","1002","1003","1004","1005"};

    //Shorts
    public String[] shorts = new String[]{"2001","2002","2003","2004"};

    //Shoes
    public String[] shoes = new String[]{"3001","3002","3003","3004","3005"};



    /**
     *
     * @param DbRef - Firebase Real-Time Database reference
     * @param category - Clothing category (shirts,shorts,pants, ect)
     * @param index - needs the IDs for the clothing items ex. (0001-0005)
     *
     * This functions randomly selects a clothing item within a certain category
     */
    public void getClothingItem(String category, String[] index, DatabaseReference DbRef) {
        final String[] ids = index;
        Random random = new Random();
        final int randomIndex = random.nextInt((index.length));
        DbRef.child(category).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String name = ((dataSnapshot.child(ids[randomIndex])).child("name").getValue()).toString();
                Log.v(LOG__TAG, name);
                Log.v(LOG__TAG, "passed");

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.v(LOG__TAG, "Retrieval of Data Failed");
                Log.v(LOG__TAG, "failed");
            }

        });
    }

}


