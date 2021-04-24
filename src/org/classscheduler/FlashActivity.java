package org.classscheduler;

import java.io.File;
import java.util.Timer;

import java.util.TimerTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;

public class FlashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash);
        SQLiteDatabase db = openOrCreateDatabase("mydata.sqlite",MODE_PRIVATE,null);
        File file = getApplicationContext().getDatabasePath("mydata.sqlite");
        if(!file.exists()){
        db.execSQL("create table login_class (id varchar(15)primary key,password varchar(30))");        
        db.execSQL("create table students (batch_number varchar primary key,name varchar(30), contact int(10))");
        db.execSQL("insert into login_class values('milind', 'abc')");        
        db.execSQL("create table student_info (batch_number varchar ,name varchar(30), contact int(10))");
        db.execSQL("insert into student_info values('1','Milind Phalke',9827452257)");
        db.execSQL("insert into student_info values('1','Aman Jain',9827434257)");
        db.execSQL("insert into student_info values('1','Nishit Neema',9823452257)");
        db.execSQL("insert into student_info values('2','Hitesh Gulwani',8927452257)");
        db.execSQL("insert into student_info values('2','Sanskar Jain',9811452257)");
        db.execSQL("insert into student_info values('3','Dhariya Jain',9234752257)");
        db.execSQL("insert into student_info values('3','Prasann Jaiswal',9743452257)");
        }
        
        db.close();
        
        TimerTask tt = new TimerTask() {			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				startActivity(new Intent(FlashActivity.this,LoginActivity.class));
			}
		};
		
		Timer timer = new Timer();
		timer.schedule(tt, 2000);
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.flash, menu);
        return true;
    }
    
}
