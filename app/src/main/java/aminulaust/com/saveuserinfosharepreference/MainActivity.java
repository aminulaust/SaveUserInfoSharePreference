package aminulaust.com.saveuserinfosharepreference;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button saveinfo,showinfo;
    EditText username, password;
    TextView displayinfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        saveinfo =(Button)findViewById(R.id.saveinfo);
        showinfo =(Button)findViewById(R.id.showinfo);
        username =(EditText)findViewById(R.id.input);
        password =(EditText)findViewById(R.id.pass);
        displayinfo=(TextView)findViewById(R.id.dispalyinfo);

    }
//save user info

    public void saveclick (View view){
        SharedPreferences sahrePref=getSharedPreferences("userInfo", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor= sahrePref.edit();

        editor.putString("username", username.getText().toString());
        editor.putString("password", password.getText().toString());

        editor.apply();

        Toast.makeText(this,"save",Toast.LENGTH_SHORT).show();

    }
    public void showclick (View view){
        SharedPreferences sahrePref=getSharedPreferences("userInfo", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor= sahrePref.edit();

       String name=sahrePref.getString("username", "");
        String pas=sahrePref.getString("password", "");

        displayinfo.setText(name+"   "+pas);

    }

}
