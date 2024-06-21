import {Injectable} from '@angular/core';
import {AvgGradeModel} from "../../models/AvgGradeModel";
import {GradeSubjectOutModel} from "../../models/GradeSubjectOutModel";
import {HttpClient} from "@angular/common/http";
import {GradeSubjectModel} from "../../models/GradeSubjectModel";

@Injectable({
  providedIn: 'root'
})
export class GradeService {
  currentSubject_id: number = 0;
  currentGradeId: number = 0;

  constructor(private http: HttpClient) {
  }

  getAVGData(user_id: number) {
    return this.http.get<AvgGradeModel[]>(`http://localhost:8080/api/student/school_subject_grade/averages/${user_id}`);
  }

  getSubjectSpecificData(user_id: number) {

    return this.http.get<GradeSubjectOutModel[]>(`http://localhost:8080/api/student/school_subject_grade/${user_id}`)
  }

  // saveGradeData(grade:GradeSubjectOutModel){
  //   this.gradeToEdit = grade;
  // }
  addGrade(subject: number, grade: number, date: string, user_id: number) {
    return this.http.post<GradeSubjectModel>(`http://localhost:8080/api/student/school_subject_grade/grade`, {
      grade_id: grade, subject_id: subject, date: date, user_id: user_id
    });
  }

  editGrade(gradeId: number, grade: number) {
    return this.http.put(`http://localhost:8080/api/student/school_subject_grade/grade/${gradeId}`, {
      grade_Id: grade
    });
  }

  deleteGrade(gradeId: number) {
    return this.http.delete(`http://localhost:8080/api/student/school_subject_grade/grade/${gradeId}`)
  }

  roundToSpecificNumber(avg: number): number {
    const inv = 1.0 / 0.25;
    return Math.round(avg * inv) / inv;
  }

  saveSubjectId(subject_id: number) {
    this.currentSubject_id = subject_id;
  }

  getSubjectId(): number {
    return this.currentSubject_id;
  }

  saveGradeId(gradId: number) {
    this.currentGradeId = gradId;
  }

  getGradeId() {
    return this.currentGradeId;
  }
}
