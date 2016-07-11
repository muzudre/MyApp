package tk.muslimzabirov.myapp;

import android.app.SearchManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

public class SearchReasultsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_reasults);

        Toolbar my_toolbar = (Toolbar) findViewById(R.id.search_reasul_toolbar);
        setSupportActionBar(my_toolbar);



        Intent searchIntent = getIntent();
        if (Intent.ACTION_SEARCH.equals(searchIntent.getAction())){
            String query = searchIntent.getStringExtra(SearchManager.QUERY);
            getSupportActionBar().setTitle(query    );
            Toast.makeText(SearchReasultsActivity.this, query, Toast.LENGTH_SHORT).show();
        }
    }
}
