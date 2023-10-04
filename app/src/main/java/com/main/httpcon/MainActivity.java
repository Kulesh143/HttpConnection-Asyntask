package com.main.httpcon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.main.httpcon.model.Task1;
import com.main.httpcon.model.Task2;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void Button1(View view){
        Thread t=new Thread(new Runnable(){
            @Override
            public void run(){
                final TextView tv1=findViewById(R.id.textView);
                final TextView tv2=findViewById(R.id.textView2);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        tv1.setText("Start");
                    }
                });

//                int i = 0 ;
//                for (i = 1 ; i<= 10 ; i++) {
//                    tv2.post(new Runnable() {
//                        @Override
//                        public void run() {
//                            tv2.setText(String.valueOf(i));
//                        }
//                    });
//                }
            }
        });
        t.start();

    }

    public void Button2(View view){
        Task1 task1 = new Task1(this);
        task1.execute();
    }

    public void Button3(View view){
        Task2 task2 = new Task2(this);
        task2.execute();
    }
}
