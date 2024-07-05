import {Component, OnDestroy, OnInit} from '@angular/core';
import {MatIcon} from "@angular/material/icon";
import {MatButton} from "@angular/material/button";
import {MatFormField, MatLabel} from "@angular/material/form-field";
import {MatInput} from "@angular/material/input";
import {ActivatedRoute, Router, RouterLink} from "@angular/router";
import {TranslateModule} from "@ngx-translate/core";
import {FormControl, ReactiveFormsModule, Validators} from "@angular/forms";
import {SubjectService} from "../../services/subjectService/subject.service";
import {Subject, takeUntil} from "rxjs";

@Component({
  selector: 'app-edit-or-add-subject',
  standalone: true,
  imports: [
    MatIcon,
    MatButton,
    MatFormField,
    MatInput,
    MatLabel,
    RouterLink,
    TranslateModule,
    ReactiveFormsModule
  ],
  templateUrl: './edit-or-add-subject.component.html',
  styleUrl: './edit-or-add-subject.component.scss'
})
export class EditOrAddSubjectComponent implements OnInit, OnDestroy{
  usageOfComponent: boolean = true;
  subjectToAddOrEdit: FormControl = new FormControl('',Validators.required);
  private ngUnsubscribe:Subject<void> = new Subject<void>();
  editSubjectId: number = 0;

  constructor(private route: ActivatedRoute, protected subjectService: SubjectService, private router: Router) {
  }

  ngOnInit():void {
    this.usageOfComponent = this.route.snapshot.params['usage'] === "add";
    if (!this.usageOfComponent) {
      this.subjectToAddOrEdit.setValue(this.subjectService.getSubjectName());
      this.editSubjectId = this.subjectService.getSubjectId();
    }
  }
  ngOnDestroy():void {
    this.ngUnsubscribe.next();
    this.ngUnsubscribe.complete();
  }

  editSubject():void {
    if (this.subjectToAddOrEdit.valid && !(this.subjectService.IsNamesOfSubjectUnique(this.subjectToAddOrEdit.value))){
    this.subjectService.editSubject(this.subjectToAddOrEdit.value, this.editSubjectId).pipe(takeUntil(this.ngUnsubscribe)).subscribe((res) => {
      this.router.navigate(['/home']);
    });
    }else alert("This Subject already Exists");
  }

  addSubject():void {
    if (this.subjectToAddOrEdit.valid && !(this.subjectService.IsNamesOfSubjectUnique(this.subjectToAddOrEdit.value))) {
      this.subjectService.createSubject(this.subjectToAddOrEdit.value).pipe(takeUntil(this.ngUnsubscribe)).subscribe((res) => {
        this.router.navigate(['/home']);
      });
    }else alert("This Subject already Exists");
  }


}
