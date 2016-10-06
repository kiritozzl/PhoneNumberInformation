package com.example.kirito.phonedestination;

import android.os.AsyncTask;

/**
 * Created by kirito on 2016.10.06.
 */

public class LoadData extends AsyncTask<String,Void,String> {
    private Listener listener;

    @Override
    protected String doInBackground(String... params) {
        return Http.getDataFromUrl(params[0]);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Item item = JsonHelper.parseJsonToItem(s);
        if (listener != null && item != null){
            listener.setItem(item);
        }
    }

    public interface Listener{
        void setItem(Item item);
    }

    public void setListener(Listener listener){
        this.listener = listener;
    }
}
