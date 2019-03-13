package com.greatroid.greatroid;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

public class home extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText ak1, ak2, akhir;
    ImageButton bth, bts;
    Spinner spin;
    String[] math={"Pilih Operator","+","-","*","/","^","MOD","DIV"};
    String piloperator;
    double oke1, oke2, mantap;

    private View.OnClickListener bersih = new View.OnClickListener() {
        public void onClick(View view) {
            ak1.setText("");
            ak2.setText("");
            akhir.setText("");
        }
    };

    private View.OnClickListener myClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            oke1=Double.parseDouble(ak1.getText().toString());
            oke2=Double.parseDouble(ak2.getText().toString());
            if (piloperator==""){mantap=oke1+oke2; akhir.setText(Double.toString(mantap));}
            else if (piloperator=="-"){mantap=oke1-oke2; akhir.setText(Double.toString(mantap));}
            else if (piloperator=="*"){mantap=oke1*oke2; akhir.setText(Double.toString(mantap));}
            else if (piloperator=="/"){mantap=oke1/oke2; akhir.setText(Double.toString(mantap));}
            else if (piloperator=="^"){mantap=Math.pow(oke1,oke2); akhir.setText(Double.toString(mantap));}
            else if (piloperator=="MOD"){mantap=oke1%oke2; akhir.setText(Double.toString(mantap));}
            else if (piloperator=="DIV"){mantap=oke1/oke2; akhir.setText(Double.toString(mantap));}
            else {akhir.setText("Pilih Operator Untuk Penjumlahan");}

        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        akhir = (EditText) findViewById(R.id.akhir);
        bth = (ImageButton) findViewById(R.id.bth);
        bts = (ImageButton) findViewById(R.id.bts);
        bts.setOnClickListener(bersih);
        bth.setOnClickListener(myClickListener);
        ak1 = (EditText)findViewById(R.id.ak1);
        ak2= (EditText)findViewById(R.id.ak2);
        spin = (Spinner)findViewById(R.id.spin);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, math);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);
        spin.setOnItemSelectedListener(this);


    }
    public void onItemSelected (AdapterView<?> p, View v, int position, long id) {
        piloperator=math[position];
        akhir.setText("Silahkan tekan =");
    }
    public void onNothingSelected(AdapterView<?> p) {
        akhir.setText("Mohon Pilih Operatornya");
    }

    @Override
    public void onPointerCaptureChanged(boolean akhirCapture) {

    }
}
