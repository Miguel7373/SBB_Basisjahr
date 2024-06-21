import {Component, OnDestroy, OnInit} from '@angular/core';
import {MatIcon} from "@angular/material/icon";
import {MatButton} from "@angular/material/button";
import {MatFormField, MatLabel} from "@angular/material/form-field";
import {MatInput} from "@angular/material/input";
import {ActivatedRoute, Router, RouterLink} from "@angular/router";
import {TranslateModule} from "@ngx-translate/core";
import {FormControl, ReactiveFormsModule} from "@angular/forms";
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
  subjectToAddOrEdit: FormControl = new FormControl('');
  private ngUnsubscribe = new Subject<void>();
  editSubjectId: number = 0

  constructor(private route: ActivatedRoute, protected subjectService: SubjectService, private router: Router) {
  }

  ngOnInit() {
    this.usageOfComponent = this.route.snapshot.params['usage'] === "add";
    if (!this.usageOfComponent) {
      this.subjectToAddOrEdit.setValue(this.subjectService.getSubjectName())
      this.editSubjectId = this.subjectService.getSubjectId();
    }
  }
  ngOnDestroy() {
    this.ngUnsubscribe.next();
    this.ngUnsubscribe.complete();
  }

  editSubject() {
    this.subjectService.editSubject(this.subjectToAddOrEdit.value, this.editSubjectId).pipe(takeUntil(this.ngUnsubscribe)).subscribe((res) => {
      this.router.navigate(['/home']);
    });
  }

  addSubject() {
    console.log(this.subjectToAddOrEdit.value);
    this.subjectService.createSubject(this.subjectToAddOrEdit.value).pipe(takeUntil(this.ngUnsubscribe)).subscribe((res) => {
      this.router.navigate(['/home']);
    })
  }


}
