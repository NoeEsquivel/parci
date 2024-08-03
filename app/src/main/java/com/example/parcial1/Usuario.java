package com.example.parcial1;

public class Usuario {

    private Integer codigo;
    private String nombre;
    private String categoria;
    private String prerequisito;
    private String primarykey;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getPrerequisito() {
        return prerequisito;
    }

    public void setPrerequisito(String prerequisito) {
        this.prerequisito = prerequisito;
    }

    public String getPrimarykey() {
        return primarykey;
    }

    public void setPrimarykey(String primarykey) {
        this.primarykey = primarykey;
    }

    public Usuario() {
        this.codigo = codigo;
        this.nombre = nombre;
        this.categoria = categoria;
        this.prerequisito = prerequisito;
        this.primarykey = primarykey;


    }
}