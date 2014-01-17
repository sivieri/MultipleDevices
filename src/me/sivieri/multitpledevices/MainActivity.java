package me.sivieri.multitpledevices;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends FragmentActivity {

	public static final String CONTENT = "content";

	private static final int EDIT_INTENT = 100;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	protected void onStart() {
		super.onStart();
		Button button = (Button) findViewById(R.id.editButton);
		final TextView textView = (TextView) findViewById(R.id.textView);
		if (button != null) {
			// we are on a single view
			button.setOnClickListener(new Button.OnClickListener() {

				@Override
				public void onClick(View arg0) {
					Intent intent = new Intent(MainActivity.this, SecondaryActivity.class);
					intent.putExtra(CONTENT, textView.getText().toString());
					startActivityForResult(intent, EDIT_INTENT);
				}

			});
		}
		final MainFragment mainFragment = (MainFragment) getFragmentManager().findFragmentById(R.id.mainfragment);
		SecondaryFragment secondaryFragment = (SecondaryFragment) getFragmentManager().findFragmentById(R.id.secondaryfragment);
		if (secondaryFragment != null) {
			secondaryFragment.addTextWatcher(new TextWatcher() {

				@Override
				public void afterTextChanged(Editable arg0) {
					mainFragment.setViewText(arg0.toString());
				}

				@Override
				public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
					// not used
				}

				@Override
				public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
					// not used
				}

			});
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == EDIT_INTENT && resultCode == Activity.RESULT_OK && data != null) {
			String content = data.getExtras().getString(CONTENT);
			MainFragment mainFragment = (MainFragment) getFragmentManager().findFragmentById(R.id.mainfragment);
			mainFragment.setViewText(content);
		}
	}

}
