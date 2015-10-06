package com.phonelost.phonelost;

/**
 * Created by ujjwal on 5/10/15.
 */

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.phonelost.phonelost.model.Pin;

/**
 * A placeholder fragment containing a simple view.
 */
public class SetPinFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    private TextView existingPin = null;
    private EditText pinText = null;
    private Button set;

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static SetPinFragment newInstance(int sectionNumber) {
        SetPinFragment fragment = new SetPinFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public SetPinFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_set_pin, container, false);
        // initailize
        set = (Button) rootView.findViewById(R.id.set_pin);
        pinText = (EditText) rootView.findViewById(R.id.pin);
        existingPin = (TextView) rootView.findViewById(R.id.existing_pin);
        try {
            Pin pin = Pin.listAll(Pin.class).get(0);
            this.showPin(pin.getPincode());
        } catch (Exception ex) {
            // nothing to log
        }
        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String pincode = pinText.getText().toString().trim();
                long count = Pin.listAll(Pin.class).size();
                if(count < 1) {
                    Pin pin = new Pin(pincode);
                    pin.save();
                    Toast toast = Toast.makeText(getActivity().getApplicationContext(), "Insert", Toast.LENGTH_LONG);
                    toast.show();
                } else {
                    Pin pin = Pin.listAll(Pin.class).get(0);
                    pin.setPincode(pincode);
                    pin.save();
                    Toast toast = Toast.makeText(getActivity().getApplicationContext(), "Update", Toast.LENGTH_LONG);
                    toast.show();
                }
                Pin pin = Pin.listAll(Pin.class).get(0);
                String toastMsg = "Your new pin is " + pin.getPincode();
                Toast toast = Toast.makeText(getActivity().getApplicationContext(), toastMsg, Toast.LENGTH_LONG);
                toast.show();
                pinText.setText("");
                showPin(pin.getPincode());
            }
        });
        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((MainActivity) activity).onSectionAttached(
                getArguments().getInt(ARG_SECTION_NUMBER));
    }

    public void showPin(String pincode) {
        existingPin.setText(pincode);
    }
}