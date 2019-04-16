package android.webdevk.dragracers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.menu_activity);
    }

    public void onPlayBtnClick(View v)
    {
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }

}
