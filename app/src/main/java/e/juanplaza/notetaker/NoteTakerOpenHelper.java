package e.juanplaza.notetaker;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class NoteTakerOpenHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "NoteTaker.db";
    public static final int DATABASE_VERSION = 1;

    public NoteTakerOpenHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(NoteTakerDatabaseContract.CourseInfoEntry.SQL_CREATE_TABLE);
        db.execSQL(NoteTakerDatabaseContract.NoteInfoEntry.SQL_CREATE_TABLE);

        DatabaseDataWorker worker = new DatabaseDataWorker(db);
        worker.insertCourses();
        worker.insertSampleNotes();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
