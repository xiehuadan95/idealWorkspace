package com.xie.beans;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author xiehu
 * @Date 2022/8/27 23:10
 * @Version 1.0
 * @Description
 */
public class Person {
    private Integer id;
    private String name;
    private String gender;
    private Date birthday;
    private List<String> hobbies;
    private Map<Integer,String> course;
    private Wife wife;
    private Map<Integer,Wife> details;

    public Map<Integer, Wife> getDetails() {
        return details;
    }

    public void setDetails(Map<Integer, Wife> details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday=" + birthday +
                ", hobbies=" + hobbies +
                ", course=" + course +
                ", wife=" + wife +
                ", details=" + details +
                '}';
    }

    public Person() {
        System.out.println("Person加载===");
    }
    public Person(Wife wife2){
        this.wife=wife2;
        System.out.println("有参构造");
    }

    public static Person createPersonFactory(){
        Child child=new Child();
        child.setName("son");
        return child;
    }
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public Map<Integer, String> getCourse() {
        return course;
    }

    public void setCourse(Map<Integer, String> course) {
        this.course = course;
    }

    public Wife getWife() {
        return wife;
    }

    public void setWife(Wife wife) {
        this.wife = wife;
    }
}
