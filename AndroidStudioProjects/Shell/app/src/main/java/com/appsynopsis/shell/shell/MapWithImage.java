package com.appsynopsis.shell.shell;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.media.Image;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


public class MapWithImage extends ActionBarActivity {
    ImageView map;
    TextView name, adress,contact,contact_no,service;
    String lat,longi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_with_image);
        Intent in=getIntent();
        final Bundle bundle=getIntent().getExtras();
        name=(TextView)findViewById(R.id.textView);
        adress=(TextView)findViewById(R.id.textView3);
        contact=(TextView)findViewById(R.id.textView4);
        contact_no=(TextView)findViewById(R.id.textView5);
        service=(TextView)findViewById(R.id.textView7);


        name.setText(bundle.getString("name"));
        adress.setText(bundle.getString("adress"));
        contact.setText(bundle.getString("contact"));
        contact_no.setText(bundle.getString("contact_no"));
        service.setText(bundle.getString("services"));
        lat=bundle.getString("lat");
        longi=bundle.getString("longi");
        name.setTextColor(Color.BLACK);
        name.setTypeface(Typeface.DEFAULT_BOLD);
        adress.setTextColor(Color.BLACK);
        contact.setTextColor(Color.BLACK);
        contact_no.setTextColor(Color.BLACK);
        service.setTextColor(Color.BLACK);

        map=(ImageView)findViewById(R.id.imageView);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(MapWithImage.this,WebMapNavigation.class);
                in.putExtras(bundle);
                startActivity(in);
            }
        });


        String url = "http://maps.google.com/maps/api/staticmap?center=" + lat + "," + longi + "&zoom=15&size=350x400&maptype=roadmap&markers=color:blue%7Clabel:A%7C" + lat + "," + longi;
        new Getmap(url).execute();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_map_with_image, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    private class Getmap extends AsyncTask<Void, Void, Bitmap> {
        String url;
        Getmap(String url){

            this.url=url;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog


        }

        @Override
        protected Bitmap doInBackground(Void... arg0) {
            try {

               URL url1 = new URL(url);
                Bitmap image = BitmapFactory.decodeStream(url1.openConnection().getInputStream());
               return  image;
            } catch (MalformedURLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }


            return null;

        }

        @Override
        protected void onPostExecute(Bitmap map1) {
            BitmapDrawable ob = new BitmapDrawable(getResources(), map1);
            map.setBackgroundDrawable(ob);


        }

    }
}
