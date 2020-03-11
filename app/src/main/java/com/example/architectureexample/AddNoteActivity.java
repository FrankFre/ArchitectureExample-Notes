package com.example.architectureexample;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

import java.util.Objects;

public class AddNoteActivity extends AppCompatActivity {
    public static final String EXTRA_TITLE = "com.codingflow.architectureexampe.EXTRA_TITLE";
    public static final String EXTRA_DESCRIPTION = "com.codingflow.architectureexampe.EXTRA_DESCRIPTION";
    public static final String EXTRA_PRIORITY = "com.codingflow.architectureexampe.EXTRA_PRIORITY";

    private EditText editTextTitle;
    private EditText editTextDescription;
    private NumberPicker numberPickerPriority;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        editTextTitle = findViewById(R.id.edit_text_title);
        editTextDescription = findViewById(R.id.edit_text_description);
        numberPickerPriority = findViewById(R.id.number_picker_priority);

        numberPickerPriority.setMinValue(1);
        numberPickerPriority.setMaxValue(10);

        Objects.requireNonNull(getSupportActionBar()).setHomeAsUpIndicator(R.drawable.ic_close);
        setTitle("Add Note");
    }

        private void saveNote()  {
            String title = editTextTitle.getText().toString();
            String description = editTextDescription.getText().toString();
            int priority = numberPickerPriority.getValue();

            if (title.trim().isEmpty() || description.trim().isEmpty())  {
                Toast.makeText(this, "Please insert a title and desciption", Toast.LENGTH_SHORT).show();
                return;
            }

            Intent data = new Intent();
            data.putExtra(EXTRA_TITLE, title);
            data.putExtra(EXTRA_DESCRIPTION, description);
            data.putExtra(EXTRA_PRIORITY, priority);

            setResult(RESULT_OK, data);
            finish();
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu)  {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_note_menu, menu);
        return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
           if (item.getItemId() == R.id.save_note) {
                saveNote();
                return true;
           }

           return super.onOptionsItemSelected(item);
        }
    }



