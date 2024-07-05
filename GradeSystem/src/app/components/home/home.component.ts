import {Component, OnDestroy, OnInit} from '@angular/core';
import {
  MatCell,
  MatCellDef,
  MatColumnDef,
  MatHeaderCell,
  MatHeaderCellDef,
  MatHeaderRow,
  MatHeaderRowDef,
  MatRow,
  MatRowDef,
  MatTable
} from "@angular/material/table";
import {AvgGradeModel} from "../../models/AvgGradeModel";
import {MatButton, MatFabButton, MatIconButton} from "@angular/material/button";
import {MatIcon} from "@angular/material/icon";
import {RouterLink} from "@angular/router";
import {MatDialog} from "@angular/material/dialog";
import {DeleteSubjectOrGradeComponent} from "../delete-subject-or-grade/delete-subject-or-grade.component";
import {TranslateModule} from "@ngx-translate/core";
import {GradeService} from "../../services/gradeService/grade.service";
import {SubjectService} from "../../services/subjectService/subject.service";
import {DecimalPipe, NgStyle} from "@angular/common";
import {Subject, takeUntil} from "rxjs";
import {UserService} from "../../services/UserService/user-service.service";

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [
    MatTable,
    MatColumnDef,
    MatHeaderCell,
    MatHeaderCellDef,
    MatCellDef,
    MatCell,
    MatHeaderRow,
    MatHeaderRowDef,
    MatRow,
    MatRowDef,
    MatButton,
    MatIcon,
    MatIconButton,
    RouterLink,
    TranslateModule,
    NgStyle,
    DecimalPipe,
    MatFabButton
  ],
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss'
})
export class HomeComponent implements OnInit, OnDestroy {
  displayedColumns: string[] = ['name', 'avg', 'Actions'];
  dataSource: AvgGradeModel[] = [];
  userData: any;
  average: number = 0;
  subjectName: string = ""
  subjectId: number = 0;
  bool: boolean = true
  private ngUnsubscribe:Subject<void> = new Subject<void>();

  constructor(private dialog: MatDialog, protected gradeService: GradeService, protected subjectService: SubjectService, private userService:UserService) {
  }



  ngOnInit():void {
    this.userService.getCurrentUser().pipe(takeUntil(this.ngUnsubscribe)).subscribe(
      (user: any):void => {
        this.userData = user;
        this.gradeService.getAVGData(this.userData.id).pipe(takeUntil(this.ngUnsubscribe)).subscribe(
          (data: AvgGradeModel[]):void => {
            this.dataSource = data;
            this.saveNameOfSubjects();
          }
        );
      }
    );

  }

  ngOnDestroy():void {
    this.ngUnsubscribe.next();
    this.ngUnsubscribe.complete();
  }



  openDialog(avg: number, name: string, id: number):void {
    this.average = avg;
    this.subjectName = name;
    this.subjectId = id;
    this.dialog.open(DeleteSubjectOrGradeComponent, {
      data: {
        average: this.average,
        subjectName: this.subjectName,
        subjectId: this.subjectId,
        bool: this.bool
      }
    });

  }

  saveSubjectToEdit(subject: string, id: number):void {
    this.subjectService.saveSubjectName(subject, id)
  }

  rightColor(avg: number): string {
    if (avg >= 4.5 && avg <= 6) {
      return '#4B9A4C';
    } else if (avg < 4 && avg >= 1) {
      return '#dd543a';
    } else if (avg >= 4 &&  avg < 4.5){
      return '#ffb347';
    }else {
      return "";
    }
  }
  showAvg(avg: number):string{
    const newAvg:number  = this.gradeService.roundToSpecificNumber(avg);
    if (newAvg > 0){
      return newAvg.toString()
    }else return  "-"
  }
  saveNameOfSubjects(){
    this.subjectService.saveNameOfSubjects(this.dataSource)
  }
}
