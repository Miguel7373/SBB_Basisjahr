import {Component, OnDestroy, OnInit} from '@angular/core';
import {MatButton} from "@angular/material/button";
import {MatFormField, MatFormFieldModule, MatLabel} from "@angular/material/form-field";
import {MatIcon} from "@angular/material/icon";
import {MatInput, MatInputModule} from "@angular/material/input";
import {ActivatedRoute, Router, RouterLink} from "@angular/router";
import {MatDatepicker, MatDatepickerModule} from "@angular/material/datepicker";
import {provideNativeDateAdapter} from "@angular/material/core";
import {TranslateModule} from "@ngx-translate/core";
import {GradeService} from "../../services/gradeService/grade.service";
import {FormControl, ReactiveFormsModule} from "@angular/forms";
import {UserService} from "../../services/UserService/user-service.service";
import {Subject, takeUntil} from "rxjs";

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
export class EditOrAddGradeComponent implements OnInit, OnDestroy{

  subjectToAddGrade: number = 0;
  usageOfComponent:boolean = true;
  editOrAddGrade:FormControl = new FormControl('');
  dateOfNewGrade:FormControl = new FormControl('');
  private ngUnsubscribe:Subject<void> = new Subject<void>();
  user:any;


  constructor(protected gradeService:GradeService, private route:ActivatedRoute, private userService:UserService,private  router:Router) {
  }

  ngOnDestroy():void {
    this.ngUnsubscribe.next();
    this.ngUnsubscribe.complete();
  }
  ngOnInit():void {
    this.usageOfComponent = this.route.snapshot.params['usage'] === "add";
    this.subjectToAddGrade = this.gradeService.getSubjectId();
    if (!this.usageOfComponent){
      this.editOrAddGrade.setValue(this.gradeService.getGrade())
    }
  }
  addGrade():void{
    if (this.editOrAddGrade.valid && this.dateOfNewGrade.valid && this.editOrAddGrade.value >= 1 && this.editOrAddGrade.value <= 6) {
      const gradeInId:number = this.convertToGradeId(this.editOrAddGrade.value);
      this.userService.getCurrentUser().pipe(takeUntil(this.ngUnsubscribe)).subscribe(data =>{
      this.user = data
      this.gradeService.addGrade(this.subjectToAddGrade, gradeInId, this.dateOfNewGrade.value.toDateString(), this.user.id).pipe(takeUntil(this.ngUnsubscribe)).subscribe((res) => {
         this.router.navigate(['/home'])

      });
      })
    }else alert("Nur Nothen von 1 bis 6 erlaubt")
  }
  editGrade():void{
    if (this.editOrAddGrade.valid && this.editOrAddGrade.value >= 1 && this.editOrAddGrade.value <= 6){
      const gradeInId:number = this.convertToGradeId(this.editOrAddGrade.value);
        this.gradeService.editGrade(this.gradeService.getGradeId(), gradeInId).pipe(takeUntil(this.ngUnsubscribe)).subscribe(data =>{
          this.router.navigate(['/home'])
        });
    }
  }
  convertToGradeId(grade:number){
    let gradeInId:number = 0;
    const roundedGrade:number = this.gradeService.roundToSpecificNumber(grade);
    switch (roundedGrade){
      case 1:
        gradeInId = 1;
        break;
      case 1.25:
        gradeInId = 2;
        break;
      case 1.5:
        gradeInId = 3;
        break;
      case 1.75:
        gradeInId = 4;
        break;
      case 2:
        gradeInId = 5;
        break;
      case 2.25:
        gradeInId = 6;
        break;
      case 2.5:
        gradeInId = 7;
        break;
      case 2.75:
        gradeInId = 8;
        break;
      case 3:
        gradeInId = 9;
        break;
      case 3.25:
        gradeInId = 10;
        break;
      case 3.5:
        gradeInId = 11;
        break;
      case 3.75:
        gradeInId = 12;
        break;
      case 4:
        gradeInId = 13;
        break;
      case 4.25:
        gradeInId = 14;
        break;
      case 4.5:
        gradeInId = 15;
        break;
      case 4.75:
        gradeInId = 16;
        break;
      case 5:
        gradeInId = 17;
        break;
      case 5.25:
        gradeInId = 18;
        break;
      case 5.5:
        gradeInId = 19;
        break;
      case 5.75:
        gradeInId = 20;
        break;
      case 6:
        gradeInId = 21;
        break;
    }
    return gradeInId;
  }

}
