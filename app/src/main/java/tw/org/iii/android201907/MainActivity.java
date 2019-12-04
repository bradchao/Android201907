package tw.org.iii.android201907;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences sp;
    private SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp = getSharedPreferences("mydata", MODE_PRIVATE);
        editor = sp.edit();
    }

    public void test1(View view) {
        editor.putBoolean("sound", false);
        editor.putInt("stage", 4);
        editor.putString("username", "Brad");
        editor.commit();
        Toast.makeText(this, "Save OK", Toast.LENGTH_SHORT).show();
    }
    public void test2(View view) {
        int stage = sp.getInt("stage", 0);
        String name = sp.getString("username", "nobody");
        boolean sound = sp.getBoolean("sound", true);
        Log.v("brad", name + ":" + stage + ":" + sound);
    }
}
