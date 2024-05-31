import {Component, OnInit} from '@angular/core';
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
export class SpecificSubjectComponent implements OnInit {
  displayedColumns: string[] = ['note', 'datum', 'actions'];
  dataSource: GradeSubjectOutModel[] = [];
  specificSubject: string = "";
  grade: number = 0;
  subjectName: string = ""
  date: string = ""
  bool:boolean = false

  constructor(private route: ActivatedRoute, public dialog: MatDialog, protected gradeService: GradeService) {
  }

  ngOnInit(): void {
    this.dataSource = this.gradeService.getSubjectSpecificData();
    this.specificSubject = this.route.snapshot.params['subject'];
    this.dataSource = this.dataSource.filter(data => data.name === this.specificSubject);
  }

  openDialog(grade: number, name: string, date: string) {
    this.grade = grade;
    this.subjectName = name;
    this.date = date;
    this.dialog.open(DeleteSubjectOrGradeComponent, {
      data: {
        grade: this.roundToSpecificNumber(this.grade),
        subjectName: this.subjectName,
        date: this.date,
        bool: this.bool
      }
    });
  }

  saveGradeData(grade: GradeSubjectOutModel) {
    this.gradeService.saveGradeData(grade);
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

  roundToSpecificNumber(avg: number): number {
    const inv = 1.0 / 0.25;
    return Math.round(avg * inv) / inv;
  }
}
