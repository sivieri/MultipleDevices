package me.sivieri.multitpledevices;

import android.app.Fragment;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_main, container);
	}

	public void setViewText(String text) {
		TextView textView = (TextView) getActivity().findViewById(R.id.textView);
		textView.setText(Html.fromHtml(text));
	}

}
