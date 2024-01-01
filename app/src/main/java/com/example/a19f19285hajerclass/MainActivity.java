package com.example.a19f19285hajerclass;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    EditText username,password;
    Button login;
    TextView RegisterText;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    username=findViewById(R.id.username);
    password=findViewById(R.id.passwordte);
    login=findViewById(R.id.loginbuton);
    RegisterText=findViewById(R.id.registervv);


    login.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (!validateUsername() |!validatepasswod()){

            }else {
                checkuser();
            }
        }
    });

    RegisterText.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent=new Intent(MainActivity.this,MainActivity2.class);
            startActivity(intent);
        }
    });
    }



    public  Boolean validateUsername(){
    String val=username.getText().toString();
    if(val.isEmpty()){
        username.setError("User name con not be empty");
        return false;

    }else {
        username.setError(null);
        return true;
    }
    }
    public  Boolean validatepasswod(){
        String val=password.getText().toString();
        if(val.isEmpty()){
            password.setError("password con not be empty");
            return false;

        }else {
            password.setError(null);
            return true;
        }
    }

    public void  checkuser(){
        String userUsername= username.getText().toString().trim();
        String userpassword=password.getText().toString().trim();

        DatabaseReference reference= FirebaseDatabase.getInstance().getReference("users");
        Query checkUserDatabase=reference.orderByChild("username").equalTo(userUsername);

        checkUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    username.setError(null);
                    String passwordfromDB=snapshot.child(userUsername).child("password").getValue(String.class);

                    if(!Objects.equals(passwordfromDB, userpassword)){
                        username.setError(null);
                        Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                        startActivity(intent);

                    }else {
                        password.setError("not correct");
                        password.requestFocus();
                    }
                }else {
                    username.setError("UNAVAILABLE");
                    username.requestFocus();

                }
            }
            {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

        });


    }
}















