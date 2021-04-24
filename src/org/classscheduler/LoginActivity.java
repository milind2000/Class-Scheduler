 package org.classscheduler;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {
		EditText uid,upass;
	@Override
		protected void onCreate(android.os.Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_login);
			
			SQLiteDatabase db = openOrCreateDatabase("mydata.sqlite",MODE_PRIVATE,null);
			uid = (EditText)findViewById(R.id.userId);
			upass = (EditText)findViewById(R.id.pwd);
			Button btn = (Button)findViewById(R.id.loginButton);	
			Button btn1 = (Button)findViewById(R.id.regButton);
			btn.setOnClickListener(	new android.view.View.OnClickListener() {			
				@Override
				public void onClick(View arg0) {				
					String id= uid.getText().toString();
					String password = upass.getText().toString();		
					SQLiteDatabase db = openOrCreateDatabase("mydata.sqlite",MODE_PRIVATE,null);		
					Cursor ref = db.rawQuery("select * from login_class where id ='"+id+"' and password ='"
					+password+"'", null);
					if(ref.moveToNext()){
						Toast.makeText(LoginActivity.this, "Welcome Teacher!", Toast.LENGTH_LONG).show();
						startActivity(new Intent(LoginActivity.this,IndexActivity.class));
					}
					else{
						Toast.makeText(LoginActivity.this, "Invalid Credentials!", Toast.LENGTH_LONG).show();
					}
					db.close();
				}
		});
			
			btn1.setOnClickListener(new android.view.View.OnClickListener() {
				public void onClick(View arg0) {
					startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
				};				
				});
}
}
