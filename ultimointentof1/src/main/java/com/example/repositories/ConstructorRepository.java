package com.example.repositories;

import com.example.models.Constructor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ConstructorRepository {
    
    String jdbcUrl = "jdbc:mysql://localhost:3306/proyectof1dbclase2";
    String user = "root";
    String password = "Admi1234";

    public List<Constructor> getConstructors(){
        
        List<Constructor> constructors = new ArrayList<Constructor>();
        
        try {
            // Establecer la conexión
            Connection conn = DriverManager.getConnection(jdbcUrl, user, password);
            
            // Crear una sentencia
            Statement statement = conn.createStatement();
            
            // Ejecutar la consulta
            String sql = "SELECT * FROM constructors";
            ResultSet rs = statement.executeQuery(sql);
            
            // Procesar los resultados
            while(rs.next()) {
                int constructorId = rs.getInt("constructorId");
                String constructorRef = rs.getString("constructorRef");
                String name = rs.getString("name");
                String nationality = rs.getString("nationality");
                String url = rs.getString("url");
                
                Constructor constructor = new Constructor(constructorId, constructorRef, name, nationality, url);
                constructors.add(constructor);
            }
            
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        
        return constructors;
    }
}
