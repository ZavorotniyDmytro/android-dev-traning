package zavorontii.dmytro.android.lr1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: Activity created");
        showToast("Activity created");

        Button btnOpenFragment1 = findViewById(R.id.btnOpenFragment1);
        Button btnOpenFragment2 = findViewById(R.id.btnOpenFragment2);

        btnOpenFragment1.setOnClickListener(v -> openFragment(new Fragment1()));
        btnOpenFragment2.setOnClickListener(v -> openFragment(new Fragment2()));
    }

    private void openFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.black) {
            changeBackgroundColor(R.color.black);
            return true;
        } else if (itemId == R.id.white) {
            changeBackgroundColor(R.color.white);
            return true;
        } else if (itemId == R.id.aqua) {
            changeBackgroundColor(R.color.aqua);
            return true;
        } else if (itemId == R.id.teal) {
            changeBackgroundColor(R.color.teal);
            return true;
        } else if (itemId == R.id.fuchsia) {
            changeBackgroundColor(R.color.fuchsia);
            return true;
        } else if (itemId == R.id.red) {
            changeBackgroundColor(R.color.red);
            return true;
        } else if (itemId == R.id.olive) {
            changeBackgroundColor(R.color.olive);
            return true;
        }
        return false;
    }

    private void changeBackgroundColor(int colorId) {
        int color = getResources().getColor(colorId);
        getWindow().getDecorView().getRootView().setBackgroundColor(color);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: Activity started");
        showToast("Activity started");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: Activity resumed");
        showToast("Activity resumed");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: Activity paused");
        showToast("Activity paused");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: Activity stopped");
        showToast("Activity stopped");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: Activity destroyed");
        showToast("Activity destroyed");
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}