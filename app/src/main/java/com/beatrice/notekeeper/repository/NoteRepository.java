package com.beatrice.notekeeper.repository;


import android.app.Application;

import java.util.List;

import androidx.lifecycle.LiveData;

import com.beatrice.notekeeper.Dao.NoteDao;
import com.beatrice.notekeeper.Database.NoteDatabase;
import com.beatrice.notekeeper.entity.Note;

public class NoteRepository {
    private NoteDao noteDao ;
    private LiveData<List<Note>> notesList;
    private NoteDatabase noteDatabase;

    public NoteRepository(Application application) {
        noteDatabase = NoteDatabase.getInstance(application);
        noteDao = noteDatabase.getNoteDao();
        notesList = noteDao.getAllNotes();
    }

    public LiveData<List<Note>> getNotes(){
        return notesList;
    }

    public void insertNote(Note note){
        noteDao.insert(note);
    }



}
