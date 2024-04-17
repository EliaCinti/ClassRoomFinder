package it.adegroups.classroomfinder.dao;

import com.opencsv.exceptions.CsvException;
import it.adegroups.classroomfinder.bean.ClassRoomBean;
import it.adegroups.classroomfinder.model.ClassRoom;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import it.adegroups.classroomfinder.model.DaysOfWeek;

import java.io.*;
import java.time.LocalTime;
import java.util.List;

public class ClassRoomDAOCSV implements ClassRoomDAO {
    private final File fd;
    public ClassRoomDAOCSV() {
        fd = new File("db/class_room.csv");
    }
    @Override
    public void save(ClassRoom classRoom) {
        try (CSVWriter writer = new CSVWriter(new FileWriter(fd, true))) {
            String[] classRoomRecord = new String[5];
            classRoomRecord[ClassRoomAttributesOrder.INDEX_ROOM] = classRoom.getRoom();
            classRoomRecord[ClassRoomAttributesOrder.INDEX_DAY] = classRoom.getDays().toString();
            classRoomRecord[ClassRoomAttributesOrder.INDEX_LECTURE] = String.valueOf(classRoom.isLecture());
            classRoomRecord[ClassRoomAttributesOrder.INDEX_HOUR] = String.valueOf(classRoom.getTime().getHour());
            classRoomRecord[ClassRoomAttributesOrder.INDEX_MINUTES] = String.valueOf(classRoom.getTime().getMinute());

            writer.writeNext(classRoomRecord);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<ClassRoom> retrieveClassRoomByDOW(ClassRoomBean classRoomBean) {
        try (CSVReader reader = new CSVReader(new FileReader(fd))) {
            List<String[]> table = reader.readAll();
            return table.stream()
                    .filter(classRoomRecord -> DaysOfWeek.valueOf(classRoomRecord[ClassRoomAttributesOrder.INDEX_DAY]).equals(classRoomBean.getDay()))
                    .filter(classRoomRecord -> !Boolean.parseBoolean(classRoomRecord[ClassRoomAttributesOrder.INDEX_LECTURE]))
                    .map(classRoomRecord -> new ClassRoom(
                            classRoomRecord[ClassRoomAttributesOrder.INDEX_ROOM],
                            DaysOfWeek.valueOf(classRoomRecord[ClassRoomAttributesOrder.INDEX_DAY]),
                            Boolean.parseBoolean(classRoomRecord[ClassRoomAttributesOrder.INDEX_LECTURE]),
                            LocalTime.of(Integer.parseInt(classRoomRecord[ClassRoomAttributesOrder.INDEX_HOUR]), Integer.parseInt(classRoomRecord[ClassRoomAttributesOrder.INDEX_MINUTES]))
                    ))
                    .toList();
        } catch (IOException | CsvException e) {
            throw new RuntimeException(e);
        }
    }
    private static class ClassRoomAttributesOrder {
        private static final int INDEX_ROOM    = 0;
        private static final int INDEX_DAY     = 1;
        private static final int INDEX_LECTURE = 2;
        private static final int INDEX_HOUR    = 3;
        private static final int INDEX_MINUTES = 4;
    }
}
