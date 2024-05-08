import { Component } from '@angular/core';
import {MatButton} from "@angular/material/button";
import {MatFormField, MatLabel} from "@angular/material/form-field";
import {MatIcon} from "@angular/material/icon";
import {MatInput} from "@angular/material/input";
import {RouterLink} from "@angular/router";

@Component({
  selector: 'app-edit-or-add-grade',
  standalone: true,
    imports: [
        MatButton,
        MatFormField,
        MatIcon,
        MatInput,
        MatLabel,
        RouterLink
    ],
  templateUrl: './edit-or-add-grade.component.html',
  styleUrl: './edit-or-add-grade.component.scss'
})
export class EditOrAddGradeComponent {

}
