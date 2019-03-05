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
        insertCourse("AM1", "Analisis Matematico 1");
        insertCourse("LS", "Logica Simbolica");
        insertCourse("TG", "Teoria de Grafos");
        insertCourse("IT1", "Ingles Tecnico 1");
        insertCourse("AM2", "Analisis Matematico 2");
        insertCourse("AE1", "Algoritmos y Estructura de Datos 1");
        insertCourse("AC1", "Arquitectura de las Computadoras 1");
        insertCourse("TP2", "Taller de Programacion 2");
        insertCourse("IT2", "Ingles Tecnico 2");
        insertCourse("AE2", "Algoritmo y Estructura de Datos 2");
        insertCourse("DOO", "Diseno Orientado a Objetos");
        insertCourse("BD", "Bases de Datos");
        insertCourse("PyE", "Probabilidad y Estadistica");
        insertCourse("AC2", "Arquitectura de las Computadoras 2");
        insertCourse("SO", "Sistemas Operativos");
        insertCourse("RC1", "Redes de Computadoras 1");
        insertCourse("TP3", "Taller de Programacion 3");
        insertCourse("TL", "Teoria de Lenguajes");
        insertCourse("SI", "Seguridad Informatica");
        insertCourse("RC2", "Redes de Computadoras 2");
        insertCourse("IS1", "Ingenieria del Software 1");
        insertCourse("TP4", "Taller de Programacion 4");
        insertCourse("IS2", "Ingenieria del Software 2");
        insertCourse("PP", "Programacion Profesional");
        insertCourse("GO", "Gestion de las Organizaciones");
        insertCourse("S1N", "Seminario 1 .NET");
        insertCourse("S2A", "Seminario 2 Android");
        insertCourse("S3L", "Seminario 3 Linux Embebido");

    }

    public void insertSampleNotes() {
        insertNote("TP1", "C", "C es el lenguaje de programacion que sera utilizado en la materia");
        insertNote("AC2", "Pipeline", "Optimizacion para la ejecucion de las instrucciones en un procesador");
        insertNote("RC2", "UDP", "Protocolo IP basado en datagramas no orientado a conexion y no fiable");
        insertNote("IS2", "Proyecto Final", "El proyecto final consiste en realizar el relevamiento, diseno e implementacion de un software de facturacion");
        insertNote("BD", "Normalizacion", "Proceso por el cual se realiza un modelo de datos para cumplir con las formas normales");

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
