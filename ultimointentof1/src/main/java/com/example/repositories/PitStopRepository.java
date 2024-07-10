package com.example.repositories;

import com.example.models.pitStop;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PitStopRepository {
    
    String jdbcUrl = "jdbc:mysql://localhost:3306/proyectof1dbclase2";
    String user = "root";
    String password = "Admi1234";

    public List<pitStop> getPitStops(){
        
        List<pitStop> pitStops = new ArrayList<pitStop>();
        
        try {
            // Establecer la conexión
            Connection conn = DriverManager.getConnection(jdbcUrl, user, password);
            
            // Crear una sentencia
            Statement statement = conn.createStatement();
            
            // Ejecutar la consulta
            String sql = "SELECT * FROM pitStops";
            ResultSet rs = statement.executeQuery(sql);
            
            // Procesar los resultados
            while(rs.next()) {
                int raceId = rs.getInt("raceId");
                int driverId = rs.getInt("driverId");
                int stop = rs.getInt("stop");
                int lap = rs.getInt("lap");
                String time = rs.getString("time");
                String duration = rs.getString("duration");
                float milliseconds = rs.getFloat("milliseconds");
                
                pitStop pitStop = new pitStop(raceId, driverId, stop, lap, time, duration, milliseconds);
                pitStops.add(pitStop);
            }
            
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        
        return pitStops;
    }
}
