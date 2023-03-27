package com.example.teachSystem;

import javax.persistence.*;

@Entity
@Table(name = "course", schema = "zuccknowledge", catalog = "")
public class CourseEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "intro")
    private String intro;
    @Basic
    @Column(name = "book")
    private String book;
    @Basic
    @Column(name = "tag")
    private String tag;
    @Basic
    @Column(name = "teacher")
    private String teacher;
    @Basic
    @Column(name = "knowledge")
    private String knowledge;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CourseEntity that = (CourseEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (intro != null ? !intro.equals(that.intro) : that.intro != null) return false;
        if (book != null ? !book.equals(that.book) : that.book != null) return false;
        if (tag != null ? !tag.equals(that.tag) : that.tag != null) return false;
        if (teacher != null ? !teacher.equals(that.teacher) : that.teacher != null) return false;
        if (knowledge != null ? !knowledge.equals(that.knowledge) : that.knowledge != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (intro != null ? intro.hashCode() : 0);
        result = 31 * result + (book != null ? book.hashCode() : 0);
        result = 31 * result + (tag != null ? tag.hashCode() : 0);
        result = 31 * result + (teacher != null ? teacher.hashCode() : 0);
        result = 31 * result + (knowledge != null ? knowledge.hashCode() : 0);
        return result;
    }
}
