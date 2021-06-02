package edu.titanes.caid.view;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;

import edu.titanes.caid.R;

public class CamaraActivity extends AppCompatActivity {

    ImageView imageView;
    Button imgbuton;

    static final int REQUEST_IMAF_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camara);

        imageView = (ImageView) findViewById(R.id.img_foto_foto);
        imgbuton = (Button) findViewById(R.id.tn_guardar_foto);

        imgbuton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takePicture();
            }
        });



    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == REQUEST_IMAF_CAPTURE && resultCode == this.RESULT_OK){

            Bundle extrea = data.getExtras();
            Bitmap imageitmap = (Bitmap) extrea.get("data");
            imageView.setImageBitmap(imageitmap);
        }
    }

    private void takePicture() {

        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(this.getPackageManager()) != null){


            File potofile = null;
            try {
                potofile = crateImgFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (potofile !=null){

                Uri potoURI = FileProvider.getUriForFile(this , "edu.titanes.caid", potofile);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, potoURI);
                startActivityForResult(takePictureIntent, REQUEST_IMAF_CAPTURE);

            }


        }
    }

    private File crateImgFile() throws IOException{
        String timeStrmp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFilname = "JPEG_" + timeStrmp + "_";
        File storageDir = this.getExternalFilesDir(Environment.DIRECTORY_PICTURES);

        File image = File.createTempFile(
          imageFilname, ".jpg", storageDir
        );


        return image;
    }







}
