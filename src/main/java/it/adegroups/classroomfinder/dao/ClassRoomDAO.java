package it.adegroups.classroomfinder.dao;

import it.adegroups.classroomfinder.bean.ClassRoomBean;
import it.adegroups.classroomfinder.model.ClassRoom;

import java.util.List;

public interface ClassRoomDAO {
    void save(ClassRoom classRoom);
    List<ClassRoom> retrieveClassRoomByDOW(ClassRoomBean classRoomBean);
}
