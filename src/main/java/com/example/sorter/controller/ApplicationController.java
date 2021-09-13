package com.example.sorter.controller;

import com.example.sorter.model.Student;
import com.example.sorter.parser.factory.StudentParserFactory;
import com.example.sorter.service.sorting.factory.SortFactory;
import com.example.sorter.service.sorting.factory.SortingServiceFactory;
import com.example.sorter.writer.factory.StudentWriterFactory;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import lombok.Setter;

import java.io.File;
import java.util.Arrays;

public class ApplicationController {

    private final File initialUserDirectory = new File(System.getProperty("user.dir"));

    @FXML
    public ComboBox<String> sortingAlgsComboBox;
    @FXML
    public TableView<Student> resultTable;
    @FXML
    public Button saveToFile;

    @Setter
    private Stage parentStage;
    private Student[] students;

    public void fileOpen() {
        final FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(initialUserDirectory);
        File f = fileChooser.showOpenDialog(parentStage);
        if (f != null) {
            final String[] fileNameAttrs = f.getName().split("\\.");
            students = StudentParserFactory.createParser(fileNameAttrs[fileNameAttrs.length - 1])
                    .parseStudents(f)
                    .toArray(new Student[0]);
        }
    }

    public void sortStudents() {
        final String sortingAlg = sortingAlgsComboBox.getSelectionModel().getSelectedItem();
        SortingServiceFactory.createSortingService(Student.class, "performance")
                .sort(students, SortFactory.getInstance().createSort(sortingAlg));

        final TableColumn<Student, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        resultTable.getColumns().add(nameColumn);

        final TableColumn<Student, Integer> performanceColumn = new TableColumn<>("Performance");
        performanceColumn.setCellValueFactory(new PropertyValueFactory<>("performance"));
        resultTable.getColumns().add(performanceColumn);

        resultTable.setItems(FXCollections.observableList(Arrays.asList(students)));
        resultTable.setVisible(true);
        saveToFile.setVisible(true);
    }

    public void saveResults() {
        final FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(initialUserDirectory);
        fileChooser.getExtensionFilters()
                .add(new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt"));
        File f = fileChooser.showSaveDialog(parentStage);
        if (f != null) {
            final String[] fileNameAttrs = f.getName().split("\\.");
            StudentWriterFactory.createWriter(fileNameAttrs[fileNameAttrs.length - 1])
                    .writeToFile(f, students);
        }
    }
}
