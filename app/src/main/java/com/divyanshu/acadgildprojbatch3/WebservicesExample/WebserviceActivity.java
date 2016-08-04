package com.divyanshu.acadgildprojbatch3.WebservicesExample;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.divyanshu.acadgildprojbatch3.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Divyanshu on 04-08-2016.
 */
public class WebserviceActivity extends ListActivity {

    private ProgressDialog progressDialog;
    private static String url = "http://api.themoviedb.org/3/tv/top_rated?api_key=8496be0b2149805afa458ab8ec27560c";

    private static final String TAG_RESULT="results";
    private static final String TAG_ID="id";
    private static final String TAG_NAME="name";
    private static final String TAG_VOTEAVG="vote_average";


    JSONArray tvShow =null;
    ArrayList<HashMap<String,String>> tvShowlist;
    ListView lv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webservics);
        tvShowlist = new ArrayList<HashMap<String, String>>();
//
        lv = getListView();

        new GetMovieDetails().execute();

    }


    private class GetMovieDetails extends AsyncTask<Void,Void,Void>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog= new ProgressDialog(WebserviceActivity.this);
            progressDialog.setMessage("Please wait yar");
            progressDialog.setCancelable(false);
            progressDialog.show();
        }

        @Override
        protected Void doInBackground(Void... voids) {

            ServiceHandler sh = new ServiceHandler();

            String jsonStr = sh.makeServiceCall(url,ServiceHandler.GET);
            System.out.println("Response   : "+jsonStr);

            try{
                if(jsonStr!=null){
                    JSONObject jsonObject= new JSONObject(jsonStr);

                    tvShow = jsonObject.getJSONArray(TAG_RESULT);

                    for(int i=0; i<tvShow.length();i++){
                        JSONObject c =tvShow.getJSONObject(i);
                        String id = c.getString(TAG_ID);
                        String name = c.getString(TAG_NAME);
                        String voteAvg = c.getString(TAG_VOTEAVG);


                        HashMap<String,String> tvSshows = new HashMap<String, String>();
                        tvSshows.put(TAG_ID,id);
                        tvSshows.put(TAG_NAME,name);
                        tvSshows.put(TAG_VOTEAVG,voteAvg);
                        tvShowlist.add(tvSshows);
                    }
                }

            }catch (Exception e){
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            progressDialog.dismiss();

            ListAdapter adapter = new SimpleAdapter(WebserviceActivity.this,tvShowlist,R.layout.webservices_list_items,
                    new String[]{TAG_ID,TAG_NAME,TAG_VOTEAVG},new int[]{R.id.no,R.id.name,R.id.voteavg});

            setListAdapter(adapter);
        }
    }
}
