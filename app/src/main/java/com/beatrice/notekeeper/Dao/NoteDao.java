package com.beatrice.notekeeper.Dao;

import com.beatrice.notekeeper.entity.Note;
import com.beatrice.notekeeper.utils.Constants;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface NoteDao {

    @Query("SELECT * FROM note "+ Constants.TABLE_NAME_NOTE)
    LiveData<List<Note>> getAllNotes ();
    @Insert
    void insert(Note note);
    @Update
    void update(Note note);
    @Delete
    void delete(Note note);
    /**
     * delete a list of objects from the database
     */
    @Delete
    void delete(Note... notes);

}
