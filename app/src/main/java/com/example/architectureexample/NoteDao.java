package com.example.architectureexample;

import androidx.room.Dao;

@Dao
public interface NoteDao {

    @insert
    void insert(Note note);

    @update
    void update(Note note);

    @delete
    void delete(Note note);

    @Query("DELETE FROM note_table")
    void deleteAllNotes();

    @Query("SELECT * FROM note_table ORDER BY priority DESC")
    LiveData<List<Note>> getAllNotes();


}
