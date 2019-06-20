package com.redwood2magnet.sharedpreferances;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private EditText editText;
    private Button applytxtbtn;
    private Switch switch1;
    private Button savebtn;

    private static final String SHARED_PREFs = "SharedPrefs";
    private static final String TEXT="text";
    private static final String SWITCH1="switchonoff";

    private String text;
    private boolean switchonoff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.txtview);
        editText = (EditText)findViewById(R.id.edittxt);
        applytxtbtn=(Button)findViewById(R.id.apply_text_btn);
        switch1= (Switch)findViewById(R.id.switch1);
        savebtn= (Button)findViewById(R.id.save_btn);

        applytxtbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(editText.getText().toString());

            }
        });

        savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savedata();

            }
        });
        loaddata();
        updatedata();
    }

    public void savedata(){
        SharedPreferences sharedPreferences= getSharedPreferences(SHARED_PREFs,MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();

        editor.putString(TEXT,editText.getText().toString());
        editor.putBoolean(SWITCH1,switch1.isChecked());
        editor.apply();

        Toast.makeText(this,"data saved",Toast.LENGTH_SHORT).show();
    }

    public  void loaddata(){
        SharedPreferences sharedPreferences= getSharedPreferences(SHARED_PREFs,MODE_PRIVATE);
        text= sharedPreferences.getString(TEXT,"");
        switchonoff=sharedPreferences.getBoolean(SWITCH1,false);

    }

    public void updatedata(){
        textView.setText(text);
        switch1.setChecked(switchonoff);
    }
}
