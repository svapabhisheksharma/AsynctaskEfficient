package com.example.myapplication.AsyncClasses;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;

public class BackgroundTask<T> extends AsyncTask<T,Void,T> {

    public AsyncTaskCompleteListener<T> callback;

    public BackgroundTask(AsyncTaskCompleteListener<T> cb){
        this.callback = cb;
    }

    @SafeVarargs
    @Override
    protected final T doInBackground(T... ts) {
        //Wait for 3 seconds
        for (int count = 0;count<3;count++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        return ts[0];
    }
    @Override
    protected void onPostExecute(T t) {
        super.onPostExecute(t);
        Log.d("PostExecute","Called Post execute");
        callback.onTaskComplete(t);
    }
}
