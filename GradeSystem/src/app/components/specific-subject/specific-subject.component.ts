import {Component, OnInit} from '@angular/core';
import {MatButton, MatIconButton} from "@angular/material/button";
import {MatIcon} from "@angular/material/icon";
import {ActivatedRoute, RouterLink} from "@angular/router";
import {
  MatCell,
  MatCellDef,
  MatColumnDef,
  MatHeaderCell, MatHeaderCellDef,
  MatHeaderRow,
  MatHeaderRowDef,
  MatRow, MatRowDef, MatTable
} from "@angular/material/table";
import {AvgGradeModel} from "../../models/AvgGradeModel";
import {GradeSubjectModel} from "../../models/GradeSubjectModel";

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
    MatHeaderCellDef
  ],
  templateUrl: './specific-subject.component.html',
  styleUrl: './specific-subject.component.scss'
})
export class SpecificSubjectComponent implements OnInit{
  displayedColumns: string[] = ['note', 'datum', 'actions'];
  dataSource:GradeSubjectModel[] = [
    {subject_id: 1, grade_id: 5, date: "01.03.2024"},
    {subject_id: 1, grade_id: 4, date: "01.03.2024"},
    {subject_id: 1, grade_id: 4, date: "01.03.2024"},
    {subject_id: 1, grade_id: 5, date: "01.03.2024"},
  ];
  specificSubject:string = "";

  constructor(private route: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.specificSubject = this.route.snapshot.params['subject'];
  }
}
