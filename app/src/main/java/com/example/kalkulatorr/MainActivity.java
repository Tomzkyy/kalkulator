package com.example.kalkulatorr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText angka1,angka2;
    RadioButton radTambah,radKurang,radKali,radBagi;
    Button hitung;
    TextView hasilperhitungan;
    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        angka1 = (EditText) findViewById(R.id.a);
        angka2 = (EditText) findViewById(R.id.b);
        radTambah = (RadioButton) findViewById(R.id.tambah);
        radKurang  = (RadioButton) findViewById(R.id.kurang);
        radKali = (RadioButton) findViewById(R.id.kali);
        radBagi = (RadioButton) findViewById(R.id.bagi);
        hitung = (Button) findViewById(R.id.btnHitung);
        hasilperhitungan = (TextView) findViewById(R.id.hasil);
        pref = this.getSharedPreferences(getString(R.string.shared_key), Context.MODE_PRIVATE);

        radTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double bilangan1, bilangan2, hasil;
                bilangan1 = Double.valueOf(angka1.getText().toString().trim());
                bilangan2 = Double.valueOf(angka2.getText().toString().trim());
                hasil = bilangan1 + bilangan2;
                String hasil1 = String.valueOf(hasil);
                hasilperhitungan.setText(hasil1);
                String total = hasilperhitungan.getText().toString();

                pref.edit().putString(getString(R.string.hasil_key), total).apply();
            }
        });

        radKurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double bilangan1, bilangan2, hasil;
                bilangan1 = Double.valueOf(angka1.getText().toString().trim());
                bilangan2 = Double.valueOf(angka2.getText().toString().trim());
                hasil = bilangan1 - bilangan2;
                String hasil1 = String.valueOf(hasil);
                hasilperhitungan.setText(hasil1);
                String total = hasilperhitungan.getText().toString();

                pref.edit().putString(getString(R.string.hasil_key), total).apply();
            }
        });

        radKali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                double bilangan1, bilangan2, hasil;
                bilangan1 = Double.valueOf(angka1.getText().toString().trim());
                bilangan2 = Double.valueOf(angka2.getText().toString().trim());
                hasil = bilangan1 * bilangan2;
                String hasil1 = String.valueOf(hasil);
                hasilperhitungan.setText(hasil1);
                String total = hasilperhitungan.getText().toString();

                pref.edit().putString(getString(R.string.hasil_key), total).apply();
            }
        });

        radBagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                double bilangan1, bilangan2, hasil;
                bilangan1 = Double.valueOf(angka1.getText().toString().trim());
                bilangan2 = Double.valueOf(angka2.getText().toString().trim());
                hasil = bilangan1 / bilangan2;
                String hasil1 = String.valueOf(hasil);
                hasilperhitungan.setText(hasil1);
                String total = hasilperhitungan.getText().toString();

                pref.edit().putString(getString(R.string.hasil_key), total).apply();
            }
        });
    }
    public void hasil(View view){
        String total = hasilperhitungan.getText().toString();

        pref.edit().putString(getString(R.string.hasil_key), total).apply();
    }
}