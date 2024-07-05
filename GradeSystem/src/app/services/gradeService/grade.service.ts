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
  currentGrade: number = 0;
  basisURL: string = `http://localhost:8080/api/student/school_subject_grade`;

  constructor(private http: HttpClient) {
  }

  getAVGData(user_id: number) {
    return this.http.get<AvgGradeModel[]>(this.basisURL + `/averages/${user_id}`);
  }

  getSubjectSpecificData(user_id: number) {

    return this.http.get<GradeSubjectOutModel[]>(this.basisURL + `/${user_id}`);
  }

  addGrade(subject: number, grade: number, date: string, user_id: number) {
    return this.http.post<GradeSubjectModel>(this.basisURL + `/grade`, {
      grade_id: grade, subject_id: subject, date: date, user_id: user_id
    });
  }

  editGrade(gradeId: number, grade: number) {
    return this.http.put(this.basisURL + `/grade/${gradeId}`, {
      grade_Id: grade
    });
  }

  deleteGrade(gradeId: number) {
    return this.http.delete(this.basisURL + `/grade/${gradeId}`)
  }

  roundToSpecificNumber(avg: number): number {
    const inv: number = 1.0 / 0.25;
    return Math.round(avg * inv) / inv;
  }

  saveSubjectId(subject_id: number): void {
    this.currentSubject_id = subject_id;
  }

  getSubjectId(): number {
    return this.currentSubject_id;
  }

  saveGradeId(gradId: number): void {
    this.currentGradeId = gradId;
  }

  getGradeId(): number {
    return this.currentGradeId;
  }

  saveGrade(grade: number): void {
    this.currentGrade = grade;
  }

  getGrade(): number {
    return this.currentGrade;
  }
}
