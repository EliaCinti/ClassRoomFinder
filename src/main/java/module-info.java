module it.adegroups.classroomfinder {
    requires javafx.controls;
    requires javafx.fxml;


    opens it.adegroups.classroomfinder to javafx.fxml;
    exports it.adegroups.classroomfinder;
}