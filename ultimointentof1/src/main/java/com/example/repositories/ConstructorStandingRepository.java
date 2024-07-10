package com.example.repositories;

import com.example.models.ConstructorStanding;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ConstructorStandingRepository {
    
    String jdbcUrl = "jdbc:mysql://localhost:3306/proyectof1dbclase2";
    String user = "root";
    String password = "Admi1234";

    public List<ConstructorStanding> getConstructorStandings(){
        
        List<ConstructorStanding> constructorStandings = new ArrayList<ConstructorStanding>();
        
        try {
            // Establecer la conexión
            Connection conn = DriverManager.getConnection(jdbcUrl, user, password);
            
            // Crear una sentencia
            Statement statement = conn.createStatement();
            
            // Ejecutar la consulta
            String sql = "SELECT * FROM constructorStandings";
            ResultSet rs = statement.executeQuery(sql);
            
            // Procesar los resultados
            while(rs.next()) {
                int constructorStandingsId = rs.getInt("constructorStandingsId");
                int raceId = rs.getInt("raceId");
                int constructorId = rs.getInt("constructorId");
                float points = rs.getFloat("points");
                int position = rs.getInt("position");
                String positionText = rs.getString("positionText");
                int wins = rs.getInt("wins");
                
                ConstructorStanding constructorStanding = new ConstructorStanding(constructorStandingsId, raceId, constructorId, points, position, positionText, wins);
                constructorStandings.add(constructorStanding);
            }
            
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        
        return constructorStandings;
    }
}
