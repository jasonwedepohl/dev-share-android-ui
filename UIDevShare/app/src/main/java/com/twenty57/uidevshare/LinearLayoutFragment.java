package com.twenty57.uidevshare;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class LinearLayoutFragment extends Fragment
{
    public LinearLayoutFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View contentView = inflater.inflate(R.layout.fragment_linear_layout, container, false);

        TextView textView = contentView.findViewById(R.id.textView);

        textView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorAccent));
        textView.setTextColor(ContextCompat.getColor(getContext(), R.color.colorPrimary));

        textView.setText(getString(R.string.text_view));

        int padding = (int)getResources().getDimension(R.dimen.text_view_padding);
        textView.setPadding(padding, padding, padding, padding);

        Spinner spinner = contentView.findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(), R.array.planets_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        return contentView;
    }
}
