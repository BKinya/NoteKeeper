package com.beatrice.notekeeper.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.beatrice.notekeeper.Database.NoteDatabase;
import com.beatrice.notekeeper.R;
import com.beatrice.notekeeper.adapter.NoteAdapter;
import com.beatrice.notekeeper.entity.Note;
import com.beatrice.notekeeper.viewModel.NotesViewModel;

import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Button btn_start_new_activity;
    private NoteAdapter noteAdapter;
    private NoteDatabase noteDatabase;
    private NotesViewModel notesViewModel;
    public static final int NEW_WORD_ACTIVITY_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("CREATED", "MAINACTIVITY");
        btn_start_new_activity = findViewById(R.id.btn_start);
        recyclerView = findViewById(R.id.notes_container);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        notesViewModel = ViewModelProviders.of(this).get(NotesViewModel.class);
        notesViewModel.getNotes().observe(this, new Observer<List<Note>>() {
            @Override
            public void onChanged(List<Note> notes) {
                noteAdapter = new NoteAdapter(notes);
                Log.e("SIZE", " EE"+notes.size());
                recyclerView.setAdapter(noteAdapter);

            }
        });
//
        btn_start_new_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddNoteActivity.class);
                startActivityForResult(intent, NEW_WORD_ACTIVITY_REQUEST_CODE);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == NEW_WORD_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK){
            Note note = new Note(0, data.getStringExtra("EXTRA_NOTE_TITLE"), data.getStringExtra("EXTRA_NOTE_CONTENT"));
            notesViewModel.insertNote(note);
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("DESTROYED", "MAINACTIVITY");
    }
}
