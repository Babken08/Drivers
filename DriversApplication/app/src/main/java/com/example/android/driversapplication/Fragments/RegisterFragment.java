package com.example.android.driversapplication.Fragments;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.driversapplication.Activitys.HomeActivity;
import com.example.android.driversapplication.Models.Driver;
import com.example.android.driversapplication.Models.ShipinngDriverTrucks;
import com.example.android.driversapplication.Models.TaxiDriver;
import com.example.android.driversapplication.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
//
//public class RegisterFragment extends Fragment implements View.OnClickListener {
//
//
//    private DatabaseReference myRefTaxi;
//    private DatabaseReference myRefShipping;
//    private DatabaseReference myRefEvokuator;
//
//    private EditText etName;
//    private EditText etSrName;
//    private EditText etPhone1;
//    private EditText etPhone2;
//    private EditText etPassport;
//    private EditText etAddress;
//    private EditText etAutoPassport;
//    private EditText etAutoNumber;
//    private boolean taxi;
//    private boolean araqum;
//    private boolean evokuator;
//    private boolean shippingTruck;
//    private boolean manipulyator;
//    private boolean filterable;
//    private long phoneeeee1;
//    private long phoneeeee2;
//    private DatabaseReference myRefShippingTruck;
//    private int x;
//    private DatabaseReference myRefManipulyator;
//    private DatabaseReference myRef;
//
//
//    public RegisterFragment() {
//    }
//
//
//    public static RegisterFragment newInstance() {
//        RegisterFragment fragment = new RegisterFragment();
//        return fragment;
//    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        FirebaseDatabase database = FirebaseDatabase.getInstance();
//         myRef = database.getReference().child("drivers");
//        myRefTaxi = myRef.child(getString(R.string.Taxi));
//        myRefShipping = myRef.child("Shipping");
//        myRefShippingTruck = myRef.child("ShippingTruck");
//        myRefEvokuator = myRef.child(getString(R.string.Evokuator));
//        myRefManipulyator = myRef.child("Manipulyator");
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        View v = inflater.inflate(R.layout.fragment_register, container, false);
//        findView(v);
//        return v;
//    }
//
//    private void addDatabase(DatabaseReference myReff, int x) {
//        String name = etName.getText().toString();
//        String srName = etSrName.getText().toString();
//        String phon1 = etPhone1.getText().toString();
//        String phon2 = etPhone2.getText().toString();
//        if (!phon1.isEmpty() && !phon2.isEmpty()) {
//            phoneeeee1 = Long.parseLong(phon1);
//            phoneeeee2 = Long.parseLong(phon2);
//        }
//        String passport = etPassport.getText().toString();
//        String address = etAddress.getText().toString();
//        String autoNumber = etAutoNumber.getText().toString();
//        String autoPassport = etAutoPassport.getText().toString();
//
//        filter(name, srName, phoneeeee1, phoneeeee2, passport, address, autoNumber, autoPassport);
//
//        if (filterable && x == 0) {
//            Driver driver = new Driver(name, srName, phoneeeee1, phoneeeee2, passport, address, autoNumber, autoPassport);
//            myReff.child("users").child(driver.getUid()).setValue(driver);
//        }
//        if (filterable) {
//            if (x == 4 || x == 7) {
//                TaxiDriver taxist = new TaxiDriver(name, srName, phoneeeee1, phoneeeee2, passport, address, autoNumber, autoPassport, x);
//                myReff.child("users").child(taxist.getUid()).setValue(taxist);
//            }
//        }
//        if (filterable) {
//            if (x != 4 && x != 7 && x != 0) {
//                ShipinngDriverTrucks sp = new ShipinngDriverTrucks(name, srName, phoneeeee1, phoneeeee2, passport, address, autoNumber, autoPassport, x);
//                myReff.child("users").child(sp.getUid()).setValue(sp);
//            }
//        }
//    }
//
//
//    private boolean filter(String name, String srName, long phone1, long phone2, String passport, String address, String autoNumber, String autoPassport) {
//
//        filterable = true;
//        if (name.isEmpty()) {
//            Toast.makeText(getContext(), R.string.enter_your_name, Toast.LENGTH_SHORT).show();
//            filterable = false;
//        }
//        if (srName.isEmpty()) {
//            Toast.makeText(getContext(), R.string.enter_your_srName, Toast.LENGTH_SHORT).show();
//            filterable = false;
//        }
//        if (String.valueOf(phone1).length() < 11) {
//            Toast.makeText(getContext(), R.string.invalid_number1, Toast.LENGTH_SHORT).show();
//            filterable = false;
//        }
//        if (String.valueOf(phone2).length() < 11) {
//            Toast.makeText(getContext(), R.string.invalid_number2, Toast.LENGTH_SHORT).show();
//            filterable = false;
//        }
//        if (passport.length() < 9) {
//            Toast.makeText(getContext(), R.string.enter_your_passport, Toast.LENGTH_SHORT).show();
//            filterable = false;
//        }
//        if (address.isEmpty()) {
//            Toast.makeText(getContext(), R.string.enter_your_address, Toast.LENGTH_SHORT).show();
//            filterable = false;
//        }
//        if (autoNumber.length() < 7) {
//            Toast.makeText(getContext(), R.string.enter_your_auto_number, Toast.LENGTH_SHORT).show();
//            filterable = false;
//        }
//        if (autoPassport.length() < 15) {
//            Toast.makeText(getContext(), R.string.enter_your_valid_auto_passport, Toast.LENGTH_SHORT).show();
//            filterable = false;
//        }
//        return filterable;
//    }
//
//
//    private void findView(View v) {
//        etName = (EditText) v.findViewById(R.id.et_name);
//        etSrName = (EditText) v.findViewById(R.id.et_srNmae);
//        etPhone1 = (EditText) v.findViewById(R.id.et_phone1);
//        etPhone2 = (EditText) v.findViewById(R.id.et_phone2);
//        etPassport = (EditText) v.findViewById(R.id.et_passport);
//        etAddress = (EditText) v.findViewById(R.id.et_address);
//        etAutoNumber = (EditText) v.findViewById(R.id.et_auto_num);
//        etAutoPassport = (EditText) v.findViewById(R.id.et_auto_passport);
//        Button btnAccess = (Button) v.findViewById(R.id.btn_register);
//        Button btnShipingTruk = (Button) v.findViewById(R.id.btn_bernatar_araqum);
//        Button btnTaxi = (Button) v.findViewById(R.id.btn_taxi);
//        Button btnArsaqum = (Button) v.findViewById(R.id.btn_araqum);
//        Button btnEvikuator = (Button) v.findViewById(R.id.btn_evokuator);
//        Button btnManipulyator = (Button) v.findViewById(R.id.btn_manipulyator);
//
//        btnAccess.setOnClickListener(this);
//        btnTaxi.setOnClickListener(this);
//        btnArsaqum.setOnClickListener(this);
//        btnEvikuator.setOnClickListener(this);
//        btnShipingTruk.setOnClickListener(this);
//        btnManipulyator.setOnClickListener(this);
//    }
//
//    @Override
//    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.btn_taxi: {
//                dialogTaxi();
//                taxi = true;
//                evokuator = false;
//                shippingTruck = false;
//                manipulyator = false;
//                break;
//            }
//            case R.id.btn_araqum: {
//                araqum = true;
//                evokuator = false;
//                shippingTruck = false;
//                manipulyator = false;
//                break;
//            }
//            case R.id.btn_bernatar_araqum: {
//                dialogShippingTruck();
//                shippingTruck = true;
//                taxi = false;
//                araqum = false;
//                evokuator = false;
//                manipulyator = false;
//                break;
//            }
//            case R.id.btn_evokuator: {
//                evokuator = true;
//                taxi = false;
//                araqum = false;
//                shippingTruck = false;
//                manipulyator = false;
//                break;
//            }
//            case R.id.btn_manipulyator: {
//                manipulyator = true;
//                taxi = false;
//                araqum = false;
//                shippingTruck = false;
//                evokuator = false;
//                break;
//            }
//            case R.id.btn_register: {
//                if (taxi && !araqum) {
//                    addDatabase(myRefTaxi, x);
//                    addFragment();
//                    break;
//                }
//                if (taxi && araqum) {
//                    addDatabase(myRefTaxi, x);
//                    addDatabase(myRefShipping, 0);
//                    addFragment();
//                    break;
//
//                }
//
//                if (araqum && !taxi) {
//                    addDatabase(myRefShipping, 0);
//                    addFragment();
//                    break;
//                }
//
//                if (evokuator) {
//                    addDatabase(myRefEvokuator, 0);
//                    addFragment();
//                    break;
//                }
//                if (shippingTruck) {
//                    addDatabase(myRefShippingTruck, x);
//                    addFragment();
//                    break;
//                }
//                if (manipulyator) {
//                    addDatabase(myRefManipulyator, 0);
//                    addFragment();
//                    break;
//                }
//                break;
//            }
//        }
//    }
//
//
//    private void addFragment() {
//        if (filterable) {
//            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.conto, HomeFragment.newInstance()).commit();
//            Intent i = new Intent(getActivity(), HomeActivity.class);
//            startActivity(i);
//            getActivity().finish();
//        }
//    }
//
//
//    private void dialogTaxi() {
//
//        AlertDialog.Builder mDialogBuilder = new AlertDialog.Builder(getContext());
//        View view = LayoutInflater.from(getContext()).inflate(R.layout.dialogtaxi, null);
//
//        mDialogBuilder.setView(view);
//
//        final TextView ettext = (TextView) view.findViewById(R.id.et_text);
//        final TextView txt4 = (TextView) view.findViewById(R.id.txt4);
//        final TextView txt7 = (TextView) view.findViewById(R.id.tex7);
//        txt4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                ettext.setText("4");
//            }
//        });
//        txt7.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ettext.setText("7");
//            }
//        });
//        mDialogBuilder
//                .setCancelable(false)
//                .setPositiveButton(R.string.ok,
//                        new DialogInterface.OnClickListener() {
//                            public void onClick(DialogInterface dialog, int id) {
//                                String a = ettext.getText().toString();
//                                if (!a.isEmpty()) {
//                                    x = Integer.parseInt(a);
//                                    dialog.dismiss();
//                                } else {
//                                    Toast.makeText(getContext(), R.string.enter_your_car_seats, Toast.LENGTH_SHORT).show();
//                                }
//
//
//                            }
//                        })
//                .setNegativeButton(R.string.cansel,
//                        new DialogInterface.OnClickListener() {
//                            public void onClick(DialogInterface dialog, int id) {
//                                dialog.cancel();
//                            }
//                        });
//        AlertDialog alertDialog = mDialogBuilder.create();
//
//        alertDialog.show();
//
//    }
//
//    private void dialogShippingTruck() {
//        AlertDialog.Builder mDialogBuilder = new AlertDialog.Builder(getContext());
//        View view = LayoutInflater.from(getContext()).inflate(R.layout.dialogshipping, null);
//
//        mDialogBuilder.setView(view);
//
//        final TextView ettext = (TextView) view.findViewById(R.id.et_textdialog);
//        final TextView txt3 = (TextView) view.findViewById(R.id.txt3);
//        final TextView txt6 = (TextView) view.findViewById(R.id.tex6);
//        final TextView txt9 = (TextView) view.findViewById(R.id.tex9);
//        txt3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                ettext.setText("3");
//            }
//        });
//        txt6.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ettext.setText("6");
//            }
//        });
//        txt9.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ettext.setText("9");
//            }
//        });
//        mDialogBuilder
//                .setCancelable(false)
//                .setPositiveButton(R.string.ok,
//                        new DialogInterface.OnClickListener() {
//                            public void onClick(DialogInterface dialog, int id) {
//                                String a = ettext.getText().toString();
//                                if (!a.isEmpty()) {
//                                    x = Integer.parseInt(a);
//                                    dialog.dismiss();
//                                } else {
//                                    Toast.makeText(getContext(), R.string.enter_your_car_truck, Toast.LENGTH_SHORT).show();
//                                }
//
//
//                            }
//                        })
//                .setNegativeButton(R.string.cansel,
//                        new DialogInterface.OnClickListener() {
//                            public void onClick(DialogInterface dialog, int id) {
//                                dialog.cancel();
//                            }
//                        });
//        AlertDialog alertDialog = mDialogBuilder.create();
//
//        alertDialog.show();
//
//    }
//}
