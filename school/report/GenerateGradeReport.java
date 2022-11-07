package school.report;

import grade.BasicEvaluation;
import grade.GradeEvaluation;
import grade.MajorEvaluation;
import school.School;
import school.Score;
import school.Student;
import school.Subject;
import utils.Define;

import java.util.ArrayList;

public class GenerateGradeReport {
    School school = School.getInstance();
    public static final String TITLE = "수강생 학점\t\t\n";
    public static final String HEADER = "이름\t|\t학번\t\t|\t중정과목\t|\t점수\n";
    public static final String LINE = "----------------------------------------";
    private StringBuffer buffer = new StringBuffer();    // 임시 저장 공간

    public String getReport(){
        ArrayList<Subject> subjectList = school.getSubjectList();
        for(int i = 0; i < subjectList.size(); ++i){
            Subject subject = subjectList.get(i);
            makeHeader(subject);
            makeBody(subject);
            makerFooter();
        }

        return buffer.toString();
    }

    public void makeHeader(Subject subject){
        buffer.append(GenerateGradeReport.LINE);
        buffer.append(subject.getSubjectName() + " " + GenerateGradeReport.TITLE);
        buffer.append(GenerateGradeReport.HEADER);
        buffer.append(GenerateGradeReport.LINE);
    }

    public void makeBody(Subject subject){
        ArrayList<Student> studentList = subject.getStudentList();      // ctrl + alt + v

        for(int i = 0; i < studentList.size(); ++i){
            Student student = studentList.get(i);

            buffer.append(student.getStudentName());
            buffer.append("\t|\t");
            buffer.append(student.getStudentId());
            buffer.append("\t|\t");
            buffer.append(student.getMajorSubject().getSubjectName());
            buffer.append("\t|\t");
            buffer.append(student.getScoreList());

            ArrayList<Score> scoreList = student.getScoreList();
            int majorId = student.getMajorSubject().getSubjectId();

            GradeEvaluation[] gradeEvaluations = {new BasicEvaluation(), new MajorEvaluation()};     // JAVA의 다양성
            for(int j = 0; j < scoreList.size(); ++j){
                Score score = scoreList.get(j);
                if (score.getSubject().getSubjectId() == subject.getSubjectId()){
                    String grade;
                    if (score.getSubject().getSubjectId() == majorId){
                        grade = gradeEvaluations[Define.SAB_TYPE].getGrade(score.getPoint());
                    } else {
                        grade = gradeEvaluations[Define.AB_TYPE].getGrade(score.getPoint());
                    }

                    buffer.append(score.getPoint() + " : " + grade);
                }
            }

            buffer.append("\n");
            buffer.append(GenerateGradeReport.LINE);
        }
    }

    public void makerFooter() {
        buffer.append("\n");
    }
}
