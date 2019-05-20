package com.example.ses_1a;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


public class booking_Time extends AppCompatActivity {


    private EditText editTime, editDonorID, editDate, editCharity;
    private static final String TAG = "BookingActivity";
    private Button button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking__time);
        //Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        addbooking();


    }
        public void addbooking() {


                editDonorID = findViewById(R.id.editText);
                editDate = findViewById(R.id.editText3);
                editTime = findViewById(R.id.editText2);
                editCharity = findViewById(R.id.editText4);
                button = findViewById(R.id.button4);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        Map<String, Object> data = new HashMap<>();

                        data.put("DonorId", editDonorID.getText().toString());
                        data.put("Charity Name", editCharity.getText().toString());
                        data.put("Date", editDate.getText().toString());
                        data.put("Time", editTime.getText().toString());


                        FirebaseFirestore db = FirebaseFirestore.getInstance();
                        db.collection("bookings")
                                .add(data)
                                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                    @Override
                                    public void onSuccess(DocumentReference documentReference) {
                                        Log.d(TAG, "DocumentSnapshot written with ID: " + documentReference.getId());
                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Log.w(TAG, "Error adding document", e);
                                    }

                                });


                    }
                });


        }
    }






