package com.example.myapplication.AsyncClasses;

public class Async1 extends BaseClass{
    public Async1(AsyncTaskCompleteListener<Object> cb) {
        super(cb);
    }
    @Override
    protected Object doInBackground(Object[] objects) {
        //Wait for 3 seconds
        for (int count = 0;count<3;count++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        return objects[0];
    }
}
