package com.beatrice.notekeeper.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.beatrice.notekeeper.R;
import com.beatrice.notekeeper.adapter.NoteAdapter;
import com.beatrice.notekeeper.model.Note;
import com.beatrice.notekeeper.viewModel.NotesViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private NoteAdapter noteAdapter;
    private NotesViewModel notesViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("ACTIVITY", "CREATED");

        recyclerView = findViewById(R.id.notes_container);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        notesViewModel = ViewModelProviders.of(this).get(NotesViewModel.class);
        notesViewModel.queryRepo();
        notesViewModel.getNotes().observe(this, new Observer<List<Note>>() {
            @Override
            public void onChanged(List<Note> notes) {
                Toast.makeText(MainActivity.this, "rrrrr", Toast.LENGTH_LONG).show();
                noteAdapter = new NoteAdapter(notes);
                recyclerView.setAdapter(noteAdapter);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("DESTROYED", "ACTIVITY");
    }
}
