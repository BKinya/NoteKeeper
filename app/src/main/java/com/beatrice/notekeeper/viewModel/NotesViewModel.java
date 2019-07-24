package com.beatrice.notekeeper.viewModel;

import android.app.Application;
import android.util.Log;

import com.beatrice.notekeeper.entity.Note;
import com.beatrice.notekeeper.repository.NoteRepository;


import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class NotesViewModel extends AndroidViewModel {

    private LiveData<List<Note>> notesList;
    private NoteRepository noteRepository;

    public NotesViewModel(@NonNull Application application) {
        super(application);
        noteRepository = new NoteRepository(application);
        notesList = noteRepository.getNotes();
        Log.e("VIEWMODEL CREATED", "I CREATED");

    }


    public LiveData<List<Note>> getNotes(){
        return notesList;
    }

    public void insertNote(Note note){
        noteRepository.insertNote(note);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.e("VIEWMODEL CLEARED", "I CLEARED");
    }
}
