package edu.titanes.caid.view;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.design.widget.NavigationView;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Toolbar;

import java.util.ArrayList;

import edu.titanes.caid.R;
import edu.titanes.caid.adapter.PictureHomeAdapterRecycleView;
import edu.titanes.caid.model.PictureHouse;

public class HomeActivity extends AppCompatActivity
            implements NavigationView.OnNavigationItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolar_home);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(getResources().getString(R.string.home));

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.draw_home);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navega_oppen_draw, R.string.navega_close_draw );

        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view_home);
        navigationView.setNavigationItemSelectedListener(this);



        RecyclerView pictureRecicle = (RecyclerView) findViewById(R.id.proome_recicle);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        pictureRecicle.setLayoutManager(linearLayoutManager);
        PictureHomeAdapterRecycleView pictureHomeAdapterRecycleView = new PictureHomeAdapterRecycleView(otnerImala(), R.layout.tarjeta_cursov, this);
        pictureRecicle.setAdapter(pictureHomeAdapterRecycleView);


        RecyclerView pictureRecicledos = (RecyclerView) findViewById(R.id.proomedose_recicle);
        LinearLayoutManager linearLayoutManagerdos = new LinearLayoutManager(this);
        linearLayoutManagerdos.setOrientation(LinearLayoutManager.HORIZONTAL);
        pictureRecicledos.setLayoutManager(linearLayoutManagerdos);
        PictureHomeAdapterRecycleView pictureHomeAdapterRecycleViewdos = new PictureHomeAdapterRecycleView(otnerImala(), R.layout.tarjeta_cursov, this);
        pictureRecicledos.setAdapter(pictureHomeAdapterRecycleViewdos);

    }

    public ArrayList<PictureHouse> otnerImala(){
        ArrayList<PictureHouse> content = new ArrayList<>();
        content.add(new PictureHouse("http://academe.tech/wp-content/uploads/2016/03/Curso-Programacion-Android-a16.jpg","Programacion Android", "$800.00mxn"));
        content.add(new PictureHouse("https://i.kinja-img.com/gawker-media/image/upload/s--n43HARJv--/c_scale,f_auto,fl_progressive,q_80,w_800/sokjhw3tbb9crwfw1f3p.png","Programacion Web", "$550.00mxn"));
        content.add(new PictureHouse("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ-hPB_yCt3DRLuwFpzAN-uT4-2oJKG1JUpgt86hnhNGOXNzvcr","Curso de Video", "$780.00mxn"));
        content.add(new PictureHouse("https://i2.wp.com/educaperu.org/wp-content/uploads/2018/10/curso-dise%C3%B1o-grafico.jpg?ssl=1","Curso de Diseño Grafico", "690.00mxn"));

        return content;
    }



    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        int id = menuItem.getItemId();

        if (id == R.id.nav_home){
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);

        }else if (id == R.id.nav_buscar){
            Intent intent = new Intent(this, BuscarActivity.class);
            startActivity(intent);

        }else if (id == R.id.nav_favorito){
            Intent intent = new Intent(this, FavoritosActivity.class);
            startActivity(intent);

        }else if (id == R.id.nav_mycurso){
            Intent intent = new Intent(this, MiscursosActivity.class);
            startActivity(intent);

        }else if (id == R.id.nav_cuenta){
            Intent intent = new Intent(this, PerfilActivity.class);
            startActivity(intent);

        }else if (id == R.id.nav_ajuetes){

        }else if (id == R.id.nav_ayuda){

        }
        DrawerLayout drawer =(DrawerLayout) findViewById(R.id.draw_home);
        drawer.closeDrawer(Gravity.START);

        return true;
    }
}
