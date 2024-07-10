package com.example.repositories;

import com.example.models.ConstructorResult;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ConstructorResultRepository {
    
    String jdbcUrl = "jdbc:mysql://localhost:3306/proyectof1dbclase2";
    String user = "root";
    String password = "Admi1234";

    public List<ConstructorResult> getConstructorResults(){
        
        List<ConstructorResult> constructorResults = new ArrayList<ConstructorResult>();
        
        try {
            // Establecer la conexión
            Connection conn = DriverManager.getConnection(jdbcUrl, user, password);
            
            // Crear una sentencia
            Statement statement = conn.createStatement();
            
            // Ejecutar la consulta
            String sql = "SELECT * FROM constructorResults";
            ResultSet rs = statement.executeQuery(sql);
            
            // Procesar los resultados
            while(rs.next()) {
                int constructorResultsId = rs.getInt("constructorResultsId");
                int raceId = rs.getInt("raceId");
                int constructorId = rs.getInt("constructorId");
                float points = rs.getFloat("points");
                
                
                ConstructorResult constructorResult = new ConstructorResult(constructorResultsId, raceId, constructorId, points);
                constructorResults.add(constructorResult);
            }
            
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        
        return constructorResults;
    }
}
