package me.sivieri.multitpledevices;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondaryActivity extends FragmentActivity {

	private String content = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_secondary);
		Intent intent = getIntent();
		Bundle extras = intent.getExtras();
		if (extras != null && extras.getString(MainActivity.CONTENT) != null) {
			this.content = extras.getString(MainActivity.CONTENT);
		}
		Button button = (Button) findViewById(R.id.saveButton);
		final EditText editText = (EditText) findViewById(R.id.editText);
		button.setOnClickListener(new Button.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent();
				intent.putExtra(MainActivity.CONTENT, editText.getText().toString());
				setResult(Activity.RESULT_OK, intent);
				finish();
			}

		});
	}

	@Override
	protected void onStart() {
		super.onStart();
		if (this.content != null) {
			EditText editText = (EditText) findViewById(R.id.editText);
			editText.setText(this.content);
		}
	}

}
