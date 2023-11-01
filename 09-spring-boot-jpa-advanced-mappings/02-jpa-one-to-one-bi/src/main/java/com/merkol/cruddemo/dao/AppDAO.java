package com.merkol.cruddemo.dao;

import com.merkol.cruddemo.entity.Instructor;
import com.merkol.cruddemo.entity.InstructorDetail;

public interface AppDAO {

    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);

    InstructorDetail findInstructorDetailById(int theId);

    void deleteInstructorDatilById(int theId);
}
