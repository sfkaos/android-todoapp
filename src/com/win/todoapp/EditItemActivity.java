package com.win.todoapp;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

public class EditItemActivity extends Activity {
	private EditText etEditItem;
	private int position;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit_item);
		etEditItem = (EditText) findViewById(R.id.etUpdateItem);
		
		String editText = getIntent().getStringExtra("editText");
		position = getIntent().getIntExtra("position", 0);
		
		etEditItem.setText(editText);
		etEditItem.setSelection(etEditItem.getText().length());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.edit_item, menu);
		return true;
	}
	
	public void onUpdatedItem(View v) {
		Intent data = new Intent();
		
		data.putExtra("editText",  etEditItem.getText().toString());
		data.putExtra("position", position);
		setResult(RESULT_OK, data);
		
		finish();
	}

}
