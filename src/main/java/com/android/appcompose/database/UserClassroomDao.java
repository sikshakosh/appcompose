package com.android.appcompose.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserClassroomDao {
    // allowing the insert of the same classroom multiple times by passing a
    // conflict resolution strategy
    @Insert(onConflict = OnConflictStrategy.IGNORE)
     void  insert(UserClassroom classroom);

    @Query("DELETE from user_classroom")
    void deleteAll();

    @Query("SELECT * FROM user_classroom ORDER BY name")
    LiveData<List<UserClassroom>> getAllClassrooms();
}
