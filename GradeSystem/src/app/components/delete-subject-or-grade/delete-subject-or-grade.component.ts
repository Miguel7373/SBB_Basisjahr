import {Component, Inject} from '@angular/core';
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

@Component({
  selector: 'app-delete-subject-or-grade',
  standalone: true,
  imports: [MatDialogTitle, MatDialogContent, MatDialogActions, MatDialogClose, MatButtonModule],
  templateUrl: './delete-subject-or-grade.component.html',
  styleUrl: './delete-subject-or-grade.component.scss'
})
export class DeleteSubjectOrGradeComponent {
  constructor(public dialogRef: MatDialogRef<DeleteSubjectOrGradeComponent>, @Inject(MAT_DIALOG_DATA) public data: HomeComponent,) {

  }

}
