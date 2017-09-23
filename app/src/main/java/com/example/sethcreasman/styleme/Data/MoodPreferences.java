package com.example.sethcreasman.styleme.Data;

import android.content.Context;

/**
 * Created by sethcreasman on 9/22/17.
 */

public class MoodPreferences {
    //  set to Tracy, CA
    private static final String DEFAULT_WEATHER_LOCATION = "95376,USA";

    public static String getPreferredWeatherLocation(Context context) {
        /** This will be implemented in a future lesson **/
        return getDefaultWeatherLocation();
    }

    private static String getDefaultWeatherLocation() {
        /** This will be implemented in a future lesson **/
        return DEFAULT_WEATHER_LOCATION;
    }

    public static boolean isMetric(Context context) {
        /** This will be implemented in a future lesson **/
        return true;
    }
}
