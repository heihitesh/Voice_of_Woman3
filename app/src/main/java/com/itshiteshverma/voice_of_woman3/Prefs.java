package com.itshiteshverma.voice_of_woman3;

import android.os.Bundle;
import android.preference.PreferenceActivity;

/**
 * Created by Hitesh Verma on 6/5/2015.
 *///we Extends from Preference because it is a Preference
public class Prefs extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.pref);

    }
}
