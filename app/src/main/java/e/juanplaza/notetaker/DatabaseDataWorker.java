package e.juanplaza.notetaker;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Juan.
 */

public class DatabaseDataWorker {
    private SQLiteDatabase mDb;

    public DatabaseDataWorker(SQLiteDatabase db) {
        mDb = db;
    }

    public void insertCourses() {
        insertCourse("TP1", "Taller de Programacion 1");
        insertCourse("M1", "Matematica 1");
        insertCourse("LS", "Logica Simbolica");
        insertCourse("TG", "Teoria de Grafos");
    }

    public void insertSampleNotes() {
        insertNote("TP1", "Punteros", "Los punteros son la forma de referenciar en memoria");
        insertNote("TP1", "C", "C es el lenguaje de programacion utilizado en la materia");

        insertNote("TG", "Grafo Dirigido", "Grafo en el cual los aristas deben ser recorridos en un solo sentido");
        insertNote("TG", "Dijkstra", "Algoritmo de menor recorrido de grafos con peso en las arista");
    }

    private void insertCourse(String courseId, String title) {
        ContentValues values = new ContentValues();
        values.put(NoteTakerDatabaseContract.CourseInfoEntry.COLUMN_COURSE_ID, courseId);
        values.put(NoteTakerDatabaseContract.CourseInfoEntry.COLUMN_COURSE_TITLE, title);

        long newRowId = mDb.insert(NoteTakerDatabaseContract.CourseInfoEntry.TABLE_NAME, null, values);
    }

     private void insertNote(String courseId, String title, String text) {
        ContentValues values = new ContentValues();
        values.put(NoteTakerDatabaseContract.NoteInfoEntry.COLUMN_COURSE_ID, courseId);
        values.put(NoteTakerDatabaseContract.NoteInfoEntry.COLUMN_NOTE_TITLE, title);
        values.put(NoteTakerDatabaseContract.NoteInfoEntry.COLUMN_NOTE_TEXT, text);

        long newRowId = mDb.insert(NoteTakerDatabaseContract.NoteInfoEntry.TABLE_NAME, null, values);
    }

}
