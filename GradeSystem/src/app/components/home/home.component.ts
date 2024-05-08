import { Component } from '@angular/core';
import {
  MatCell,
  MatCellDef,
  MatColumnDef,
  MatHeaderCell,
  MatHeaderCellDef,
  MatHeaderRow, MatHeaderRowDef, MatRow, MatRowDef,
  MatTable
} from "@angular/material/table";
import {AvgGradeModel} from "../../models/AvgGradeModel";
import {MatButton, MatIconButton} from "@angular/material/button";
import {MatIcon} from "@angular/material/icon";
import {RouterLink} from "@angular/router";
import {MatDialog} from "@angular/material/dialog";
import {DeleteSubjectOrGradeComponent} from "../delete-subject-or-grade/delete-subject-or-grade.component";

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
    RouterLink
  ],
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss'
})
export class HomeComponent {
  displayedColumns: string[] = ['name', 'avg','Actions'];
  dataSource:AvgGradeModel[] = [
    {name: 'Mathematrik', avg: 5.15},
    {name: 'Englisch', avg: 4.67},
    {name: 'Deutsch', avg: 4.53},
    {name: 'Informatik', avg: 5.54},
  ];
  average:number = 0;
  subjectName:string = ""
  constructor(public dialog: MatDialog) {}
  openDialog(avg: number, name:string) {
    this.average = avg;
    this.subjectName = name;
    this.dialog.open(DeleteSubjectOrGradeComponent, {data: {average: this.average, subjectName: this.subjectName}});
  }
}
