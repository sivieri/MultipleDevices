package me.sivieri.multitpledevices;

import android.app.Fragment;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class SecondaryFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_secondary, container);
	}

	public void setEditText(String text) {
		EditText editText = (EditText) getActivity().findViewById(R.id.editText);
		editText.setText(text);
	}

	public void addTextWatcher(TextWatcher watcher) {
		EditText editText = (EditText) getActivity().findViewById(R.id.editText);
		editText.addTextChangedListener(watcher);
	}

}
