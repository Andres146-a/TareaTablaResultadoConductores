package com.example.repositories;

import com.example.models.Race;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RaceRepository {
    
    String jdbcUrl = "jdbc:mysql://localhost:3306/proyectof1dbclase2";
    String user = "root";
    String password = "Admi1234";

    public List<Race> getRaces(){
        
        List<Race> races = new ArrayList<Race>();
        
        try {
            // Establecer la conexión
            Connection conn = DriverManager.getConnection(jdbcUrl, user, password);
            
            // Crear una sentencia
            Statement statement = conn.createStatement();
            
            // Ejecutar la consulta
            String sql = "SELECT * FROM races";
            ResultSet rs = statement.executeQuery(sql);
            
            // Procesar los resultados
            while(rs.next()) {
                int raceId = rs.getInt("raceId");
                int year = rs.getInt("year");
                int round = rs.getInt("round");
                int circuitId = rs.getInt("circuitId");
                String name = rs.getString("name");
                String date = rs.getString("date");
                String time = rs.getString("time");
                String url = rs.getString("url");
                
                Race race = new Race(raceId, year, round, circuitId, name, date, time, url);
                races.add(race);
            }
            
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        
        return races;
    }
}
