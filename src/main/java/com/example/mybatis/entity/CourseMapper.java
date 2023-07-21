package com.example.mybatis.entity;

import org.apache.ibatis.annotations.Select;

public interface CourseMapper {
    @Select("select * from course")
    Course getAllCourse();
}
