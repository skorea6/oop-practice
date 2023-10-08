package org.example.grade;

import java.util.List;

public class Courses {
    private List<Course> courses;

    public Courses(List<Course> courses) {
        this.courses = courses;
    }

    public double multiplyCreditAndCourseGrade() {
//        double multipliedCreditAndCourseGrade = 0;
//        for (Course course : courses) {
//            multipliedCreditAndCourseGrade += course.multiplyCreditAndCourseGrade(); // 곱셉부분: 변화에 유연한 코드
//        }
//        return multipliedCreditAndCourseGrade;
        return courses.stream().mapToDouble(Course::multiplyCreditAndCourseGrade).sum();
    }

    public int calculateTotalCompletedCredit() {
        return courses.stream().mapToInt(Course::getCredit).sum();
    }
}
