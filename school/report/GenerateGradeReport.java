package school.report;

import school.Student;
import school.Subject;

import java.util.ArrayList;

public class GenerateGradeReport {

    public static final String TITLE = "수강생 학점\t\tn";
    public static final String HEADER = "이름\t\t|학번\t\t|\t중정과목\t|\t점수\n";
    public static final String LINE = "----------------------------------";
    public StringBuffer buffer = new StringBuffer();    // 임시저장 공간


    public void makeHeader(Subject subject){
        buffer.append(GenerateGradeReport.LINE);
        buffer.append(subject.getSubjectName() + TITLE);
        buffer.append(GenerateGradeReport.HEADER);
        buffer.append(GenerateGradeReport.LINE);
    }

    public void makeBody(Subject subject, Student student){
        ArrayList<Student> students = subject.getStudentList();      // ctrl + alt + v
        // int studentId = student.getStudentId();
        // Subject majorSubject = student.getMajorSubject();

    }
}
