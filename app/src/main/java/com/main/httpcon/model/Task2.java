package com.main.httpcon.model;

import android.app.Activity;
import android.os.AsyncTask;
import android.widget.TextView;

import com.main.httpcon.R;

public class Task2 extends AsyncTask<Integer,Integer,Integer> {

    Activity activity ;
    int i ;

    public Task2(Activity activity){
        this.activity = activity ;
    }

    @Override
    protected void onPreExecute() {
        TextView tv1 = activity.findViewById(R.id.textView);
        tv1.setText("Start");
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        TextView tv2 = activity.findViewById(R.id.textView2);
        tv2.setText(String.valueOf(values[0]));
    }

    @Override
    protected Integer doInBackground(Integer[] objects) {
        for (i = 1; i<= objects[0] ; i++){
            try{
                publishProgress(objects);
                Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return 10;
    }

    @Override
    protected void onPostExecute(Integer o) {
        TextView tv1 = activity.findViewById(R.id.textView);
        tv1.setText("End="+o);
    }
}
