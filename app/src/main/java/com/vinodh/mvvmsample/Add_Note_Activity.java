package com.vinodh.mvvmsample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

public class Add_Note_Activity extends AppCompatActivity {
    public static final String TITLE_DATA = "title";
    public static final String DESCRIPTION_DATA = "description";
    public static final String PRIORITY_DATA = "priority";

    EditText title_ed;
    EditText desc_ed;
    NumberPicker picker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__note);

        title_ed = (EditText) findViewById(R.id.title_edittext);
        desc_ed = (EditText) findViewById(R.id.desc_edittext);
        picker = (NumberPicker) findViewById(R.id.number_picker_id);

        picker.setMinValue(1);
        picker.setMaxValue(10);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_item,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.save_note:
                saveNote();
                finish();
                return true;
                default:
                    return super.onOptionsItemSelected(item);
        }

    }

    private void saveNote() {
        String title = title_ed.getText().toString();
        String description = desc_ed.getText().toString();
        int priority = picker.getValue();

        if(title.trim().isEmpty() || description.trim().isEmpty()){
            Toast.makeText(this, "Enter the fields", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent data = new Intent();
        data.putExtra(TITLE_DATA, title);
        data.putExtra(DESCRIPTION_DATA, description);
        data.putExtra(PRIORITY_DATA, priority);

        setResult(RESULT_OK,data);

    }
}
