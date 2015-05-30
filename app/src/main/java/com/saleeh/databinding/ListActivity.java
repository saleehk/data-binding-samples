package com.saleeh.databinding;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import com.saleeh.databinding.adapter.ListAdapter;
import com.saleeh.databinding.api.ServiceApi;
import com.saleeh.databinding.api.models.Repo;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class ListActivity extends AppCompatActivity {
    ListView listView;
    ListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        listView = (ListView) findViewById(R.id.listView);

        ServiceApi.getInstance().getCachedApiService().getRepositories(new Callback<List<Repo>>() {
            @Override
            public void success(List<Repo> repos, Response response) {
                adapter = new ListAdapter(ListActivity.this, repos);
                listView.setAdapter(adapter);
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(ListActivity.this, "That was an error", Toast.LENGTH_LONG).show();

            }
        });

    }


}
