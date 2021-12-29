package activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;

public class ContactActivity extends AppCompatActivity {
    Toolbar toolbarLienhe;
    ImageView imgName,imgEmail,imgTeleNum;
    TextView tvTitle, tvThanks, tvwebsite;
    TextView tvName, tvEmail, tvTeleNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        Mapping();
        ActionBar();
    }

    private void ActionBar() {
        setSupportActionBar(toolbarLienhe);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbarLienhe.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void Mapping() {
        toolbarLienhe = findViewById(R.id.id_toolbarLienhe);
        imgName = findViewById(R.id.id_imageviewContact1);
        imgEmail = findViewById(R.id.id_imageviewContact2);
        imgTeleNum = findViewById(R.id.id_imageviewContact3);
        tvTitle = findViewById(R.id.id_textviewContact1);
        tvThanks = findViewById(R.id.id_textviewContactThanks);
        tvwebsite = findViewById(R.id.id_textviewContactWebsite);
        tvName = findViewById(R.id.id_textviewContact1);
        tvEmail = findViewById(R.id.id_textviewContact2);
        tvTeleNum = findViewById(R.id.id_textviewContact3);

    }
}