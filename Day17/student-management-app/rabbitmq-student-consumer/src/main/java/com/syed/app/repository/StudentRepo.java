package com.syed.app.repository;



@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {
    Student findByName(String name);
}
