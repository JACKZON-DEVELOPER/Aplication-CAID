package edu.titanes.caid.view;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import edu.titanes.caid.LoginActivity;
import edu.titanes.caid.R;

public class CrearusuarioActivity extends AppCompatActivity {
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crearusuario);
        showToolbar(getResources().getString(R.string.crear_cuenta), true);


        firebaseAuth = FirebaseAuth.getInstance();
        final TextInputEditText texEmail = (TextInputEditText) findViewById(R.id.inpt_meil_crearUser);
        final TextInputEditText texPass = (TextInputEditText) findViewById(R.id.inpt_password_crearUser);
        final TextInputEditText texconfPass = (TextInputEditText) findViewById(R.id.inpt_confirPass_crearUser);
        final TextInputEditText texNombre = (TextInputEditText) findViewById(R.id.inpt_name_crearUser);
        final TextInputEditText texUser = (TextInputEditText) findViewById(R.id.inpt_user_crearUser);

        Button btnCrearUser = (Button) findViewById(R.id.butt_registrate_crearUser);
        btnCrearUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = texEmail.getText().toString().trim();
                String user = texUser.getText().toString().trim();
                String nombre = texNombre.getText().toString().trim();
                String passwor = texPass.getText().toString().trim();
                String confir = texconfPass.getText().toString().trim();

                if (email.equals("")){
                    Toast.makeText(getApplicationContext(), "ingresa un correo", Toast.LENGTH_SHORT).show();
                }

                if (!passwor.equals(confir)){

                    if (passwor.equals("")){
                        Toast.makeText(getApplicationContext(), "contraseña innvalida", Toast.LENGTH_SHORT).show();

                    }
                    return;
                }
                firebaseAuth.createUserWithEmailAndPassword(email, passwor)
                        .addOnCompleteListener(CrearusuarioActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (!task.isSuccessful()){

                                    Toast.makeText(CrearusuarioActivity.this, "fallido", Toast.LENGTH_SHORT).show();

                                }else {

                                    startActivity(new Intent(CrearusuarioActivity.this, LoginActivity.class));
                                    finish();

                                }
                            }
                        });

            }
        });

    }

    public void showToolbar(String title, boolean UpButton){
        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(UpButton);

    }
}
