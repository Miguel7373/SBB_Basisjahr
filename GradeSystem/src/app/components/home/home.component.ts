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
import {MatButton, MatIconButton} from "@angular/material/button";
import {MatIcon} from "@angular/material/icon";
import {RouterLink} from "@angular/router";
import {MatDialog} from "@angular/material/dialog";
import {DeleteSubjectOrGradeComponent} from "../delete-subject-or-grade/delete-subject-or-grade.component";
import {TranslateModule} from "@ngx-translate/core";
import {GradeService} from "../../services/gradeService/grade.service";
import {SubjectService} from "../../services/subjectService/subject.service";
import {DecimalPipe, NgStyle} from "@angular/common";
import {Subject, takeUntil} from "rxjs";

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
    DecimalPipe
  ],
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss'
})
export class HomeComponent implements OnInit, OnDestroy {
  displayedColumns: string[] = ['name', 'avg', 'Actions'];
  dataSource: AvgGradeModel[] = [];
  average: number = 0;
  subjectName: string = ""
  subjectId: number = 0;
  bool: boolean = true
  private ngUnsubscribe = new Subject<void>();

  constructor(public dialog: MatDialog, protected gradeService: GradeService, protected subjectService: SubjectService) {
  }

  ngOnDestroy() {
    this.ngUnsubscribe.next();
    this.ngUnsubscribe.complete();
  }

  ngOnInit() {
    this.gradeService.getAVGData().pipe(takeUntil(this.ngUnsubscribe)).subscribe(
      (data: AvgGradeModel[]) => {
        this.dataSource = data;
      }
    );
  }



  openDialog(avg: number, name: string, id: number) {
    this.average = avg;
    this.subjectName = name;
    this.subjectId = id;
    console.log(this.subjectId)
    this.dialog.open(DeleteSubjectOrGradeComponent, {
      data: {
        average: this.average,
        subjectName: this.subjectName,
        subjectId: this.subjectId,
        bool: this.bool
      }
    });

  }

  saveSubjectToEdit(subject: string, id: number) {
    this.subjectService.saveSubjectName(subject, id)
  }

  rightColor(avg: number): string {
    if (avg >= 4.5) {
      return '#4B9A4C';
    } else if (avg < 4) {
      return '#dd543a';
    } else {
      return '#ffb347';
    }
  }
}
