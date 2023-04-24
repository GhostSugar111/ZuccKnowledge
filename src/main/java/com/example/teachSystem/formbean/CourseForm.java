package com.example.teachSystem.formbean;

import com.example.teachSystem.Entity.Course;

public class CourseForm {
    private Integer id=null;
    private String name;
    private String intro;
    private String book;
    private String tag;
    private String teacher;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getKnowledge() {
        return knowledge;
    }

    public void setKnowledge(String knowledge) {
        this.knowledge = knowledge;
    }

    private String knowledge;

    public CourseForm() {}

    public CourseForm(Course course) {
        this.id = course.getId();
        this.name = course.getName();
        this.intro = course.getIntro();
        this.book = course.getBook();
        this.tag = course.getTag();
        this.teacher = course.getTeacher();
        this.knowledge = course.getKnowledge();
    }

    public Course toCourse() {
        Course course = new Course();
        course.setId(id);
        course.setName(name);
        course.setIntro(intro);
        course.setBook(book);
        course.setTag(tag);
        course.setTeacher(teacher);
        course.setKnowledge(knowledge);
        return course;
    }

    @Override
    public String toString() {
        return "CourseForm{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", intro='" + intro + '\'' +
                ", book='" + book + '\'' +
                ", tag='" + tag + '\'' +
                ", teacher='" + teacher + '\'' +
                ", knowledge='" + knowledge + '\'' +
                '}';
    }
    // getters and setters
}
