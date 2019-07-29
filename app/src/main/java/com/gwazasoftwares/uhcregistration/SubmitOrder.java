package com.gwazasoftwares.uhcregistration;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.gwazasoftwares.uhcregistration.models.ShopItem;
import com.gwazasoftwares.uhcregistration.models.UserOrder;

import java.util.Arrays;

public class SubmitOrder extends AppCompatActivity {

    private TextView name,hallOfResidence, room;
    Button submitOrder;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        name = findViewById(R.id.nametxt);
        hallOfResidence = findViewById(R.id.halltxt);
        room = findViewById(R.id.roomtxt);
        submitOrder = findViewById(R.id.submit);

        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Submiting order...");

    }

    @Override
    protected void onStart() {
        super.onStart();

        submitOrder.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitDetails();
            }
        });
    }

    public void submitDetails(){
        progressDialog.show();
        ShopItem shopItem = (ShopItem) getIntent().getSerializableExtra("my_order");
        UserOrder my_order = new UserOrder(name.getText().toString(),hallOfResidence.getText().toString(),room.getText().toString(),shopItem);

        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("nathan").child("m-shop").child("orders");


        myRef.push().setValue(my_order).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()) {
                    progressDialog.dismiss();
                    Toast.makeText(getApplicationContext(), "Order sent successfully please wait for your meal", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(getApplicationContext(),ShopHome.class));
                }else{
                    progressDialog.dismiss();
                    Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });


    }


}
