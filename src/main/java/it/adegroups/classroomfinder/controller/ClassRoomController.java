package it.adegroups.classroomfinder.controller;

import it.adegroups.classroomfinder.bean.ClassRoomBean;
import it.adegroups.classroomfinder.dao.ClassRoomDAO;
import it.adegroups.classroomfinder.dao.ClassRoomDAOCSV;
import it.adegroups.classroomfinder.model.ClassRoom;

import java.util.List;

public class ClassRoomController {
    private ClassRoomDAO classRoomDAO;
    public ClassRoomController() {
        classRoomDAO = new ClassRoomDAOCSV();
    }
    public void loadClassRoom(List<ClassRoomBean> classRoomBeanList) {
        for(ClassRoomBean classRoomBean : classRoomBeanList) {
            classRoomDAO.save(new ClassRoom(classRoomBean));
        }
    }
}
