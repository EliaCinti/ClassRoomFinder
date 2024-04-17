package it.adegroups.classroomfinder.view;

import it.adegroups.classroomfinder.bean.ClassRoomBean;
import it.adegroups.classroomfinder.controller.ClassRoomController;
import it.adegroups.classroomfinder.model.DaysOfWeek;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClassRoomCLIView {
    public void uploadTimetablesForClass() {
        ClassRoomController controller = new ClassRoomController();
        List<LocalTime> localTimes = new ArrayList<>();
        localTimes.add(LocalTime.of(9,30));
        localTimes.add(LocalTime.of(11,30));
        localTimes.add(LocalTime.of(14,0));
        localTimes.add(LocalTime.of(16,0));
        boolean repeat = true;
        while (repeat) {
            List<ClassRoomBean> classRoomBeanList = new ArrayList<>();
            String className = getClassName();
            for (DaysOfWeek day : DaysOfWeek.values()) {
                for (LocalTime localTime : localTimes) {
                    printMessage(day.name() + " " + localTime.format(DateTimeFormatter.ofPattern("hh:mm")));
                    classRoomBeanList.add(new ClassRoomBean(className, day, getLecture(), localTime));
                }
            }
            controller.loadClassRoom(classRoomBeanList);
            printField("do you want continue?");
            repeat = getLecture();
        }
    }

    private String getClassName() {
        Scanner scanner = new Scanner(System.in);
        printField("Class name");
        return scanner.nextLine();
    }
    private void printField(String field) {
        System.out.print(field + ": ");
    }
    private void printMessage(String message) {
        System.out.println(message);
    }
    private boolean getLecture() {
        Scanner scanner = new Scanner(System.in);
        printField("press t for true or f for false");
        if (scanner.nextLine().equals("t")) {
            return true;
        } else {
            return false;
        }
    }
}
