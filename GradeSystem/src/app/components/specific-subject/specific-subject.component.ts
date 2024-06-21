import {Component, OnDestroy, OnInit} from '@angular/core';
import {MatButton, MatIconButton} from "@angular/material/button";
import {MatIcon} from "@angular/material/icon";
import {ActivatedRoute, RouterLink, RouterLinkActive} from "@angular/router";
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
import {GradeSubjectOutModel} from "../../models/GradeSubjectOutModel";
import {MatDialog} from "@angular/material/dialog";
import {DeleteSubjectOrGradeComponent} from "../delete-subject-or-grade/delete-subject-or-grade.component";
import {TranslateModule} from "@ngx-translate/core";
import {GradeService} from "../../services/gradeService/grade.service";
import {DecimalPipe, NgStyle} from "@angular/common";
import {Subject, takeUntil} from "rxjs";
import {AvgGradeModel} from "../../models/AvgGradeModel";
import {UserService} from "../../services/UserService/user-service.service";
import {GradeModel} from "../../models/GradeModel";

@Component({
  selector: 'app-specific-subject',
  standalone: true,
  imports: [
    MatButton,
    MatIcon,
    RouterLink,
    MatCell,
    MatCellDef,
    MatColumnDef,
    MatHeaderCell,
    MatHeaderRow,
    MatHeaderRowDef,
    MatIconButton,
    MatRow,
    MatRowDef,
    MatTable,
    MatHeaderCellDef,
    TranslateModule,
    RouterLinkActive,
    DecimalPipe,
    NgStyle
  ],
  templateUrl: './specific-subject.component.html',
  styleUrl: './specific-subject.component.scss'
})
export class SpecificSubjectComponent implements OnInit, OnDestroy{
  displayedColumns: string[] = ['note', 'datum', 'actions'];
  dataSource: GradeSubjectOutModel[] = [];
  dataSource2: GradeModel[] = [];
  specificSubject: string = "";
  grade: number = 0;
  subjectName: string = ""
  date: string = ""
  bool:boolean = false
  private ngUnsubscribe = new Subject<void>();
  userData: any;


  constructor(private route: ActivatedRoute, public dialog: MatDialog, protected gradeService: GradeService, private userService: UserService) {
  }
  ngOnDestroy() {
    this.ngUnsubscribe.next();
    this.ngUnsubscribe.complete();
  }

  ngOnInit(): void {
    this.specificSubject = this.route.snapshot.params['subject'];
    this.userService.getCurrentUser().pipe(takeUntil(this.ngUnsubscribe)).subscribe(
      (user: any) => {
        this.userData = user;
        this.gradeService.getSubjectSpecificData(this.userData.id).pipe(takeUntil(this.ngUnsubscribe)).subscribe(
          (data: GradeSubjectOutModel[]) => {
            this.dataSource = data;
            this.dataSource = this.dataSource.filter(data => data.name === this.specificSubject);
            this.dataSource.forEach(d => this.dataSource2 = d.gradeDateList);
            this.dataSource.forEach(x => this.gradeService.saveSubjectId(x.subject_id))
            console.log();
          }
        );
      }
    );


  }

  openDialog(grade: number, name: string, date: string) {
    this.grade = grade;
    this.subjectName = name;
    this.date = date;
    this.dialog.open(DeleteSubjectOrGradeComponent, {
      data: {
        grade: this.gradeService.roundToSpecificNumber(this.grade),
        subjectName: this.subjectName,
        date: this.date,
        bool: this.bool
      }
    });
  }

  saveGradeData(gradeId: number ) {
    this.gradeService.saveGradeId(gradeId);
  }

  rightColor(grade: number): string {
    if (grade >= 4.5) {
      return '#4B9A4C';
    } else if (grade < 4) {
      return '#dd543a';
    } else {
      return '#ffb347';
    }
  }


}
