package org.classscheduler;

import android.app.Activity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class ClassActivity extends Activity {
	TextView tv;	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_class);
		
		Spinner batch = (Spinner)findViewById(R.id.spinner);
		tv = (TextView)findViewById(R.id.textv);
		
		String batches[]={"Choose Batch","JAVA","ANDROID","PYTHON"};		
		ArrayAdapter<String> data = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,batches);
		batch.setAdapter(data);		
		batch.setOnItemSelectedListener(new OnItemSelectedListener() {
			Cursor ref;
			SQLiteDatabase db = openOrCreateDatabase("mydata.sqlite", MODE_PRIVATE, null);
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				String batc = (String)arg0.getItemAtPosition(arg2);
				
				if(batc.equalsIgnoreCase("java")){
					tv.setText("");
					ref = db.rawQuery("select * from student_info where batch_number = 1",null);
					while(ref.moveToNext()){
					tv.append(ref.getString(1)+"\n");
					}
				}
				else if (batc.equalsIgnoreCase("android")){
					tv.setText("");
					ref = db.rawQuery("select * from student_info where batch_number = 2",null);
					while(ref.moveToNext()){
					tv.append(ref.getString(1)+"\n");
					}
				}
				else if (batc.equalsIgnoreCase("python")) {
					tv.setText("");
					ref = db.rawQuery("select * from student_info where batch_number = 3",null);
					while(ref.moveToNext()){
					tv.append(ref.getString(1)+"\n");
					}
				}
				else if(batc.equalsIgnoreCase("choose branch")){
					tv.setText("");
				}
				}
			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				tv.setText("");				
			}				
		});
		
	}
}