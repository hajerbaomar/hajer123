package com.example.a19f19285hajerclass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.ktx.Firebase;

public class MainActivity2 extends AppCompatActivity {
    EditText username,password,enteremail,conformpassword;
    TextView loginRedirectText;
    Button Register;
    FirebaseDatabase database;
    DatabaseReference reference;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        username=findViewById(R.id.username);
        password=findViewById(R.id.passwordyy);
        enteremail=findViewById(R.id.Enteremail);
        conformpassword=findViewById(R.id.Conformpassword);
        Register=(Button) findViewById(R.id.Registerbtu);


        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                database = FirebaseDatabase.getInstance();
                reference =database.getReference("users");

                String n1= username.getText().toString();
                String n2= enteremail.getText().toString();
                String n3=conformpassword.getText().toString();
                String n4=password.getText().toString();

                Helperclass helperclass =new Helperclass(n1,n2,n3,n4);
                reference.child(n1).setValue(helperclass);

                Toast.makeText(MainActivity2.this,"you have register successfully",Toast.LENGTH_SHORT).show();
                Intent intent =new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);

            }
        });
        loginRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);
            }
        });



    }
}





