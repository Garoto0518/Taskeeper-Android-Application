package com.garoto.todo_android_application;

import android.graphics.Typeface;
import android.media.MediaMetadata;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class HomePage extends AppCompatActivity {

    TextView tituloDeAplicacion, subTituloDeAplicacion, endPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        tituloDeAplicacion = findViewById(R.id.tituloDeAplicacion);
        subTituloDeAplicacion = findViewById(R.id.subTituloDeAplicacion);
        endPage = findViewById(R.id.subTituloDeAplicacion);

        //Font
        Typeface mediumLight = Typeface.createFromAsset(getAssets(), "fonts/ML.ttf");
        Typeface MMedium = Typeface.createFromAsset(getAssets(),"fonts/MM.ttf");

        tituloDeAplicacion.setTypeface(MMedium);
        subTituloDeAplicacion.setTypeface(mediumLight);
        endPage.setTypeface(mediumLight);
    }
}
