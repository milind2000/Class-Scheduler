package org.classscheduler;

import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class IndexActivity extends TabActivity {
	protected void onCreate(android.os.Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_index);
		TabHost tabhost = (TabHost)findViewById(android.R.id.tabhost);
		TabSpec tab1 = tabhost.newTabSpec("Class");
		tab1.setIndicator("Classes");
		tab1.setContent(new Intent(this,ClassActivity.class));
		tabhost.addTab(tab1);
		TabSpec tab2 = tabhost.newTabSpec("StuReg");
		tab2.setIndicator("Register Student");
		tab2.setContent(new Intent(this,StuRegActivity.class));
		tabhost.addTab(tab2);
		TabSpec tab3 = tabhost.newTabSpec("Attendence");
		tab3.setIndicator("Take Attendence");
		tab3.setContent(new Intent(this,AttActivity.class));
		tabhost.addTab(tab3);
	};
}
