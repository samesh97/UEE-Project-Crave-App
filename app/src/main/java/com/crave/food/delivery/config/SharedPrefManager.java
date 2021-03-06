package com.crave.food.delivery.config;

import android.content.Context;
import android.content.SharedPreferences;

import com.crave.food.delivery.models.User;

public class SharedPrefManager
{
    private static final String SHARED_PREF_NAME = "com.crave.food.delivery";
    private static final String USER_NAME = "userName";
    private static final String PASSWORD = "password";
    private static final String EMAIL = "email";
    private static final String IMAGE = "image";
    private static final String IS_LOGGED_IN = "is_loggedIn";

    public static void setUser(Context context, User user,boolean isLoggedIn)
    {
        SharedPreferences preferences = context.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        //
        editor.putString(USER_NAME,user.getUserName());
        editor.putString(PASSWORD,user.getPassword());
        editor.putString(EMAIL,user.getEmail());
        editor.putString(IMAGE,user.getImage());
        editor.putBoolean(IS_LOGGED_IN,isLoggedIn);
        editor.apply();
    }
    public static User getUser(Context context)
    {
        SharedPreferences preferences = context.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        User user = new User();
        user.setUserName(preferences.getString(USER_NAME,null));
        user.setEmail(preferences.getString(EMAIL,null));
        user.setPassword(preferences.getString(PASSWORD,null));
        user.setImage(preferences.getString(IMAGE,null));

        return user;
    }
    public static boolean isLoggedIn(Context context)
    {
        SharedPreferences preferences = context.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        return preferences.getBoolean(IS_LOGGED_IN,false);

    }
    public static void setUserLoggedIn(Context context,boolean isTrue)
    {
        SharedPreferences preferences = context.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(IS_LOGGED_IN,isTrue);
        editor.apply();
    }
}
