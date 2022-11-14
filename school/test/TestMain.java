package school.test;

import school.School;
import school.Score;
import school.Student;
import school.Subject;
import school.report.GenerateGradeReport;
import utils.Define;

public class TestMain {
    private School school = School.getInstance();
    private Subject korean;
    private Subject math;
    private GenerateGradeReport gradeReport = new GenerateGradeReport();

    public static void main(String[] args) {
        TestMain test = new TestMain();
        test.createSubject();
        test.createStudent();

        String report = test.gradeReport.getReport();
        System.out.println(report);
    }

    public void createSubject() {
        korean = new Subject(Define.KOREAN, "국어");
        math = new Subject(Define.MATH, "수학");

        school.addSubject(korean);
        school.addSubject(math);
    }

    public void createStudent() {
        Student student1 = new Student(221213, "안성원", korean);
        Student student2 = new Student(221518, "오태훈", math);
        Student student3 = new Student(221230, "이동호", korean);
        Student student4 = new Student(221255, "조성욱", korean);
        Student student5 = new Student(221590, "최태평", math);

        school.addStudent(student1);
        school.addStudent(student2);
        school.addStudent(student3);
        school.addStudent(student4);
        school.addStudent(student5);

        korean.register(student1);
        korean.register(student2);
        korean.register(student3);
        korean.register(student4);
        korean.register(student5);

        math.register(student1);
        math.register(student2);
        math.register(student3);
        math.register(student4);
        math.register(student5);

//        Score score;
//        score = new Score(student1.getStudentId(), korean, 95);
//        student1.addSubjectScore(score);
//        addScoreForStudent(student1, korean, 95);

        addScoreForStudent(student1, korean, 95);
        addScoreForStudent(student1, math, 56);

        addScoreForStudent(student2, korean, 95);
        addScoreForStudent(student2, math, 95);

        addScoreForStudent(student3, korean, 100);
        addScoreForStudent(student3, math, 88);

        addScoreForStudent(student4, korean, 89);
        addScoreForStudent(student4, math, 95);

        addScoreForStudent(student5, korean, 85);
        addScoreForStudent(student5, math, 56);
    }

    public void addScoreForStudent(Student student, Subject subject, int point) {
        Score score = new Score(student.getStudentId(), subject, point);
        student.addSubjectScore(score);

    }
}
