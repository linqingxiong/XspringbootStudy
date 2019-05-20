package com.xiong.entity.doublekill;

import javax.persistence.*;
import java.util.Objects;

/**
 * @ClassName XDoublekillUserEntity
 * @Description TODO
 * @Author YuanMa
 * @Date 2019/5/16 15:53
 * @Version 1.0
 **/
@Entity
@Table(name = "x_doublekill_user", schema = "xspringbootstudy_doublekill", catalog = "")
public class XDoublekillUserEntity {
    private int id;
    private String name;
    private Integer age;
    private String grade;
    private String clazz;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "age")
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Basic
    @Column(name = "grade")
    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Basic
    @Column(name = "class")
    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        XDoublekillUserEntity that = (XDoublekillUserEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(age, that.age) &&
                Objects.equals(grade, that.grade) &&
                Objects.equals(clazz, that.clazz);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, grade, clazz);
    }
}
