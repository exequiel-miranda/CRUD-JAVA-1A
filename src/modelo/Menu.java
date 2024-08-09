package modelo;

import java.sql.*;
import java.util.UUID;

public class Menu {
    //1- Parametros
    String UUID_menu;
    String nombre;
    double precio;
    String ingredientes;
    
    //2- Getters y Setters

    public String getUUID_menu() {
        return UUID_menu;
    }

    public void setUUID_menu(String UUID_menu) {
        this.UUID_menu = UUID_menu;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }
   
    //3- Métodos (select, insert, update, delete)
    
    //Ingresar
    public void Guardar() {
        //Creamos una variable igual a ejecutar el método de la clase de conexión
        Connection conexion = ClaseConexion.getConexion();
        try {
            //Creamos el PreparedStatement que ejecutará la Query
            PreparedStatement addMenu = conexion.prepareStatement("INSERT INTO tbMenu(UUID_menu, nombre, precio, ingredientes) VALUES (?, ?, ?, ?)");
            //Establecer valores de la consulta SQL
            addMenu.setString(1, UUID.randomUUID().toString());
            addMenu.setString(2, getNombre());
            addMenu.setDouble(3, getPrecio());
            addMenu.setString(4, getIngredientes());
 
            //Ejecutar la consulta
            addMenu.executeUpdate();
 
        } catch (SQLException ex) {
            System.out.println("este es el error en el modelo:metodo guardar " + ex);
        }
    }
     
    
}
