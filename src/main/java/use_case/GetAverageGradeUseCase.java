package use_case;
import api.GradeDB;
import entity.Grade;
import entity.Team;

public final class GetAverageGradeUseCase {
    private final GradeDB gradeDB;

    public GetAverageGradeUseCase(GradeDB gradeDB) {
        this.gradeDB = gradeDB;
    }

    public float getAverageGrade(String course) {
        String[] teamMembers = gradeDB.getMyTeam().getMembers();

        if (teamMembers == null || teamMembers.length == 0) {
            return 0.0f;
        }

        float totalGrade = 0.0f;
        int count = 0;

        for (String member : teamMembers) {
            Grade grade = gradeDB.getGrade(member, course);
            System.out.println(member);
            if (grade != null) {
                totalGrade += grade.getGrade();
                System.out.println(grade.getGrade());
                count++;
            }
        }

        if (count == 0) {
            return 0.0f;
        }

        return totalGrade / count;

    }
}
