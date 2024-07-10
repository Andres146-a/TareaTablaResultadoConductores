package com.example.repositories;

import com.example.models.Lap;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LapRepository {
    
    String jdbcUrl = "jdbc:mysql://localhost:3306/proyectof1dbclase2";
    String user = "root";
    String password = "Admi1234";


    public List<Lap> getLaps(){
        
        List<Lap> laps = new ArrayList<Lap>();
        
        try {
            // Establecer la conexión
            Connection conn = DriverManager.getConnection(jdbcUrl, user, password);
            
            // Crear una sentencia
            Statement statement = conn.createStatement();
            
            // Ejecutar la consulta
            String sql = "SELECT * FROM laps";
            ResultSet rs = statement.executeQuery(sql);
            
            // Procesar los resultados
            while(rs.next()) {
                int raceId = rs.getInt("raceId");
                int driverId = rs.getInt("driverId");
                int lap = rs.getInt("lap");
                int position = rs.getInt("position");
                String time = rs.getString("time");
                float milliseconds = rs.getFloat("milliseconds");
                
                Lap lapRecord = new Lap(raceId, driverId, lap, position, time, milliseconds);
                laps.add(lapRecord);
            }
            
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        
        return laps;
    }
}
