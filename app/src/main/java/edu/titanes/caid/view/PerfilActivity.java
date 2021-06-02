package edu.titanes.caid.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

import edu.titanes.caid.R;
import edu.titanes.caid.adapter.PictureHomeAdapterRecycleView;
import edu.titanes.caid.model.PictureHouse;
import edu.titanes.caid.view.fragment.NewpostFragment;

public class PerfilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);



    }
    public void gofoto(View view){
        Intent intent = new Intent(this, CamaraActivity.class);
        startActivity(intent);

    }


}
