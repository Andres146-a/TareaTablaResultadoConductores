package com.example.repositories;

import com.example.models.Season;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SeasonRepository {
    
    String jdbcUrl = "jdbc:mysql://localhost:3306/proyectof1dbclase2";
    String user = "root";
    String password = "Admi1234";


    
    public List<Season> getSeasons(){
        
        List<Season> seasons = new ArrayList<Season>();
        
        try {
            // Establecer la conexión
            Connection conn = DriverManager.getConnection(jdbcUrl, user, password);
            
            // Crear una sentencia
            Statement statement = conn.createStatement();
            
            // Ejecutar la consulta
            String sql = "select * from seasons";
            ResultSet rs = statement.executeQuery(sql);
            
            // Procesar los resultados
            while(rs.next()) {
                int year = rs.getInt("year");
                
                Season season = new Season(year);
                seasons.add(season);
            }
            
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        
        return seasons;
    }
}
