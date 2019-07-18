package com.beatrice.notekeeper.repository;

import com.beatrice.notekeeper.model.Note;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class NoteRepository {
    private List<Note> notesList = new ArrayList<>();

    public LiveData<List<Note>> getNotes(){
        setNotesList();
        MutableLiveData<List<Note>> notesMutableList = new MutableLiveData<>();
        notesMutableList.setValue(notesList);
        return notesMutableList;

    }

    private void setNotesList(){
        notesList.add(new Note("Java", "Classes", "Encapsulation, Methods, Variable, Access modifiers"));
        notesList.add(new Note("Python", "Data types", "Numbers, String, list, tuples, dictionary"));
        notesList.add(new Note("Android", "Architecture components", "MVVM, LiveData, ViewModel, ...Room"));
    }


}
