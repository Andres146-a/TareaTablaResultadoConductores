package com.example.repositories;

import com.example.models.Result;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ResultRepository {
    
    String jdbcUrl = "jdbc:mysql://localhost:3306/proyectof1dbclase2";
    String user = "root";
    String password = "Admi1234";


    public List<Result> getResults(){
        
        List<Result> results = new ArrayList<Result>();
        
        try {
            // Establecer la conexión
            Connection conn = DriverManager.getConnection(jdbcUrl, user, password);
            
            // Crear una sentencia
            Statement statement = conn.createStatement();
            
            // Ejecutar la consulta
            String sql = "SELECT * FROM results";
            ResultSet rs = statement.executeQuery(sql);
            
            // Procesar los resultados
            while(rs.next()) {
                int resultId = rs.getInt("resultId");
                int raceId = rs.getInt("raceId");
                int driverId = rs.getInt("driverId");
                int constructorId = rs.getInt("constructorId");
                int number = rs.getInt("number");
                int grid = rs.getInt("grid");
                int position = rs.getInt("position");
                String positionText = rs.getString("positionText");
                int positionOrder = rs.getInt("positionOrder");
                float points = rs.getFloat("points");
                int laps = rs.getInt("laps");
                String time = rs.getString("time");
                int milliseconds = rs.getInt("milliseconds");
                int fastestLap = rs.getInt("fastestLap");
                int rank = rs.getInt("rank");
                String fastestLapTime = rs.getString("fastestLapTime");
                int fastestLapSpeed = rs.getInt("fastestLapSpeed");
                String statusId = rs.getString("statusId");
                
                Result result = new Result(resultId, raceId, driverId, constructorId, number, grid, position, positionText, positionOrder, points, laps, time, milliseconds, fastestLap, rank, fastestLapTime, fastestLapSpeed, statusId);
                results.add(result);
            }
            
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        
        return results;
    }
}
