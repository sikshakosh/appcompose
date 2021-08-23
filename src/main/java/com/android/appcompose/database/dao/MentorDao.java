package com.android.appcompose.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.android.appcompose.database.model.ClassroomModel;
import com.android.appcompose.database.model.MentorModel;

import java.util.List;

@Dao
public interface MentorDao {
    // allowing the insert of the same classroom multiple times by passing a
    // conflict resolution strategy
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void  insert(MentorModel classroom);

    @Query("DELETE from mentors")
    void deleteAll();

    @Query("SELECT * FROM mentors ORDER BY name")
    LiveData<List<MentorModel>> getAllMentors();
}
