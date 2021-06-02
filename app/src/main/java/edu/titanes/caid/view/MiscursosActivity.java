package edu.titanes.caid.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import edu.titanes.caid.R;

public class MiscursosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_miscursos);

        showToolbar(getResources().getString(R.string.mis_cursos), true);
    }

    public void showToolbar(String title, boolean UpButton){
        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(UpButton);

    }
}
