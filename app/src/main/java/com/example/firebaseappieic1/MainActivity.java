package com.example.firebaseappieic1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.firebaseappieic1.Modelo.Alumno;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class MainActivity extends AppCompatActivity {
    Button btnRegistrar;
    EditText etNombre, etApellido, etEdad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        llamadoBtnRegistrar();

    }

    private void llamadoBD() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Alumno").child("r1");

        myRef.child("nombre").setValue("Javier");
        myRef.child("apellido").setValue("Villa");
        myRef.child("edad").setValue("18");
    }


    public void llamadoBtnRegistrar(){
        etNombre = (EditText) findViewById(R.id.etNombre);
        etApellido = (EditText) findViewById(R.id.etApellido);
        etEdad = (EditText) findViewById(R.id.etEdad);

        btnRegistrar = (Button) findViewById(R.id.btnRegistrar);
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = etNombre.getText().toString();
                String apellido = etApellido.getText().toString();
                try {
                    int edad = Integer.parseInt(etEdad.getText().toString());
                    String key = UUID.randomUUID().toString();
                    Alumno a = new Alumno(key,nombre,apellido,edad);
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference myRef = database.getReference("Alumno").child(key);
                    myRef.setValue(a);

                    DatabaseReference r1 = database.getReference("Tminima");
                    r1.setValue(edad);

                }catch (Exception e){
                    Toast.makeText(MainActivity.this, "Debe ser un numero", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}










