package com.example.repositories;

import com.example.models.Circuit;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class CircuitRepository {
    
    String jdbcUrl = "jdbc:mysql://localhost:3306/proyectof1dbclase2";
    String user = "root";
    String password = "Admi1234";

    public void nuevoCircuito(Circuit circuit) {
        // lógica de ingreso a base de datos
        // insert into circuits......
    }
    
    public List<Circuit> getCircuitsByCountry(String countryParam){
        
        List<Circuit> circuits = new ArrayList<Circuit>();
        
        try {
            // Establecer la conexión
            Connection conn = DriverManager.getConnection(jdbcUrl, user, password);
            
            // Crear una sentencia
            Statement statement = conn.createStatement();
            
            // Ejecutar la consulta
            String sql = "select * from circuits where country = '" + countryParam + "'";
            ResultSet rs = statement.executeQuery(sql);
            
            // Procesar los resultados
            while(rs.next()) {
                int circuitid = rs.getInt("circuitid");
                String circuitref = rs.getString("circuitref");
                String name = rs.getString("name");
                String location = rs.getString("location");
                String country = rs.getString("country");
                
                Circuit circuit = new Circuit(circuitid, circuitref, name, location, country);
                circuits.add(circuit);
            }
            
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        
        return circuits;
    }
    
    public List<Circuit> getCircuits(){
        
        List<Circuit> circuits = new ArrayList<Circuit>();
        
        try {
            // Establecer la conexión
            Connection conn = DriverManager.getConnection(jdbcUrl, user, password);
            System.out.println("Se conectó a la base de datos");
            
            // Crear una sentencia
            Statement statement = conn.createStatement();
            
            // Ejecutar la consulta
            String sql = "SELECT * FROM circuits";
            ResultSet rs = statement.executeQuery(sql);
            
            // Procesar los resultados
            while(rs.next()) {
                int circuitid = rs.getInt("circuitid");
                String circuitref = rs.getString("circuitref");
                String name = rs.getString("name");
                String location = rs.getString("location");
                String country = rs.getString("country");
                
                Circuit circuit = new Circuit(circuitid, circuitref, name, location, country);
                circuits.add(circuit);
            }
            
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        
        return circuits;
    }
}
