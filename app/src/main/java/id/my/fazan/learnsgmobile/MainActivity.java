package id.my.fazan.learnsgmobile;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import id.my.fazan.learnsgmobile.model.User;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextInputLayout til_nama;
    EditText et_umur;
    Spinner spinner_gender;
    Button btn_proses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        til_nama = findViewById(R.id.til_nama);
        et_umur = findViewById(R.id.et_umur);
        spinner_gender = findViewById(R.id.spinner_gender);
        btn_proses = findViewById(R.id.btn_proses);

        btn_proses.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_proses:
                validasiData();
                break;
        }
    }

    void validasiData(){
        if (til_nama.getEditText() != null){
            // Jika Nama dan Umur tidak kosong
            if (!til_nama.getEditText().getText().toString().equals("") && !et_umur.getText().toString().equals("") ){
                User user = new User();
                user.nama = til_nama.getEditText().getText().toString();
                user.umur = Integer.parseInt(et_umur.getText().toString());
                user.gender = spinner_gender.getSelectedItem().toString();

                proccessData(user);
            } else {
                Toast.makeText(this, "Data Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void proccessData(User user) {
        Intent intent = new Intent(this, ListActivity.class);
        intent.putExtra("nama", user.nama);
        intent.putExtra("gender", user.gender);
        intent.putExtra("umur", user.umur);
        startActivity(intent);
    }
}
