package com.example.ejercicio15sharepreferences;

import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.PreferenceActivity;



import androidx.annotation.Nullable;

public class ActivityConfiguracion extends PreferenceActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.configuracion);


    }
}
