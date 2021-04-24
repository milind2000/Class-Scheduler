package org.classscheduler;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class StuRegActivity extends Activity {
	EditText batch_number,name,contact;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_stureg);
		batch_number = (EditText)findViewById(R.id.sid);
		name = (EditText)findViewById(R.id.sname);
		contact = (EditText)findViewById(R.id.cnt);
		Button btn1 = (Button)findViewById(R.id.regstu);
		btn1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				String batch = batch_number.getText().toString(),
						names = name.getText().toString(),
						contactn = contact.getText().toString();
				SQLiteDatabase db = openOrCreateDatabase("mydata.sqlite", MODE_PRIVATE,null);
				db.execSQL("insert into student_info values('"+batch+"','"+names+"',"+contactn+")");
				Toast.makeText(StuRegActivity.this, "Students Details Registered",Toast.LENGTH_LONG).show();
				db.close();
			}
		});
	}
}
