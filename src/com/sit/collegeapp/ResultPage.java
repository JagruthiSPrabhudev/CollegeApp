package com.sit.collegeapp;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.net.ParseException;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

@TargetApi(Build.VERSION_CODES.GINGERBREAD)
@SuppressLint("NewApi")
public class ResultPage extends Activity {
Button but1;
	@TargetApi(Build.VERSION_CODES.GINGERBREAD)
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result_page);
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		StrictMode.setThreadPolicy(policy);
		addListenerOnButton();
	}

	
	
	
	public void addListenerOnButton() {
		
		but1 = (Button) findViewById(R.id.button1);
		but1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
				//TextView mText = (TextView) findViewById(R.id.editText1);
				EditText t1=(EditText) findViewById(R.id.editText1);
				String t2=t1.getText().toString();
				//TextView mText = (TextView) findViewById(R.id.textView1);			
				Log.e("test1","empno"+t2);
				JSONObject jsonobject;
				JSONArray jArray;
				try
				{
				//jsonobject = JSONfunctions.getJSONfromURL("http://10.0.2.2/test1/s1.php");		
				jArray = JSONfunctions.getJSONfromURL("http://10.0.2.2/test1/resdis.php?rno="+t2);
				Log.e("test2","testing 2");
				
				Log.e("test3","test3"+jArray.length());
			
				String name1="";
				int a1=0;
				final ArrayList<String> stringList = new ArrayList<String>();
				//final String[] strarray = new String[100];
				//jArray = new JSONArray(result);
				 JSONObject json_data=null;
				 for(int i=0;i<jArray.length();i++){
				 json_data = jArray.getJSONObject(i);
				name1 = json_data.getString("subName");//here "Name" is the column name in database
				stringList.add(name1);
				//strarray[a1]=name1;
				name1 =json_data.getString("Marks");//here "Name" is the column name in database
				stringList.add(name1);
				
				//a1++;
				//strarray[a1]=name1;
				//a1++;
				//Toast.makeText(getBaseContext(), name1 ,Toast.LENGTH_SHORT).show();
				
				//mText.setText(name1);
				 
				 }
				 final GridView grid = (GridView) findViewById(R.id.gridView1);
				 grid.setAdapter(new GridAdapter(stringList));
				}
				catch(JSONException e1){Toast.makeText(getBaseContext(), "No Data Found 1" ,Toast.LENGTH_LONG).show();}
				catch (ParseException e1) {e1.printStackTrace(); }	
				catch(Exception ex1){
					Toast.makeText(getBaseContext(), "No Data Found 2" ,Toast.LENGTH_LONG).show();
					//mText.setText("No Data");
				}
				
				
				
				

	
				
				
				
			}
		});
}
	
	public static class JSONfunctions {
		  public static JSONArray getJSONfromURL(String url) {
		    InputStream is = null;
		    String result = "";
		    JSONArray jArray = null;

		    // Download JSON data from URL
		    try {
		        HttpClient httpclient = new DefaultHttpClient();
		        HttpPost httppost = new HttpPost(url);
		        HttpResponse response = httpclient.execute(httppost);
		        HttpEntity entity = response.getEntity();
		        is = entity.getContent();

		    } catch (Exception e) {
		        Log.e("log_tag", "Error in http connection " + e.toString());
		    }

		    // Convert response to string
		    try {
		        BufferedReader reader = new BufferedReader(new InputStreamReader(
		                is, "iso-8859-1"), 8);
		        StringBuilder sb = new StringBuilder();
		        String line = null;
		        while ((line = reader.readLine()) != null) {
		            sb.append(line + "\n");
		        }
		        is.close();
		        result = sb.toString();
		    } catch (Exception e) {
		        Log.e("log_tag", "Error converting result " + e.toString());
		    }

		    try {

		        jArray = new JSONArray(result);
		    } catch (JSONException e) {
		        Log.e("log_tag", "Error parsing data " + e.toString());
		    }

		    return jArray;
		  }
		}
	
	
	private static final int ROW_ITEMS = 2;

    private static final class GridAdapter extends BaseAdapter {

        final ArrayList<String> mItems;
        final int mCount;

        /**
         * Default constructor
         * @param items to fill data to
         */
        private GridAdapter(final ArrayList<String> items) {

            mCount = items.size() * ROW_ITEMS;
            mItems = new ArrayList<String>(mCount);

            // for small size of items it's ok to do it here, sync way
            for (String item : items) {
                // get separate string parts, divided by ,
                final String[] parts = item.split(",");

                // remove spaces from parts
                for (String part : parts) {
                    part.replace(" ", "");
                    mItems.add(part);
                }
            }
        }

        @Override
        public int getCount() {
            return mCount;
        }

        @Override
        public Object getItem(final int position) {
            return mItems.get(position);
        }

        @Override
        public long getItemId(final int position) {
            return position;
        }

        @Override
        public View getView(final int position, final View convertView, final ViewGroup parent) {

            View view = convertView;

            if (view == null) {
                view = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_2, parent, false);
            }

            final TextView text = (TextView) view.findViewById(android.R.id.text1);

            text.setText(mItems.get(position));

            return view;
        }
    }
    

}
