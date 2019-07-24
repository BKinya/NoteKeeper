package com.beatrice.notekeeper.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.beatrice.notekeeper.Database.NoteDatabase;
import com.beatrice.notekeeper.R;
import com.beatrice.notekeeper.entity.Note;

public class AddNoteActivity extends AppCompatActivity {

    private EditText title_edittext, content_edittext;
    private Button btn_add_new_note;

    private NoteDatabase noteDatabase;
    private Note note;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        title_edittext = findViewById(R.id.note_title_edittxt);
        content_edittext = findViewById(R.id.note_content_edittxt);
        btn_add_new_note = findViewById(R.id.btn_add_note);

        noteDatabase = NoteDatabase.getInstance(AddNoteActivity.this);
        btn_add_new_note.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Intent intent = new Intent();
              intent.putExtra("EXTRA_NOTE_TITLE", title_edittext.getText().toString());
              intent.putExtra("EXTRA_NOTE_CONTENT", content_edittext.getText().toString());
              setResult(RESULT_OK, intent);
              finish();
            }
        });
    }
}
