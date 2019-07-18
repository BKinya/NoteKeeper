package com.beatrice.notekeeper.viewModel;

import android.util.Log;

import com.beatrice.notekeeper.model.Note;
import com.beatrice.notekeeper.repository.NoteRepository;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

public class NotesViewModel extends ViewModel {

    private LiveData<List<Note>> notesList;
    private NoteRepository noteRepository;


    public void queryRepo(){
        noteRepository = new NoteRepository();
        notesList = noteRepository.getNotes();

    }
    public LiveData<List<Note>> getNotes(){
        return notesList;
    }

    public NotesViewModel() {
        super();
        Log.e("VIEWMODEL CREATED", "I CREATED");
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.e("VIEWMODEL CLEARED", "I CLEARED");
    }
}
