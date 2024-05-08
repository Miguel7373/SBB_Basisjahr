import { Component } from '@angular/core';
import {MatIcon} from "@angular/material/icon";
import {MatButton} from "@angular/material/button";
import {MatFormField, MatLabel} from "@angular/material/form-field";
import {MatInput} from "@angular/material/input";
import {RouterLink} from "@angular/router";

@Component({
  selector: 'app-edit-or-add-subject',
  standalone: true,
  imports: [
    MatIcon,
    MatButton,
    MatFormField,
    MatInput,
    MatLabel,
    RouterLink
  ],
  templateUrl: './edit-or-add-subject.component.html',
  styleUrl: './edit-or-add-subject.component.scss'
})
export class EditOrAddSubjectComponent {

}
