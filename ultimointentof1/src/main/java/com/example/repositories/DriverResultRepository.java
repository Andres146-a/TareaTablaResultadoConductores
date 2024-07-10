package com.example.repositories;

import com.example.models.DriverResult;
import com.example.DataBaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DriverResultRepository {

    public List<DriverResult> getDriverResultsByYear(int year) {
        List<DriverResult> results = new ArrayList<>();
        List<Integer> raceIds = getRaceIdsByYear(year);

        for (Integer raceId : raceIds) {
            results.addAll(getDriverResultsByRaceId(raceId));
        }

        return results;
    }

    private List<Integer> getRaceIdsByYear(int year) {
        List<Integer> raceIds = new ArrayList<>();
        String query = "SELECT raceId FROM races WHERE year = ?";

        try (Connection conn = DataBaseConnection.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, year);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                raceIds.add(rs.getInt("raceId"));
            }
            System.out.println("Carreras obtenidas para el año " + year + ": " + raceIds.size() + " - " + raceIds);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return raceIds;
    }

    private List<DriverResult> getDriverResultsByRaceId(int raceId) {
        List<DriverResult> results = new ArrayList<>();

        String query = "SELECT d.forename, d.surname, ds.wins, ds.points, ds.position " +
                       "FROM drivers d " +
                       "JOIN driverstandings ds ON d.driverId = ds.driverId " +
                       "WHERE ds.raceId = ?";

        try (Connection conn = DataBaseConnection.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, raceId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                DriverResult result = new DriverResult();
                result.setForename(rs.getString("forename"));
                result.setSurname(rs.getString("surname"));
                result.setWins(rs.getInt("wins"));
                result.setTotalPoints(rs.getFloat("points"));
                result.setSeasonRank(rs.getInt("position"));
                results.add(result);
            }

            System.out.println("Resultados obtenidos para raceId " + raceId + ": " + results.size());
            if (results.size() == 0) {
                System.out.println("No results found for raceId: " + raceId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return results;
    }
}
