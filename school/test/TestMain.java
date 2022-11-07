package school.test;

import school.School;
import school.Subject;
import school.report.GenerateGradeReport;
import utils.Define;

public class TestMain {
    private School school = School.getInstance();
    private Subject korean;
    private Subject math;
    private GenerateGradeReport gradeReport = new GenerateGradeReport();

    public static void main(String[] args){
        TestMain test = new TestMain();
        test.createSubject();

    }

    public void createSubject() {
        korean = new Subject(Define.KOREAN, "국어");
        math = new Subject(Define.MATH, "수학");

        school.addSubject(korean);
        school.addSubject(math);
    }

}
