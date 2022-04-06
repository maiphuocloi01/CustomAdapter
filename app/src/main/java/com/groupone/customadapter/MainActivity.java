package com.groupone.customadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.groupone.customadapter.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

    ArrayList<Smartphone> listPhone = new ArrayList<>();
    MyCustomAdapter adapter;
    ActivityMainBinding binding;
    int id = 0;
    int phoneOperation = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        ArrayAdapter<CharSequence> adapterSN = ArrayAdapter.createFromResource(this,
                R.array.phone_type, android.R.layout.simple_spinner_item);
        adapterSN.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.snType.setAdapter(adapterSN);


        adapter = new MyCustomAdapter(this, listPhone);
        binding.rvPhone.setAdapter(adapter);
        binding.btAdd.setOnClickListener(view -> addSmartphone());
    }

    private void addSmartphone() {
        String name = binding.etName.getText().toString();
        String type = binding.etType.getText().toString();
        String price = binding.etPrice.getText().toString();

        binding.snType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(getApplicationContext(), i+"", Toast.LENGTH_SHORT).show();
               phoneOperation = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        if (name.isEmpty() || type.isEmpty() || price.isEmpty()) {
            Toast.makeText(this, "Nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
        } else {
            listPhone.add(new Smartphone(id + 1, name, type, Long.parseLong(price),phoneOperation));
            adapter.notifyDataSetChanged();
        }
    }

}