package com.example.user.mvpsorter.UI;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.mvpsorter.Model.NetObject;
import com.example.user.mvpsorter.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MainPresenter.View{

    private static final String TAG = "MAINACTIVITY";
    MainPresenter mainPresenter;
    private RecyclerView numberListView;
    NumberAdapter adapter;
    ArrayList<Integer> list = new ArrayList<>();
    TextView sumView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainPresenter = new MainPresenter(this);

        numberListView = findViewById(R.id.number_recycler);
        sumView = findViewById(R.id.sum);
        adapter = new NumberAdapter(list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        DividerItemDecoration decoration = new DividerItemDecoration(this,layoutManager.getOrientation());
        numberListView.setLayoutManager(layoutManager);
        numberListView.addItemDecoration(decoration);
        numberListView.setAdapter(adapter);

        mainPresenter.retrieveNumbers();
    }


    @Override
    public void updateRecyclerView(ArrayList<Integer> list) {
        this.list.addAll(list);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void updateSum(int sum) {
        sumView.setText(String.valueOf(sum));
    }

    @Override
    public void displayErrorToast() {
        Toast.makeText(this, "Network error!!",
                Toast.LENGTH_LONG).show();
    }
}
