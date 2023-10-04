package com.main.httpcon.model;

import android.app.Activity;
import android.os.AsyncTask;
import android.widget.TextView;

import com.main.httpcon.R;

public class Task1 extends AsyncTask {
    Activity activity ;
    int i = 1 ;

    public Task1(Activity activity){
        this.activity = activity ;
    }

    @Override
    protected void onPreExecute() {
        TextView tv1 = activity.findViewById(R.id.textView);
        tv1.setText("Start");
    }

    @Override
    protected Object doInBackground(Object[] objects) {
        for (i = 1; i<=10 ; i++){
            try{
                publishProgress();
                Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Object[] values) {
        TextView tv2 = activity.findViewById(R.id.textView2);
        tv2.setText(String.valueOf(i));
    }

    @Override
    protected void onPostExecute(Object o) {
        TextView tv1 = activity.findViewById(R.id.textView);
        tv1.setText("End");
    }
}
