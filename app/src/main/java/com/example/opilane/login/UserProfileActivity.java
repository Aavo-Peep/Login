package com.example.opilane.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class UserProfileActivity extends AppCompatActivity {

    TextView profiil_eesnimi, profiil_perenimi, profiil_email;
    FirebaseAuth firebaseAuth;
    FirebaseDatabase firebaseDatabase;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.välja:
                firebaseAuth.signOut();
                finish();
                startActivity(new Intent(this, LoginActivity.class));
                return true;
            case R.id.kasutaja:
                finish();
                startActivity(new Intent(this, UserProfileActivity.class));
                return true;
        }
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_user_profile);
            profiil_eesnimi = findViewById(R.id.profiilEesNimi);
            profiil_perenimi = findViewById(R.id.profiilPereNimi);
            profiil_email = findViewById(R.id.profiilEmail);
            DatabaseReference databaseReference = firebaseDatabase.getReference
                    (firebaseAuth.getCurrentUser().getUid());
            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    Userprofiledata userProfileData = dataSnapshot.getValue(Userprofiledata.class);
                    profiil_eesnimi.setText(userProfileData.getEesNimi());
                    profiil_perenimi.setText(userProfileData.getPereNimi());
                    profiil_email.setText(userProfileData.getEpost());
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(UserProfileActivity.this,databaseError.getCode(),
                            Toast.LENGTH_SHORT).show();

                }
            });


}}
