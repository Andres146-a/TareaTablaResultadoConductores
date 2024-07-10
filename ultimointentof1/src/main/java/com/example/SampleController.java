package com.example;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import com.example.models.DriverResult;
import com.example.repositories.DriverResultRepository;

import java.util.List;

public class SampleController {

    @FXML
    private ComboBox<Integer> yearComboBox;

    @FXML
    private TableView<DriverResult> driverTable;

    @FXML
    private TableColumn<DriverResult, String> forenameColumn;

    @FXML
    private TableColumn<DriverResult, String> surnameColumn;

    @FXML
    private TableColumn<DriverResult, Integer> winsColumn;

    @FXML
    private TableColumn<DriverResult, Integer> totalPointsColumn;

    @FXML
    private TableColumn<DriverResult, Integer> seasonRankColumn;

    private DriverResultRepository repository;

    @FXML
    public void initialize() {
        yearComboBox.setItems(FXCollections.observableArrayList(
            1950, 1951, 1952, 1953, 1954, 1955, 1956, 1957, 1958, 1959,
            1960, 1961, 1962, 1963, 1964, 1965, 1966, 1967, 1968, 1969,
            1970, 1971, 1972, 1973, 1974, 1975, 1976, 1977, 1978, 1979,
            1980, 1981, 1982, 1983, 1984, 1985, 1986, 1987, 1988, 1989,
            1990, 1991, 1992, 1993, 1994, 1995, 1996, 1997, 1998, 1999,
            2000, 2001, 2002, 2003, 2004, 2005, 2006, 2007, 2008, 2009,
            2010, 2011, 2012, 2013, 2014, 2015, 2016, 2017, 2018, 2019,
            2020, 2021, 2022, 2023
        ));
        forenameColumn.setCellValueFactory(new PropertyValueFactory<>("forename"));
        surnameColumn.setCellValueFactory(new PropertyValueFactory<>("surname"));
        winsColumn.setCellValueFactory(new PropertyValueFactory<>("wins"));
        totalPointsColumn.setCellValueFactory(new PropertyValueFactory<>("totalPoints"));
        seasonRankColumn.setCellValueFactory(new PropertyValueFactory<>("seasonRank"));

        repository = new DriverResultRepository();
    }

    @FXML
    private void onYearSelected() {
        Integer selectedYear = yearComboBox.getValue();
        if (selectedYear != null) {
            List<DriverResult> driverResults = repository.getDriverResultsByYear(selectedYear);
            System.out.println("Resultados obtenidos para el año " + selectedYear + ": " + driverResults.size());
            driverTable.setItems(FXCollections.observableArrayList(driverResults));
        }
    }
}
