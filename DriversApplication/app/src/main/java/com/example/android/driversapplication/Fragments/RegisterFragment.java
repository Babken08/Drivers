package com.example.android.driversapplication.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android.driversapplication.Models.Driver;
import com.example.android.driversapplication.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterFragment extends Fragment implements View.OnClickListener {


    private DatabaseReference myRefTaxi;
    private DatabaseReference myRefAraqum;
    private DatabaseReference myRefEvokuator;

    private EditText etName;
    private EditText etSrName;
    private EditText etPhone1;
    private EditText etPhone2;
    private EditText etPassport;
    private EditText etAddress;
    private EditText etAutoPassport;
    private EditText etAutoNumber;
    private Button btnEvikuator;
    private Button btnArsaqum;
    private Button btnTaxi;
    private boolean taxi;
    private boolean araqum;
    private boolean evokuator;
    private boolean filterable;
    private long phoneeeee1;
    private long phoneeeee2;


    public RegisterFragment() {
    }


    public static RegisterFragment newInstance() {
        RegisterFragment fragment = new RegisterFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();
        myRefTaxi = myRef.child(getString(R.string.Taxi));
        myRefAraqum = myRef.child(getString(R.string.Araqum));
        myRefEvokuator = myRef.child(getString(R.string.Evokuator));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_register, container, false);
        findView(v);
        return v;
    }

    private void addDatabase(DatabaseReference myReff) {
        String name = etName.getText().toString();
        String srName = etSrName.getText().toString();
        String phon1 = etPhone1.getText().toString();
        String phon2 = etPhone2.getText().toString();
        if (!phon1.isEmpty() && !phon2.isEmpty()){
            phoneeeee1 = Long.parseLong(phon1);
            phoneeeee2 = Long.parseLong(phon2);
        }
        String passport = etPassport.getText().toString();
        String address = etAddress.getText().toString();
        String autoNumber = etAutoNumber.getText().toString();
        String autoPassport = etAutoPassport.getText().toString();

        filter(name, srName, phoneeeee1, phoneeeee2, passport, address, autoNumber, autoPassport);

        if (filterable) {
            Driver driver = new Driver(name, srName, phoneeeee1, phoneeeee2, passport, address, autoNumber, autoPassport);
            myReff.child("users").child(driver.getUid()).setValue(driver);
        }


    }

    private boolean filter(String name, String srName, long phone1, long phone2, String passport, String address, String autoNumber, String autoPassport) {

        filterable = true;
        if (name.isEmpty()) {
            Toast.makeText(getContext(), R.string.enter_your_name, Toast.LENGTH_SHORT).show();
            filterable = false;
        }
        if (srName.isEmpty()) {
            Toast.makeText(getContext(), R.string.enter_your_srName, Toast.LENGTH_SHORT).show();
            filterable = false;
        }
        if (String.valueOf(phone1).length() < 11) {
            Toast.makeText(getContext(), R.string.invalid_number1, Toast.LENGTH_SHORT).show();
            filterable = false;
        }
        if (String.valueOf(phone2).length() < 11) {
            Toast.makeText(getContext(), R.string.invalid_number2, Toast.LENGTH_SHORT).show();
            filterable = false;
        }
        if (passport.length() < 9) {
            Toast.makeText(getContext(), R.string.enter_your_passport, Toast.LENGTH_SHORT).show();
            filterable = false;
        }
        if (address.isEmpty()) {
            Toast.makeText(getContext(), R.string.enter_your_address, Toast.LENGTH_SHORT).show();
            filterable = false;
        }
        if (autoNumber.length() < 7) {
            Toast.makeText(getContext(), R.string.enter_your_auto_number, Toast.LENGTH_SHORT).show();
            filterable = false;
        }
        if (autoPassport.length() < 15) {
            Toast.makeText(getContext(), R.string.enter_your_valid_auto_passport, Toast.LENGTH_SHORT).show();
            filterable = false;
        }
        return filterable;
    }

    private void findView(View v) {
        etName = (EditText) v.findViewById(R.id.et_name);
        etSrName = (EditText) v.findViewById(R.id.et_srNmae);
        etPhone1 = (EditText) v.findViewById(R.id.et_phone1);
        etPhone2 = (EditText) v.findViewById(R.id.et_phone2);
        etPassport = (EditText) v.findViewById(R.id.et_passport);
        etAddress = (EditText) v.findViewById(R.id.et_address);
        etAutoNumber = (EditText) v.findViewById(R.id.et_auto_num);
        etAutoPassport = (EditText) v.findViewById(R.id.et_auto_passport);
        Button btnAccess = (Button) v.findViewById(R.id.btn_register);
        btnTaxi = (Button) v.findViewById(R.id.btn_taxi);
        btnArsaqum = (Button) v.findViewById(R.id.btn_araqum);
        btnEvikuator = (Button) v.findViewById(R.id.btn_evokuator);

        btnAccess.setOnClickListener(this);
        btnTaxi.setOnClickListener(this);
        btnArsaqum.setOnClickListener(this);
        btnEvikuator.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_taxi: {
                btnTaxi.setBackgroundResource(R.color.colorGreen);
                btnEvikuator.setBackgroundResource(R.color.colorAccent);
                taxi = true;
                evokuator = false;
                break;
            }
            case R.id.btn_araqum: {
                btnArsaqum.setBackgroundResource(R.color.colorGreen);
                btnEvikuator.setBackgroundResource(R.color.colorAccent);
                araqum = true;
                evokuator = false;
                break;
            }
            case R.id.btn_evokuator: {
                btnEvikuator.setBackgroundResource(R.color.colorGreen);
                evokuator = true;
                taxi = false;
                araqum = false;
                btnTaxi.setBackgroundResource(R.color.colorAccent);
                btnArsaqum.setBackgroundResource(R.color.colorAccent);
                break;
            }
            case R.id.btn_register: {
                if (taxi && !araqum && !evokuator) {
                    addDatabase(myRefTaxi);
                    addFragment(HomeFragment.newInstance());

                }
                if (taxi && araqum && !evokuator) {
                    addDatabase(myRefTaxi);
                    addDatabase(myRefAraqum);
                    addFragment(HomeFragment.newInstance());

                }
                if (taxi && araqum && evokuator) {
                    Toast.makeText(getContext(), R.string.toast_choos_3, Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!taxi && araqum && !evokuator) {
                    addDatabase(myRefAraqum);
                    addFragment(HomeFragment.newInstance());

                }
                if (!taxi && araqum && evokuator) {
                    Toast.makeText(getContext(), R.string.toast_choos_evakuator, Toast.LENGTH_SHORT).show();
                    return;
                }
                if (taxi && !araqum && evokuator) {
                    Toast.makeText(getContext(), R.string.toast_choos_evakuator, Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!taxi && !araqum && evokuator) {
                    addDatabase(myRefEvokuator);
                    addFragment(HomeFragment.newInstance());

                }
                if (!taxi && !araqum && !evokuator) {
                    Toast.makeText(getContext(), R.string.toast_no_selected_file, Toast.LENGTH_SHORT).show();
                    return;
                }
                break;
            }
        }
    }

    private void addFragment(Fragment fr) {
        if (filterable) {
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.conto, fr).commit();
        }

    }
}
