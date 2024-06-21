import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {SubjectModel} from "../../models/SubjectModel";

@Injectable({
  providedIn: 'root'
})
export class SubjectService {
  private subjectName: string = "";
  private subjectId:number = 0;

  constructor(private http: HttpClient) {
  }
  createSubject(subjectName:string){
    console.log(subjectName)
    return this.http.post<SubjectModel>('http://localhost:8080/api/admin/subject', {
      name: subjectName
    });
  }
  editSubject(subjectName:string, subjectId: number){
    return this.http.put<SubjectModel>(`http://localhost:8080/api/admin/subject/${subjectId}`, {
      name: subjectName
    })
  }
  deleteSubject(subjectId: number){
    return this.http.delete(`http://localhost:8080/api/admin/subject/${subjectId}`)
  }

  saveSubjectName(subjectName: string, subjectId:number) {
    this.subjectName = subjectName;
    this.subjectId = subjectId
  }
  getSubjectName(){
    return this.subjectName;
  }
  getSubjectId(){
    return this.subjectId
  }
}
