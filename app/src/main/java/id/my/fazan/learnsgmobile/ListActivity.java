package id.my.fazan.learnsgmobile;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import id.my.fazan.learnsgmobile.adapter.ListUserAdapter;
import id.my.fazan.learnsgmobile.model.User;

public class ListActivity extends AppCompatActivity {

    static ArrayList<User> listUser = new ArrayList<>();
    RecyclerView rv_user;
    ListUserAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_data);

        rv_user = findViewById(R.id.rv_user);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        adapter = new ListUserAdapter(listUser);
        rv_user.setAdapter(adapter);
        rv_user.setHasFixedSize(true);
        rv_user.setLayoutManager(mLayoutManager);

        Bundle extra = getIntent().getExtras();
        if (extra != null) {
            User user = extra.getParcelable("user");
            listUser.add(user);
        }
    }
}
