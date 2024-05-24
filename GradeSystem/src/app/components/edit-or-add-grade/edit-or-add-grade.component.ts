import {Component, OnInit} from '@angular/core';
import {MatButton} from "@angular/material/button";
import {MatFormField, MatFormFieldModule, MatLabel} from "@angular/material/form-field";
import {MatIcon} from "@angular/material/icon";
import {MatInput, MatInputModule} from "@angular/material/input";
import {ActivatedRoute, RouterLink} from "@angular/router";
import {MatDatepicker, MatDatepickerModule} from "@angular/material/datepicker";
import {provideNativeDateAdapter} from "@angular/material/core";
import {TranslateModule} from "@ngx-translate/core";
import {GradeService} from "../../services/gradeService/grade.service";
import {FormControl, ReactiveFormsModule} from "@angular/forms";

@Component({
  selector: 'app-edit-or-add-grade',
  standalone: true,
  imports: [
    MatButton,
    MatFormField,
    MatIcon,
    MatInput,
    MatLabel,
    RouterLink,
    MatDatepicker,
    MatFormFieldModule,
    MatInputModule,
    MatDatepickerModule,
    TranslateModule,
    ReactiveFormsModule,
  ],
  providers: [
    provideNativeDateAdapter(),
  ],
  templateUrl: './edit-or-add-grade.component.html',
  styleUrl: './edit-or-add-grade.component.scss'
})
export class EditOrAddGradeComponent implements OnInit{


  usageOfComponent:boolean = true;
  editOrAddGrade:FormControl = new FormControl('');

  constructor(protected gradeService:GradeService, private route:ActivatedRoute) {
  }
  ngOnInit() {
    this.usageOfComponent = this.route.snapshot.params['usage'] === "add";
    if (!this.usageOfComponent){
      this.editOrAddGrade.setValue(this.gradeService.getGradeData().grade)
    }

  }

}
