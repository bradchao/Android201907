package tw.org.iii.android201907;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences sp;
    private SharedPreferences.Editor editor;
    private int i = 1;
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

    public void test3(View view) {
        try {
            FileOutputStream fout = openFileOutput("newbrad.txt", MODE_APPEND);
            fout.write((i++ + " Hello, World\n").getBytes());
            fout.flush();
            fout.close();
            Toast.makeText(this, "Save OK2", Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Log.v("brad",e.toString());
        }

    }
    public void test4(View view) {
        try {
            FileInputStream fin = openFileInput("newbrad.txt");
            InputStreamReader ins = new InputStreamReader(fin);
            BufferedReader br = new BufferedReader(ins);
            String line;
            while ( (line = br.readLine()) != null) {
                Log.v("brad", line);
            }
            br.close();
        }catch (Exception e){
            Log.v("brad",e.toString());
        }
    }
}
