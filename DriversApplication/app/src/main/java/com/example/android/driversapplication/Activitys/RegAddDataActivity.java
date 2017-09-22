package com.example.android.driversapplication.Activitys;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.driversapplication.Models.Driver;
import com.example.android.driversapplication.Models.ShipinngDriverTrucks;
import com.example.android.driversapplication.Models.TaxiDriver;
import com.example.android.driversapplication.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegAddDataActivity extends AppCompatActivity implements View.OnClickListener {
    private DatabaseReference myRefTaxi;
    private DatabaseReference myRefShipping;
    private DatabaseReference myRefEvokuator;
    private FirebaseAuth mAuth;

    public static DatabaseReference goRef;

    private EditText etName;
    private EditText etSrName;
    private EditText etPhone1;
    private EditText etPhone2;
    private EditText etPassport;
    private EditText etAddress;
    private EditText etAutoPassport;
    private EditText etAutoNumber;
    private boolean taxi;
    private boolean araqum;
    private boolean evokuator;
    private boolean shippingTruck;
    private boolean manipulyator;
    private boolean filterable;
    private long phoneeeee1;
    private long phoneeeee2;
    private DatabaseReference myRefShippingTruck;
    private int x;
    private DatabaseReference myRefManipulyator;
    private Button btnManipulyator;
    private Button btnShipingTruk;
    private Button btnEvikuator;
    private Button btnArsaqum;
    private Button btnTaxi;
    private FirebaseUser user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_add_data);




        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference().child("drivers");
        mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();

        myRefTaxi = myRef.child(getString(R.string.Taxi));
        myRefShipping = myRef.child("Shipping");
        myRefShippingTruck = myRef.child("ShippingTruck");
        myRefEvokuator = myRef.child(getString(R.string.Evokuator));
        myRefManipulyator = myRef.child("Manipulyator");

        findView();
    }

    private void findView() {
        etName = (EditText) findViewById(R.id.et_name);
        etSrName = (EditText) findViewById(R.id.et_srNmae);
        etPhone1 = (EditText) findViewById(R.id.et_phone1);
        etPhone2 = (EditText) findViewById(R.id.et_phone2);
        etPassport = (EditText) findViewById(R.id.et_passport);
        etAddress = (EditText) findViewById(R.id.et_address);
        etAutoNumber = (EditText) findViewById(R.id.et_auto_num);
        etAutoPassport = (EditText) findViewById(R.id.et_auto_passport);
        Button btnAccess = (Button) findViewById(R.id.btn_register);
        btnShipingTruk = (Button) findViewById(R.id.btn_bernatar_araqum);
        btnTaxi = (Button) findViewById(R.id.btn_taxi);
        btnArsaqum = (Button) findViewById(R.id.btn_araqum);
        btnEvikuator = (Button) findViewById(R.id.btn_evokuator);
        btnManipulyator = (Button) findViewById(R.id.btn_manipulyator);

        btnAccess.setOnClickListener(this);
        btnTaxi.setOnClickListener(this);
        btnArsaqum.setOnClickListener(this);
        btnEvikuator.setOnClickListener(this);
        btnShipingTruk.setOnClickListener(this);
        btnManipulyator.setOnClickListener(this);
    }
    private void addDatabase(DatabaseReference myReff, int x) {
        String name = etName.getText().toString();
        String srName = etSrName.getText().toString();
        String phon1 = etPhone1.getText().toString();
        String phon2 = etPhone2.getText().toString();
        if (!phon1.isEmpty() && !phon2.isEmpty()) {
            phoneeeee1 = Long.parseLong(phon1);
            phoneeeee2 = Long.parseLong(phon2);
        }
        String passport = etPassport.getText().toString();
        String address = etAddress.getText().toString();
        String autoNumber = etAutoNumber.getText().toString();
        String autoPassport = etAutoPassport.getText().toString();

        filter(name, srName, phoneeeee1, phoneeeee2, passport, address, autoNumber, autoPassport);

        if (filterable && x == 0) {

            Driver driver = new Driver(name, srName, phoneeeee1, phoneeeee2, passport, address, autoNumber, autoPassport);
            driver.setUid(user.getUid());
            myReff.child(driver.getUid()).setValue(driver);
        }
        if (filterable) {
            if (x == 4 || x == 7) {
                TaxiDriver taxist = new TaxiDriver(name, srName, phoneeeee1, phoneeeee2, passport, address, autoNumber, autoPassport, x);
                taxist.setUid(user.getUid());

                if(x == 4) {
                    myReff.child("seats4").child(taxist.getUid()).setValue(taxist);
                } else if(x == 7) {
                    myReff.child("seats7").child(taxist.getUid()).setValue(taxist);
                }

            }
        }
        if(filterable) {
            if(x != 4 && x != 7 && x != 0) {
                ShipinngDriverTrucks sp = new ShipinngDriverTrucks(name, srName, phoneeeee1, phoneeeee2, passport, address, autoNumber, autoPassport, x);
                sp.setUid(user.getUid());
                if(x == 3){
                    myReff.child("truck3").child(sp.getUid()).setValue(sp);
                }else if(x == 6) {
                    myReff.child("truck6").child(sp.getUid()).setValue(sp);

                }else if(x == 9) {
                    myReff.child("truck9").child(sp.getUid()).setValue(sp);

                }

            }
        }
    }

    private boolean filter(String name, String srName, long phone1, long phone2, String passport, String address, String autoNumber, String autoPassport) {

        filterable = true;
        if (name.isEmpty()) {
            Toast.makeText(this, R.string.enter_your_name, Toast.LENGTH_SHORT).show();
            filterable = false;
        }
        if (srName.isEmpty()) {
            Toast.makeText(this, R.string.enter_your_srName, Toast.LENGTH_SHORT).show();
            filterable = false;
        }
        if (String.valueOf(phone1).length() < 11) {
            Toast.makeText(this, R.string.invalid_number1, Toast.LENGTH_SHORT).show();
            filterable = false;
        }
        if (String.valueOf(phone2).length() < 11) {
            Toast.makeText(this, R.string.invalid_number2, Toast.LENGTH_SHORT).show();
            filterable = false;
        }
        if (passport.length() < 9) {
            Toast.makeText(this, R.string.enter_your_passport, Toast.LENGTH_SHORT).show();
            filterable = false;
        }
        if (address.isEmpty()) {
            Toast.makeText(this, R.string.enter_your_address, Toast.LENGTH_SHORT).show();
            filterable = false;
        }
        if (autoNumber.length() < 7) {
            Toast.makeText(this, R.string.enter_your_auto_number, Toast.LENGTH_SHORT).show();
            filterable = false;
        }
        if (autoPassport.length() < 15) {
            Toast.makeText(this, R.string.enter_your_valid_auto_passport, Toast.LENGTH_SHORT).show();
            filterable = false;
        }
        return filterable;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_taxi: {
                btnTaxi.setBackgroundResource(R.color.colorGreen);
                btnEvikuator.setBackgroundResource(R.color.colorTXAVARI);
                btnShipingTruk.setBackgroundResource(R.color.colorTXAVARI);
                btnManipulyator.setBackgroundResource(R.color.colorTXAVARI);
                dialogTaxi();
                taxi = true;
                evokuator = false;
                shippingTruck = false;
                manipulyator = false;
                break;
            }
            case R.id.btn_araqum: {
                btnArsaqum.setBackgroundResource(R.color.colorGreen);
                btnEvikuator.setBackgroundResource(R.color.colorTXAVARI);
                btnShipingTruk.setBackgroundResource(R.color.colorTXAVARI);
                btnManipulyator.setBackgroundResource(R.color.colorTXAVARI);
                araqum = true;
                evokuator = false;
                shippingTruck = false;
                manipulyator = false;
                break;
            }
            case R.id.btn_bernatar_araqum: {
                btnShipingTruk.setBackgroundResource(R.color.colorGreen);
                btnManipulyator.setBackgroundResource(R.color.colorTXAVARI);
                btnEvikuator.setBackgroundResource(R.color.colorTXAVARI);
                btnTaxi.setBackgroundResource(R.color.colorTXAVARI);
                btnArsaqum.setBackgroundResource(R.color.colorTXAVARI);
                dialogShippingTruck();
                shippingTruck = true;
                taxi = false;
                araqum = false;
                evokuator = false;
                manipulyator = false;
                break;
            }
            case R.id.btn_evokuator: {
                btnEvikuator.setBackgroundResource(R.color.colorGreen);
                btnShipingTruk.setBackgroundResource(R.color.colorTXAVARI);
                btnManipulyator.setBackgroundResource(R.color.colorTXAVARI);
                btnTaxi.setBackgroundResource(R.color.colorTXAVARI);
                btnArsaqum.setBackgroundResource(R.color.colorTXAVARI);
                evokuator = true;
                taxi = false;
                araqum = false;
                shippingTruck = false;
                manipulyator = false;
                break;
            }
            case R.id.btn_manipulyator: {
                btnManipulyator.setBackgroundResource(R.color.colorGreen);
                btnTaxi.setBackgroundResource(R.color.colorTXAVARI);
                btnArsaqum.setBackgroundResource(R.color.colorTXAVARI);
                btnEvikuator.setBackgroundResource(R.color.colorTXAVARI);
                btnShipingTruk.setBackgroundResource(R.color.colorTXAVARI);
                manipulyator = true;
                taxi = false;
                araqum = false;
                shippingTruck = false;
                evokuator = false;
                break;
            }
            case R.id.btn_register: {
                if (taxi && !araqum) {
//                    goRef = myRefTaxi;
                    addDatabase(myRefTaxi, x);
                    goHomeActivity();
                    addShared("Taxi" + x);

                }
                if (taxi && araqum) {
                    addDatabase(myRefTaxi, x);
                    addDatabase(myRefShipping, 0);
                    goHomeActivity();
                    addShared("xxxxx" + x);

                }

                if (araqum && !taxi) {
                    addDatabase(myRefShipping, 0);
                    goHomeActivity();
                    addShared("Shipping");

                }

                if (evokuator) {
                    addDatabase(myRefEvokuator, 0);
                    goHomeActivity();
                    addShared("Evokuator");

                }
                if (shippingTruck) {
                    addDatabase(myRefShippingTruck, x);
                    goHomeActivity();
                    addShared("ShippingTruck" + x);
                }
                if(manipulyator) {
                    addDatabase(myRefManipulyator, 0);
                    goHomeActivity();
                    addShared("Manipulyator");
                }
                break;
            }
        }
    }

    private void goHomeActivity() {

        if (filterable) {
            Intent i = new Intent(this, HomeActivity.class);
//            i.putExtra("esim", aaaaaaa);
            startActivity(i);
            finish();
        }
    }

    private void addShared(String value) {

        SharedPreferences sharedPref = getSharedPreferences("babkenjan", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("babken", value);
        editor.apply();

    }

    private void dialogTaxi() {

        AlertDialog.Builder mDialogBuilder = new AlertDialog.Builder(this);
        View view = LayoutInflater.from(this).inflate(R.layout.dialogtaxi, null);

        mDialogBuilder.setView(view);

        final TextView ettext = (TextView) view.findViewById(R.id.et_text);
        final TextView txt4 = (TextView) view.findViewById(R.id.txt4);
        final TextView txt7 = (TextView) view.findViewById(R.id.tex7);
        txt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ettext.setText("4");
            }
        });
        txt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ettext.setText("7");
            }
        });
        mDialogBuilder
                .setCancelable(false)
                .setPositiveButton(R.string.ok,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                String a = ettext.getText().toString();
                                if(!a.isEmpty()){
                                    x = Integer.parseInt(a);
                                    dialog.dismiss();
                                } else {
                                    Toast.makeText(RegAddDataActivity.this, R.string.enter_your_car_seats, Toast.LENGTH_SHORT).show();
                                }


                            }
                        })
                .setNegativeButton(R.string.cansel,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                dialog.cancel();
                            }
                        });
        AlertDialog alertDialog = mDialogBuilder.create();

        alertDialog.show();

    }

    private void dialogShippingTruck() {
        AlertDialog.Builder mDialogBuilder = new AlertDialog.Builder(this);
        View view = LayoutInflater.from(this).inflate(R.layout.dialogshipping, null);

        mDialogBuilder.setView(view);

        final TextView ettext = (TextView) view.findViewById(R.id.et_textdialog);
        final TextView txt3 = (TextView) view.findViewById(R.id.txt3);
        final TextView txt6 = (TextView) view.findViewById(R.id.tex6);
        final TextView txt9 = (TextView) view.findViewById(R.id.tex9);
        txt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ettext.setText("3");
            }
        });
        txt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ettext.setText("6");
            }
        });
        txt9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ettext.setText("9");
            }
        });
        mDialogBuilder
                .setCancelable(false)
                .setPositiveButton(R.string.ok,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                String a = ettext.getText().toString();
                                if(!a.isEmpty()){
                                    x = Integer.parseInt(a);
                                    dialog.dismiss();
                                } else {
                                    Toast.makeText(RegAddDataActivity.this, R.string.enter_your_car_truck, Toast.LENGTH_SHORT).show();
                                }


                            }
                        })
                .setNegativeButton(R.string.cansel,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                dialog.cancel();
                            }
                        });
        AlertDialog alertDialog = mDialogBuilder.create();

        alertDialog.show();

    }

    @Override
    public void onBackPressed() {
        android.os.Process.killProcess(android.os.Process.myPid());
        finish();
    }
}
