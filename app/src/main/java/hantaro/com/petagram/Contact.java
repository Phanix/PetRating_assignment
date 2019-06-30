package hantaro.com.petagram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Contact extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        Toolbar toolbar = findViewById(R.id.action_bar_custom);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.findViewById(R.id.top_rated).setVisibility(View.INVISIBLE);

        Button button = findViewById(R.id.bt_send_email);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView message = findViewById(R.id.et_message_body);
                TextView name    = findViewById(R.id.et_name);
                TextView email   = findViewById(R.id.et_email);
                SimpleMail.sendEmail(message.getText().toString(), email.getText().toString(), name.getText().toString());
                Toast.makeText(Contact.this, getResources().getString(R.string.success), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
