package com.example.repositories;

import com.example.models.Qualifying;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class QualifyingRepository {
    
    String jdbcUrl = "jdbc:mysql://localhost:3306/proyectof1dbclase2";
    String user = "root";
    String password = "Admi1234";


    public List<Qualifying> getQualifyingSessions(){
        
        List<Qualifying> qualifyingSessions = new ArrayList<Qualifying>();
        
        try {
            // Establecer la conexión
            Connection conn = DriverManager.getConnection(jdbcUrl, user, password);
            
            // Crear una sentencia
            Statement statement = conn.createStatement();
            
            // Ejecutar la consulta
            String sql = "SELECT * FROM qualifying";
            ResultSet rs = statement.executeQuery(sql);
            
            // Procesar los resultados
            while(rs.next()) {
                int qualifyId = rs.getInt("qualifyId");
                int raceId = rs.getInt("raceId");
                int driverId = rs.getInt("driverId");
                int constructorId = rs.getInt("constructorId");
                int number = rs.getInt("number");
                int position = rs.getInt("position");
                String q1 = rs.getString("q1");
                String q2 = rs.getString("q2");
                String q3 = rs.getString("q3");
                
                Qualifying qualifying = new Qualifying(qualifyId, raceId, driverId, constructorId, number, position, q1, q2, q3);
                qualifyingSessions.add(qualifying);
            }
            
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        
        return qualifyingSessions;
    }
}
