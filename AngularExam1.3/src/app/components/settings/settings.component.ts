import {Component, OnInit} from '@angular/core';
import {MatIcon} from "@angular/material/icon";
import {MatButton, MatIconButton} from "@angular/material/button";
import {MatTooltip} from "@angular/material/tooltip";
import {RouterLink} from "@angular/router";
import {MemberService} from "../../services/memberService/member.service";
import {AdminModel, MemberModel, SuperiorModel} from "../../models/memberModel";
import {MatFormField, MatInput, MatLabel} from "@angular/material/input";
import {FormControl, ReactiveFormsModule} from "@angular/forms";
import {AssignmentService} from "../../services/assignmentService/assignment.service";
import {TimeCodesService} from "../../services/timecodesService/time-codes.service";
import {MatSlideToggle} from "@angular/material/slide-toggle";

@Component({
  selector: 'app-settings',
  standalone: true,
  imports: [MatIcon, MatIconButton, MatTooltip, RouterLink, MatButton, MatInput, MatFormField, MatLabel, ReactiveFormsModule, MatSlideToggle],
  templateUrl: './settings.component.html',
  styleUrl: './settings.component.scss'
})
export class SettingsComponent implements OnInit {
  popUpAssignment: boolean = false;
  currentUser: MemberModel | SuperiorModel | AdminModel | undefined;
  allMembers: string[] | undefined;
  showMembers: boolean = false;
  popUpTimeCode: boolean = false;
  popUpEdit: boolean = false;
  passwordOrPicture: boolean = true;
  newAssignmentName: FormControl = new FormControl('');
  newTimeCodeName: FormControl = new FormControl('');
  newPassword: FormControl = new FormControl('');
  newPicture: FormControl = new FormControl('')

  constructor(protected memberService: MemberService, protected assignmentService: AssignmentService, protected timecodesService: TimeCodesService) {
  }
  ngOnInit() {
    this.currentUser = this.memberService.getCurrentUser();
  }

  loadAllMembers() {
    this.allMembers = [...(this.memberService.getAllMembersName() || []), ...(this.memberService.getAllAdminsName() || []), ...(this.memberService.getAllSuperiorName() || [])];
    this.showMembers = !this.showMembers;
  }

  createAssignment() {
    if (this.newAssignmentName.value){
    this.popUpAssignment = !this.popUpAssignment;
    this.assignmentService.addAssignment(this.newAssignmentName.value);
    }else {
      console.log("No Name Detected")
    }
  }

  loadAssignment() {
    this.popUpAssignment = !this.popUpAssignment;
  }

  deleteMember(member: string) {
    this.memberService.deleteMember(member)
  }

  createTimeCode() {
    if (this.newTimeCodeName.value){
    this.popUpTimeCode = !this.popUpTimeCode;
    this.timecodesService.addTimeCode(this.newTimeCodeName.value)
    }else {
      console.log("No Name Detected")
    }
  }

  loadTimeCode() {
    this.popUpTimeCode = !this.popUpTimeCode;
  }

  createEdit() {
    this.popUpEdit = !this.popUpEdit;
    if (this.currentUser) {

      this.memberService.editMembersOwnProfile(this.currentUser, this.newPassword.value, this.newPicture.value, this.passwordOrPicture);
    }
  }

  loadEdit() {
    this.popUpEdit = !this.popUpEdit;
  }

  changeEdit() {
    this.passwordOrPicture = !this.passwordOrPicture;
  }

  show() {
    console.log(localStorage.getItem('admins'))
    console.log(localStorage.getItem('members'))
    console.log(localStorage.getItem('superiors'))
  }
}
