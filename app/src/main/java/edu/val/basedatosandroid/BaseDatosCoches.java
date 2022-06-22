package edu.val.basedatosandroid;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.List;

public class BaseDatosCoches extends SQLiteOpenHelper {

    private static final String SQL_CREAR_TABLA_PERSONAS = "CREATE TABLE PERSONA (id INTEGER PRIMARY KEY, nombre TEXT)";
    private static final String SQL_CREAR_TABLA_COCHES = "CREATE TABLE COCHE (id INTEGER PRIMARY KEY AUTOINCREMENT, modelo TEXT, idpersona INTEGER, FOREIGN KEY (idpersona) REFERENCES PERSONA (id))";


    public BaseDatosCoches(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //incluir las instrucciones para crear las tablas
        //IMPORTANTE EL ORDEN
        sqLiteDatabase.execSQL(SQL_CREAR_TABLA_PERSONAS);
        sqLiteDatabase.execSQL(SQL_CREAR_TABLA_COCHES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //1 leer los datos de las tablas
        //2 crear las nuevas tablas
        //3 escribir los datos del paso 1
    }

    //insertarPersona
    public void insertarPersona (Persona persona)
    {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase(); //INSERT INTO PERSONA (id, nombre) VALUES (3, 'JAVI');
        //importante: AL INTRODUCIR EL VALOR DE UNA COLUMNA TIPO TEXT, (STRING), TIENE QUE ENTRE COMILLAS SIMPLES
        String instruccion_sql_inertar_persona = "INSERT INTO PERSONA (id, nombre) VALUES ("+persona.getId()+", '"+persona.getNombre()+"')";
        Log.d("ETIQUETA_LOG", "INSERTANDO persona = " + instruccion_sql_inertar_persona);
        sqLiteDatabase.execSQL(instruccion_sql_inertar_persona);
        cerrarBaseDatos(sqLiteDatabase);
    }

    //insertarCoche
    public void insertarCoche (Coche coche)
    {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        String instruccion_sql_insertar_coche = "INSERT INTO COCHE (modelo, idpersona) VALUES ('"+coche.getModelo()+"', "+coche.getPersona().getId()+")";
        Log.d("ETIQUETA_LOG", "INSERTANDO coche = " + instruccion_sql_insertar_coche);
        sqLiteDatabase.execSQL(instruccion_sql_insertar_coche);
        cerrarBaseDatos(sqLiteDatabase);
    }

    //cerrarBaseDatos

    private void cerrarBaseDatos (SQLiteDatabase sqLiteDatabase)
    {
        sqLiteDatabase.close();
    }

    ////obtenerCochesPersona SELECT - leer
    public List<Coche> obtenerCochesPersona (Persona persona)
    {
        List<Coche> lista_coches = null;

            //TODO leer los coches de la persona que me pasan

        return lista_coches;

    }

}
