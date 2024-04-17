package it.adegroups.classroomfinder;

import it.adegroups.classroomfinder.view.ClassRoomCLIView;

public class Main {
    public static void main(String[] args) {
        ClassRoomCLIView view = new ClassRoomCLIView();
        view.uploadTimetablesForClass();
    }
}
