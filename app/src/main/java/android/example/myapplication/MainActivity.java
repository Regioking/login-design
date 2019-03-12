package android.example.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_register);
        //setContentView(R.layout.layout_login);
        //setContentView(R.layout.activity_main);
        Button btnRegister = (Button) findViewById(R.id.btnRegister);
        Button btnLinkToLoginScreen = (Button) findViewById(R.id.btnLinkToLoginScreen);

        final TextView userName = (TextView) findViewById(R.id.name);
        final TextView userEmail = (TextView) findViewById(R.id.email);
        final TextView password = (TextView) findViewById(R.id.password);

        btnRegister.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = getSharedPreferences("registerDate",MODE_PRIVATE).edit();
                editor.putString("name",userName.getText().toString());
                editor.putString("email",userEmail.getText().toString());
                editor.putString("password",password.getText().toString());
                editor.apply();
                Toast.makeText(MainActivity.this,"success logUp",Toast.LENGTH_SHORT).show();
            }

        });


        btnLinkToLoginScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(i);
                MainActivity.this.finish();
            }
        });
    }
}
