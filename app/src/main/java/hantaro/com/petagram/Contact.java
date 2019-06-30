package hantaro.com.petagram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

public class Contact extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);


        Button button = findViewById(R.id.bt_send_email);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView message = findViewById(R.id.et_message_body);
                SimpleMail.sendEmail(message.toString());
                Toast.makeText(Contact.this, getResources().getString(R.string.success), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
