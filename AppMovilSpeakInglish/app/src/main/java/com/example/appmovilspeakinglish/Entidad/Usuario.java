package com.example.appmovilspeakinglish.Entidad;

import java.io.Serializable;

public class Usuario implements Serializable {
    int cod;
    String nombre,correo,usuario,password,dni,telefono;

    public Usuario(){

    }
    public boolean isNull(){
        if(usuario.equals("")&&password.equals("")&&nombre.equals("")&&dni.equals("")&&telefono.equals("")&&correo.equals("")){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public String toString(){
        return "Usuario{"+
                "Cod=" + cod+
                ",Nombre='" + nombre + '\'' +
                ",Dni='" + dni + '\'' +
                ",Telefono='" + telefono + '\'' +
                ",Correo='" + correo + '\'' +
                ",Usuario='" + usuario + '\'' +
                ",Password='" + password + '\'' +
                '}';
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
