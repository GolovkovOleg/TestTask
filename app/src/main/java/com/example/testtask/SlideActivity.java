package com.example.testtask;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class SlideActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private SlideAdapter slideAdapter;
    private List<Item> itemList;
    private DepthTransformation depthTransformation;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide);

        itemList = new ArrayList<>();
        depthTransformation = new DepthTransformation();
        slideAdapter = new SlideAdapter(this, itemList);

        viewPager = (ViewPager) findViewById(R.id.view_pager);
        viewPager.setPageTransformer(true, depthTransformation);

        prepareItems();

        viewPager.setAdapter(slideAdapter);
    }

    private void prepareItems() {
        String url = "https://api.steller.co/v1/users/76794126980351029/stories";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONObject jsonObject = new JSONObject(String.valueOf(response));
                            JSONArray jsonArray = jsonObject.getJSONArray("data");
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jo = jsonArray.getJSONObject(i);
                                JSONObject user = jsonArray.getJSONObject(i).getJSONObject("user");
                                JSONObject likes = jsonArray.getJSONObject(i).getJSONObject("likes");
                                Item item = new Item(
                                        jo.getString("short_id"),
                                        jo.getString("title").toUpperCase(),
                                        jo.getString("cover_src"),
                                        user.getString("display_name"),
                                        likes.getInt("count")
                                );
                                itemList.add(item);
                                slideAdapter.notifyDataSetChanged();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(jsonObjectRequest);
    }

}
