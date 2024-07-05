import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {SubjectModel} from "../../models/SubjectModel";
import {AvgGradeModel} from "../../models/AvgGradeModel";

@Injectable({
  providedIn: 'root'
})
export class SubjectService {
  private subjectName: string = "";
  private subjectId:number = 0;
  private SubjectNameArray:string[] = []
  private basisURL: string = `http://localhost:8080/api/admin`;


  constructor(private http: HttpClient) {
  }
  createSubject(subjectName:string){
    return this.http.post<SubjectModel>(this.basisURL + '/subject', {
      name: subjectName
    });
  }
  editSubject(subjectName:string, subjectId: number){
    return this.http.put<SubjectModel>(this.basisURL + `/subject/${subjectId}`, {
      name: subjectName
    });
  }
  deleteSubject(subjectId: number){
    return this.http.delete(this.basisURL + `/subject/${subjectId}`)
  }

  saveSubjectName(subjectName: string, subjectId:number) {
    this.subjectName = subjectName;
    this.subjectId = subjectId;
  }
  getSubjectName(){
    return this.subjectName;
  }
  getSubjectId(){
    return this.subjectId
  }
  saveNameOfSubjects(data: AvgGradeModel[]){
    for (let i = 0; i < data.length; i++) {
      this.SubjectNameArray.push(data[i].name);
    }
  }
  IsNamesOfSubjectUnique(name:string):boolean{
    return this.SubjectNameArray.includes(name);
  }
}
