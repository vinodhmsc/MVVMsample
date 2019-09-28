package com.vinodh.mvvmsample;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Created by VINODH KUMAR on 14-09-2019.
 */
@Entity(tableName = "note_table")
public class Note {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private String description;
    private int priority;

    public Note(String name, String description, int priority) {
        this.name = name;
        this.description = description;
        this.priority = priority;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }

}
