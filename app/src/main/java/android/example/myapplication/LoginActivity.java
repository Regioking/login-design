package android.example.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login);

        Button btnLogin=(Button)findViewById(R.id.btnLogin);
        Button btnLinkToRegisterScreen=(Button)findViewById(R.id.btnLinkToRegisterScreen);
        //final TextView userName = (TextView) findViewById(R.id.name);
         final TextView userEmail = (TextView) findViewById(R.id.email);
         final TextView userPassword = (TextView) findViewById(R.id.password);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences pref = getSharedPreferences("registerDate",MODE_PRIVATE);
                String email = pref.getString("email","");
                Log.d("hahahah",email);
                Log.d("这是输入的邮件",userEmail.getText().toString());
                String password = pref.getString("password","");
                if (email.equals(userEmail.getText().toString())&&password.equals(userPassword.getText().toString()))
                {
                    //Toast.makeText(LoginActivity.this,"success login",Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(LoginActivity.this,AfterLoginActivity.class);
                    startActivity(i);
                    LoginActivity.this.finish();
                }
                else {
                    Toast.makeText(LoginActivity.this, "failed login", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnLinkToRegisterScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(i);
                LoginActivity.this.finish();
            }
        });
    }
}
