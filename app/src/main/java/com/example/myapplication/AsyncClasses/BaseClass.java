package com.example.myapplication.AsyncClasses;

import android.os.AsyncTask;
import android.util.Log;

public abstract class BaseClass extends AsyncTask{

    public AsyncTaskCompleteListener<Object> callback;

    public BaseClass(AsyncTaskCompleteListener<Object> cb){
        this.callback = cb;
    }

    protected void onPostExecute(Object t) {
        Log.d("PostExecute","Called Post execute");
        callback.onTaskComplete(t);
    }

    protected void onPreExecute(){
        Log.d("On pre Execute called","true");
    }
}