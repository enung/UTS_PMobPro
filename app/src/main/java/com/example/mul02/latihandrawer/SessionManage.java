package com.example.mul02.latihandrawer;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import java.util.HashMap;

/**
 * Created by R_sap on 27/10/2016.
 */

public class SessionManage {
    SharedPreferences pref;

    SharedPreferences.Editor editor;

    Context _context;

    int PRIVATE_MODE = 0;


    private static final String PREF_NAME = "Belajar Pref";


    private static final String IS_LOGIN = "IsLoggedIn";


    private static final String KEY_NAME = "name";


    private static final String KEY_EMAIL = "email";


    public SessionManage(Context context){
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void createLoginSession(String nama, String email){

        editor.putBoolean(IS_LOGIN, true);


        editor.putString(KEY_NAME, nama);


        editor.putString(KEY_EMAIL, email);

        editor.commit();
    }

    public HashMap<String, String> getUserDetails(){
        HashMap<String, String> user = new HashMap<String, String>();

        user.put(KEY_NAME, pref.getString(KEY_NAME, null));

        user.put(KEY_EMAIL, pref.getString(KEY_EMAIL, null));

        return user;
    }

    public void checkLogin(){

        if(!this.IsLoggedIn()){

            Intent i = new Intent(_context, LoginActiviti.class);

            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);


            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            _context.startActivity(i);
        }
    }

    public boolean isLoggedIn(){
        return pref.getBoolean(IS_LOGIN, false);
    }

    public void logoutUser(){

        editor.clear();
        editor.commit();

        Intent i = new Intent(_context, LoginActiviti.class);

        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);


        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        _context.startActivity(i);
    }

}
