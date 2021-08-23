package com.android.appcompose.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.android.appcompose.database.model.ClassroomModel;

import java.util.List;

@Dao
public interface ClassroomDao {
    // allowing the insert of the same classroom multiple times by passing a
    // conflict resolution strategy
    @Insert(onConflict = OnConflictStrategy.IGNORE)
     void  insert(ClassroomModel classroom);

    @Query("DELETE from classrooms")
    void deleteAll();

    @Query("SELECT * FROM classrooms ORDER BY name")
    LiveData<List<ClassroomModel>> getAllClassrooms();
}
