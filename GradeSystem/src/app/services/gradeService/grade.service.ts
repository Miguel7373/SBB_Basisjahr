import {Injectable} from '@angular/core';
import {AvgGradeModel} from "../../models/AvgGradeModel";
import {GradeSubjectOutModel} from "../../models/GradeSubjectOutModel";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class GradeService {
  private gradeToEdit:GradeSubjectOutModel = {id: 0, name: "", grade: 0, date: ""};
  constructor(private http: HttpClient) {
  }

  getAVGData() {
    return this.http.get<AvgGradeModel[]>('http://localhost:8080/api/student/school_subject_grade/average');
  }

  getSubjectSpecificData(): GradeSubjectOutModel[] {
    return [
      {id: 1, name: "Mathematrik", grade: 5.21, date: "01/03/2024"},
      {id: 2, name: "Englisch", grade: 4.17, date: "01/03/2024"},
      {id: 4, name: "Englisch", grade: 4.43, date: "01/03/2024"},
      {id: 6, name: "Deutsch", grade: 5.65, date: "01/03/2024"},
    ]
  }
  saveGradeData(grade:GradeSubjectOutModel){
    this.gradeToEdit = grade;
  }
  getGradeData(){
    return this.gradeToEdit
  }
}
