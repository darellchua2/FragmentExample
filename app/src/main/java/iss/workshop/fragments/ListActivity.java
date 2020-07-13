package iss.workshop.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class ListActivity extends AppCompatActivity implements ListFragment.IDetailFragment {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        Intent intent = getIntent();
        // int itemId = intent.getIntExtra("itemId", 1);
        // Temporarily hard code the itemId value
        int itemId = 2;

        FragmentManager fm = getSupportFragmentManager();
        ListFragment fragment = (ListFragment) fm.findFragmentById(R.id.fragment_list);
        fragment.setItemId(itemId);

    }

    @Override
    public void itemClicked(String content){
        Toast toast = Toast.makeText(this,content,Toast.LENGTH_SHORT);
        toast.show();
    }
}