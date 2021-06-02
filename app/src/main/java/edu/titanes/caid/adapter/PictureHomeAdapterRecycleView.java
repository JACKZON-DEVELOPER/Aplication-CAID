package edu.titanes.caid.adapter;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Picture;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import edu.titanes.caid.R;
import edu.titanes.caid.model.PictureHouse;
import edu.titanes.caid.view.DetallecursoActivity;

public class PictureHomeAdapterRecycleView extends RecyclerView.Adapter<PictureHomeAdapterRecycleView.PictureViewHolder>{

    private ArrayList<PictureHouse> pictureHouses;
    private int resuuse;
    private Activity activity;

    public PictureHomeAdapterRecycleView(ArrayList<PictureHouse> pictureHouses, int resuuse, Activity activity) {
        this.pictureHouses = pictureHouses;
        this.resuuse = resuuse;
        this.activity = activity;
    }

    @Override
    public PictureViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(resuuse, viewGroup, false);
        return new PictureViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PictureViewHolder pictureViewHolder, int i) {
        PictureHouse picture = pictureHouses.get(i);
        pictureViewHolder.tituloCard.setText(pictureHouses.get(i).getTituloH());
        pictureViewHolder.precioCard.setText(pictureHouses.get(i).getPrecioH());
        Picasso.get().load(picture.getPictureImgH()).into(pictureViewHolder.imagenCard);

        pictureViewHolder.imagenCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, DetallecursoActivity.class);
                activity.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return pictureHouses.size();
    }

    public class PictureViewHolder extends RecyclerView.ViewHolder{

        private ImageView imagenCard;
        private TextView tituloCard;
        private TextView precioCard;


        public PictureViewHolder(View itemView) {
            super(itemView);

            imagenCard = (ImageView) itemView.findViewById(R.id.img_imgC_tarjV);
            tituloCard = (TextView) itemView.findViewById(R.id.tex_tituloC_tarjV);
            precioCard = (TextView) itemView.findViewById(R.id.tex_precio_tarjV);
        }
    }
}
