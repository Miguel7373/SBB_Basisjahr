import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, RouterLink} from "@angular/router";
import {MatFormField, MatLabel} from "@angular/material/form-field";
import {MatInput} from "@angular/material/input";
import {FormControl, FormGroup, ReactiveFormsModule} from "@angular/forms";
import {MatButton} from "@angular/material/button";
import {MatCheckbox} from "@angular/material/checkbox";
import {MemberService} from "../../services/memberService/member.service";
import {MatOption} from "@angular/material/autocomplete";
import {MatSelect} from "@angular/material/select";
import {AdminModel, MemberModel, SuperiorModel} from "../../models/memberModel";

@Component({
  selector: 'app-add-member',
  standalone: true,
  imports: [MatFormField, MatInput, MatLabel, ReactiveFormsModule, MatButton, RouterLink, MatCheckbox, MatOption, MatSelect],
  templateUrl: './add-member.component.html',
  styleUrl: './add-member.component.scss'
})
export class AddMemberComponent implements OnInit {
  creationType: string = 'Member';
  members: string[] = []
  newData: FormGroup = new FormGroup({
    newUsername: new FormControl(''),
    newUserSurname: new FormControl(''),
    newUserFirstname: new FormControl(''),
    newUserPassword: new FormControl(''),
    newUserDepartment: new FormControl(''),
    newUserPicture: new FormControl(''),
    member: new FormControl('')
  });

  constructor(private route: ActivatedRoute, private memberService: MemberService) {
  }

  ngOnInit() {
    this.creationType = this.route.snapshot.params['text'];
  }

  protected allMembersToAssign() {
    this.members = this.memberService.getAllMembersName()
  }

  protected onSubmit() {
    if (this.newData.value.newUsername && this.newData.value.newUserSurname && this.newData.value.newUserFirstname && this.newData.value.newUserPassword && this.newData.value.newUserDepartment) {
      if (!this.memberService.getAllMembersName().includes(this.newData.value.newUsername) && !this.memberService.getAllSuperiorName().includes(this.newData.value.newUsername) && !this.memberService.getAllAdminsName().includes(this.newData.value.newUsername)) {
        const memberId: number = this.memberService.getTotalCount() + 1;
          const memberData: MemberModel | AdminModel | SuperiorModel = {
            memberId: memberId,
            username: this.newData.value.newUsername,
            surname: this.newData.value.newUserSurname,
            firstname: this.newData.value.newUserFirstname,
            password: this.newData.value.newUserPassword,
            department: this.newData.value.newUserDepartment,
            picture: this.newData.value.newUserPicture ?? undefined,
            ...(this.newData.value.member && { members: this.newData.value.member }),
            bookings: []

          };
          this.memberService.addMember(memberData, this.creationType);
        alert('Member added successfully');
      }
      this.resetFormFields();

    }else alert('Please fill them all')
  }

  private resetFormFields() {
    this.newData.value.newUsername.reset();
    this.newData.value.newUserSurname.reset();
    this.newData.value.newUserFirstname.reset();
    this.newData.value.newUserPassword.reset();
    this.newData.value.newUserDepartment.reset();
    this.newData.value.newUserPicture.reset();
  }

}
