package com.gwazasoftwares.uhcregistration;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class ViewCart extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    ProgressDialog progressDialog;
    Button checkout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        recyclerView = findViewById(R.id.rv_regs);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        checkout = findViewById(R.id.checkout_button);

        progressDialog = new ProgressDialog(this);
        progressDialog.setCanceledOnTouchOutside(true);
        progressDialog.setMessage("loading data from server ...");
    }

    @Override
    protected void onStart() {
        super.onStart();

        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), SubmitOrder.class));
            }
        });

//        progressDialog.show();

//        final List<RegData> regDataList = new ArrayList<>();

//        FirebaseDatabase database = FirebaseDatabase.getInstance();
//        DatabaseReference myRef = database.getReference("kioko").child("uhc-registration");
//        myRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                regDataList.clear();
//                for(DataSnapshot my_data : dataSnapshot.getChildren()){
//                    RegData regData = my_data.getValue(RegData.class);
//                    regDataList.add(regData);
//                }
//            }
//
//
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//                Toast.makeText(getApplicationContext(),databaseError.getMessage(), Toast.LENGTH_LONG).show();
//            }
//        });

//        adapter = new RegDataAdapter(regDataList);
//        recyclerView.setAdapter(adapter);
        //progressDialog.dismiss();

    }
}
