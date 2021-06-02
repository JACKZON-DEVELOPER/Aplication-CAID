package edu.titanes.caid.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import edu.titanes.caid.R;
import edu.titanes.caid.adapter.PictureHomeAdapterRecycleView;
import edu.titanes.caid.model.PictureHouse;

public class BuscarActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar);

        showToolbar(getResources().getString(R.string.bucar), true);

        RecyclerView pictureRecicle = (RecyclerView) findViewById(R.id.picure_recicle);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        pictureRecicle.setLayoutManager(linearLayoutManager);
        PictureHomeAdapterRecycleView pictureHomeAdapterRecycleView = new PictureHomeAdapterRecycleView(otnerIma(), R.layout.tarjeta_cursov, this);

        pictureRecicle.setAdapter(pictureHomeAdapterRecycleView);






    }
    public void showToolbar(String title, boolean UpButton){
        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(UpButton);

    }

    public ArrayList<PictureHouse> otnerIma(){
        ArrayList<PictureHouse> content = new ArrayList<>();
        content.add(new PictureHouse("http://rs696.pbsrc.com/albums/vv322/kyarasu/e2051c3bf5e326297f047b7fx7.jpg~c200","ola", "mama"));
        content.add(new PictureHouse("http://rs696.pbsrc.com/albums/vv322/kyarasu/e2051c3bf5e326297f047b7fx7.jpg~c200","ola", "mama"));
        content.add(new PictureHouse("http://rs696.pbsrc.com/albums/vv322/kyarasu/e2051c3bf5e326297f047b7fx7.jpg~c200","ola", "mama"));
        content.add(new PictureHouse("http://rs696.pbsrc.com/albums/vv322/kyarasu/e2051c3bf5e326297f047b7fx7.jpg~c200","ola", "mama"));

        return content;
    }
}
