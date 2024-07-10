package com.example.repositories;

import com.example.models.DriverStanding;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DriverStandingRepository {
    
    String jdbcUrl = "jdbc:mysql://localhost:3306/proyectof1dbclase2";
    String user = "root";
    String password = "Admi1234";


    public List<DriverStanding> getDriverStandings(){
        
        List<DriverStanding> driverStandings = new ArrayList<DriverStanding>();
        
        try {
            // Establecer la conexión
            Connection conn = DriverManager.getConnection(jdbcUrl, user, password);
            
            // Crear una sentencia
            Statement statement = conn.createStatement();
            
            // Ejecutar la consulta
            String sql = "SELECT * FROM driver_standings";
            ResultSet rs = statement.executeQuery(sql);
            
            // Procesar los resultados
            while(rs.next()) {
                int driverStandingId = rs.getInt("driverStandingId");
                int raceId = rs.getInt("raceId");
                int driverId = rs.getInt("driverId");
                int points = rs.getInt("points");
                int position = rs.getInt("position");
                String positionText = rs.getString("positionText");
                int wins = rs.getInt("wins");
                
                DriverStanding driverStanding = new DriverStanding(driverStandingId, raceId, driverId, points, position, positionText, wins);
                driverStandings.add(driverStanding);
            }
            
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        
        return driverStandings;
    }
}
