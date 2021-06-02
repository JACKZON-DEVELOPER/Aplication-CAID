package edu.titanes.caid;

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

import edu.titanes.caid.view.ContenedorActivity;
import edu.titanes.caid.view.CrearusuarioActivity;
import edu.titanes.caid.view.CursoActivity;
import edu.titanes.caid.view.DetallecursoActivity;
import edu.titanes.caid.view.HomeActivity;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        firebaseAuth = FirebaseAuth.getInstance();

        final TextInputEditText temail = (TextInputEditText) findViewById(R.id.input_usuario_login);
        final TextInputEditText tpasswor = (TextInputEditText) findViewById(R.id.input_password_login);

        Button btnlogin = (Button) findViewById(R.id.btn_ingresar_login);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = temail.getText().toString().trim();
                String passwor = tpasswor.getText().toString().trim();


                if(email.equals("")){
                    Toast.makeText(LoginActivity.this, "ingresa un correo", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (passwor.equals("")){
                    Toast.makeText(LoginActivity.this, "ingresa un cotraseña", Toast.LENGTH_SHORT).show();
                    return;
                }

                firebaseAuth.signInWithEmailAndPassword(email, passwor)
                        .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                              if (!task.isSuccessful()){
                                  Toast.makeText(LoginActivity.this, "login fallido", Toast.LENGTH_SHORT).show();

                              } else {

                                  goHome();
                              }
                            }
                        });

            }
        });


    }

    public void goCrearUsuarios(View view){
        Intent intent = new Intent(this, CrearusuarioActivity.class);
        startActivity(intent);
    }

    public void goHome(){
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);

    }

    public void goDettalle(View view){
        Intent intent = new Intent(this, CursoActivity.class);
        startActivity(intent);

    }

    public void goconten(View view){
        Intent intent = new Intent(this, ContenedorActivity.class);
        startActivity(intent);

    }
}
