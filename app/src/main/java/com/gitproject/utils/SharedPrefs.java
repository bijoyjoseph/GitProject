package com.gitproject.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import static android.content.Context.MODE_PRIVATE;

public class SharedPrefs {

    private final SharedPreferences sharedPreferences;
    private Context mContext;

    public SharedPrefs(Context context) {
        mContext = context;
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static void saveSignupCredentials(Context context, String prefName, String username) {
        SharedPreferences.Editor editor = context.getSharedPreferences(prefName, MODE_PRIVATE).edit();
        editor.putString(AppConstants.USER_NAME, username);
        editor.apply();
    }

    public static String fetchPrefString(Context context, String prefName, String key) {
        if (context != null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences(prefName, MODE_PRIVATE);
            return sharedPreferences.getString(key, null);
        }
        return null;
    }


}
