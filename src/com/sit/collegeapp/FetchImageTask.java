package com.sit.collegeapp;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

public class FetchImageTask extends AsyncTask<String, Integer, Bitmap> {
    @Override
    protected Bitmap doInBackground(String... arg0) {
        Bitmap b = null;
        try {
            b = BitmapFactory.decodeStream((InputStream) new URL(arg0[0]).getContent());
        }
        catch (MalformedURLException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return b;
    }
}