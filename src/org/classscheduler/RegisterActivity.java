package org.classscheduler;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends Activity {
	EditText uid,upass;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		uid = (EditText)findViewById(R.id.uid);
		upass = (EditText)findViewById(R.id.upwd);
		Button btn = (Button)findViewById(R.id.login);
		
		btn.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View arg0) {
				String id = uid.getText().toString();
				String pass = upass.getText().toString();
				SQLiteDatabase db = openOrCreateDatabase("mydata.sqlite",MODE_PRIVATE,null);
				Cursor ref = db.rawQuery("select * from login_class where id ='"+id+"' and password ='"
						+pass+"'", null);
						if(ref.moveToNext()){
							Toast.makeText(RegisterActivity.this, "Already Exists!", Toast.LENGTH_LONG).show();
							
						}
						else{
							db.execSQL("insert into login_class values('"+id+"','"+pass+"')");
							Toast.makeText(RegisterActivity.this, "Registered!", Toast.LENGTH_LONG).show();
						}
						db.close();
			}
		});
	}
}
