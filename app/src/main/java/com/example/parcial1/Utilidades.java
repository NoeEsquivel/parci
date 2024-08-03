package com.example.parcial1;


public class Utilidades {

    public static String TABLA_USUARIO="usuario";
    public static String CAMPO_CODIGO="codigo";
    public static String CAMPO_NOMBRE="nombre";
    public static String CAMPO_CATEGORIA="categoria";
    public static String CAMPO_PREREQUISITO="prerequisito";
    public static String CAMPO_PRIMARYKEY="PrimaryKey";

    public static final String CREAR_TABLA_USUARIO="CREATE TABLE "+TABLA_USUARIO+" ("+CAMPO_CODIGO+" INTEGER," +
            " "+CAMPO_NOMBRE+" TEXT, "+CAMPO_CATEGORIA+" TEXT, "+CAMPO_PREREQUISITO+" TEXT, "+CAMPO_PRIMARYKEY+" TEXT)";

}
