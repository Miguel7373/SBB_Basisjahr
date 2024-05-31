import {Component, Inject, OnDestroy, OnInit} from '@angular/core';
import {
  MAT_DIALOG_DATA,
  MatDialogActions,
  MatDialogClose,
  MatDialogContent,
  MatDialogRef,
  MatDialogTitle
} from "@angular/material/dialog";
import {MatButtonModule} from "@angular/material/button";
import {HomeComponent} from "../home/home.component";
import {SpecificSubjectComponent} from "../specific-subject/specific-subject.component";
import {TranslateLoader, TranslateModule, TranslateService, TranslateStore} from "@ngx-translate/core";
import {HttpClient} from "@angular/common/http";
import {TranslateHttpLoader} from "@ngx-translate/http-loader";
import {SubjectService} from "../../services/subjectService/subject.service";
import {Subject, takeUntil} from "rxjs";
function HttpLoaderFactory(http: HttpClient) {
  return new TranslateHttpLoader(http)
}

@Component({
  selector: 'app-delete-subject-or-grade',
  standalone: true,
  imports: [MatDialogTitle, MatDialogContent, MatDialogActions, MatDialogClose, MatButtonModule, TranslateModule],
  templateUrl: './delete-subject-or-grade.component.html',
  styleUrl: './delete-subject-or-grade.component.scss'
})
export class DeleteSubjectOrGradeComponent implements OnInit, OnDestroy{
  private ngUnsubscribe = new Subject<void>();
  subjectOrGrade:boolean = false

  constructor(public dialogRef: MatDialogRef<DeleteSubjectOrGradeComponent>, @Inject(MAT_DIALOG_DATA) public dataSubject: HomeComponent, @Inject(MAT_DIALOG_DATA) public dataGrade: SpecificSubjectComponent, private subjectService:SubjectService) {

  }
  ngOnDestroy() {
    this.ngUnsubscribe.next();
    this.ngUnsubscribe.complete();
  }
  ngOnInit() {
    console.log(this.dataSubject.subjectId, this.dataGrade)
  }

  deleteSubject(){
    this.subjectService.deleteSubject(this.dataSubject.subjectId).pipe(takeUntil(this.ngUnsubscribe)).subscribe((res)=> {});
  }
}
