package tk.muslimzabirov.myapp;

import android.app.SearchManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class SearchResultsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);


        Toolbar my_toolbar = (Toolbar) findViewById(R.id.search_results_toolbar);
        setSupportActionBar(my_toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        Intent searchIntent = getIntent();
        String query = null;
        if (Intent.ACTION_SEARCH.equals(searchIntent.getAction())) {
            query = searchIntent.getStringExtra(SearchManager.QUERY);
            getSupportActionBar().setTitle(query);
            Toast.makeText(SearchResultsActivity.this, query, Toast.LENGTH_SHORT).show();
        }

        String[] countries = getResources().getStringArray(R.array.countries);
        ArrayList<String> searchers = new ArrayList<>();
        for (int i = 0; i < countries.length; i++)
            if (countries[i].toLowerCase().contains(query.toLowerCase()))
                searchers.add(countries[i]);

        ListView listView = (ListView) findViewById(R.id.listView_searchResults);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, searchers);
        listView.setAdapter(arrayAdapter);


    }
}
