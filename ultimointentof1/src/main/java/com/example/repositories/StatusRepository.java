package com.example.repositories;

import com.example.models.Status;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StatusRepository {
    
    String jdbcUrl = "jdbc:mysql://localhost:3306/proyectof1dbclase2";
    String user = "root";
    String password = "Admi1234";


    public List<Status> getStatuses(){
        
        List<Status> statuses = new ArrayList<Status>();
        
        try {
            // Establecer la conexión
            Connection conn = DriverManager.getConnection(jdbcUrl, user, password);
            
            // Crear una sentencia
            Statement statement = conn.createStatement();
            
            // Ejecutar la consulta
            String sql = "SELECT * FROM status";
            ResultSet rs = statement.executeQuery(sql);
            
            // Procesar los resultados
            while(rs.next()) {
                int statusId = rs.getInt("statusId");
                String status = rs.getString("status");
                
                Status statusRecord = new Status(statusId, status);
                statuses.add(statusRecord);
            }
            
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        
        return statuses;
    }
}
