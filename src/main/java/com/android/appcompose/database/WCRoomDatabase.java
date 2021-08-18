package com.android.appcompose.database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {UserClassroom.class}, version = 1, exportSchema = false)
public abstract  class WCRoomDatabase extends RoomDatabase {
    public abstract UserClassroomDao userClassroomDao();
    private static volatile WCRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);


    public  static WCRoomDatabase  getDatabase(final Context context){
        if(INSTANCE==null){
            synchronized (WCRoomDatabase.class){
                if(INSTANCE==null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), WCRoomDatabase.class, "wc_database")
                            .addCallback(sWCDatabaseCallback)
                           // .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static  RoomDatabase.Callback sWCDatabaseCallback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            databaseWriteExecutor.execute(()->{
                UserClassroomDao dao = INSTANCE.userClassroomDao();
                dao.deleteAll();
                UserClassroom uc = new UserClassroom(1, "name","chash", "admiin", "data", "members", "String invites", true, 123456, 1234567);
                dao.insert(uc);
            });
        }
    };
}
