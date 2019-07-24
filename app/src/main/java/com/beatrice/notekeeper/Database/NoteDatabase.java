package com.beatrice.notekeeper.Database;

import android.content.Context;

import com.beatrice.notekeeper.Dao.NoteDao;
import com.beatrice.notekeeper.entity.Note;
import com.beatrice.notekeeper.utils.Constants;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
@Database(entities = {Note.class}, version = 1)

public abstract class NoteDatabase extends RoomDatabase {
    public abstract NoteDao getNoteDao();

    private static NoteDatabase noteDatabase;

    public static NoteDatabase getInstance(Context context){
        if (noteDatabase == null){
            noteDatabase = buildDatabaseInstance(context);
        }
        return noteDatabase;
    }

    private static NoteDatabase buildDatabaseInstance(Context context){
        return Room.databaseBuilder(context, NoteDatabase.class, Constants.DB_NAME)
                .allowMainThreadQueries().build();

    }

    public void cleanUp(){
        noteDatabase = null;
    }

}
