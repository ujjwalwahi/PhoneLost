package com.phonelost.phonelost;

import android.content.ClipData;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.phonelost.phonelost.model.LostLog;
import com.phonelost.phonelost.model.Pin;

import java.util.List;

/**
 * Created by ujjwal on 5/10/15.
 */
public class LostLogFragment extends Fragment{
    private static final String ARG_SECTION_NUMBER = "section_number";
    ListView logList = null;

    public static LostLogFragment newInstance(int sectionNumber) {
        LostLogFragment fragment = new LostLogFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public LostLogFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_lost_log, container, false);
        logList = (ListView) rootView.findViewById(R.id.log_list);
        List<LostLog> logs = LostLog.listAll(LostLog.class);
        ListAdapter adapter = new ListAdapter(getContext(), R.layout.lost_log_row, logs);
        logList.setAdapter(adapter);
        return rootView;

    }
}

class ListAdapter extends ArrayAdapter<LostLog> {

    public ListAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    public ListAdapter(Context context, int resource, List<LostLog> items) {
        super(context, resource, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.lost_log_row, null);
        }

        LostLog p = getItem(position);

        if (p != null) {
            TextView tt1 = (TextView) v.findViewById(R.id.log_list_date);
            TextView tt2 = (TextView) v.findViewById(R.id.log_list_code);
        }

        return v;
    }

}

