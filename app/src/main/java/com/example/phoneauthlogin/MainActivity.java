package com.example.phoneauthlogin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.hbb20.CountryCodePicker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText t1_etMobile;
    Button BTN_GetOTP;
    CountryCodePicker ccp;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize fields
        t1_etMobile = findViewById(R.id.et_phoneNumb);
        BTN_GetOTP = findViewById(R.id.btn_GetOTP);
        ccp = findViewById(R.id.ccp);
        ccp.registerCarrierNumberEditText(t1_etMobile);

        BTN_GetOTP.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String phone = t1_etMobile.getText().toString();

        if(phone.isEmpty()) {
            t1_etMobile.setError("Phone number is required");
            t1_etMobile.requestFocus();
            return;
        }

        if(phone.length() <10 || phone.length()> 15){
            t1_etMobile.setError("Please enter a valid mobile number");
            t1_etMobile.requestFocus();
            return;
        }

        Intent intent = new Intent(MainActivity.this, VerifyPhoneActivity.class);
        intent.putExtra("mobile",ccp.getFullNumberWithPlus().replace(" ",""));
        startActivity(intent);
    }
}