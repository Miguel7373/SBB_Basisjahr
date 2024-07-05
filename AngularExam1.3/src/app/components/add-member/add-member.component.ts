import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, RouterLink} from "@angular/router";
import {MatFormField, MatLabel} from "@angular/material/form-field";
import {MatInput} from "@angular/material/input";
import {FormControl, ReactiveFormsModule} from "@angular/forms";
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
  newUsername: FormControl = new FormControl('');
  newUserSurname: FormControl = new FormControl('');
  newUserFirstname: FormControl = new FormControl('');
  newUserPassword: FormControl = new FormControl('');
  newUserDepartment: FormControl = new FormControl('');
  newUserPicture: FormControl = new FormControl('');
  member: FormControl = new FormControl('')
  members: string[] = []


  constructor(private route: ActivatedRoute, private memberService: MemberService) {
  }

  ngOnInit() {
    this.creationType = this.route.snapshot.params['text'];
  }

  protected allMembersToAssign() {
    this.members = this.memberService.getAllMembersName()
  }

  protected onSubmit() {
    if (this.newUsername.value && this.newUserSurname.value && this.newUserFirstname.value && this.newUserPassword.value && this.newUserDepartment.value) {
      if (!this.memberService.getAllMembersName().includes(this.newUsername.value) && !this.memberService.getAllSuperiorName().includes(this.newUsername.value) && !this.memberService.getAllAdminsName().includes(this.newUsername.value)) {
        const memberId: number = this.memberService.getTotalCount() + 1;
          const memberData: MemberModel | AdminModel | SuperiorModel = {
            memberId: memberId,
            username: this.newUsername.value,
            surname: this.newUserSurname.value,
            firstname: this.newUserFirstname.value,
            password: this.newUserPassword.value,
            department: this.newUserDepartment.value,
            picture: this.newUserPicture.value ?? undefined,
            ...(this.member.value && { members: this.member.value }),
            bookings: []

          };
          this.memberService.addMember(memberData, this.creationType);
        alert('Member added successfully');
      }
      this.resetFormFields();

    }else alert('Please fill them all')
  }

  private resetFormFields() {
    this.newUsername.reset();
    this.newUserSurname.reset();
    this.newUserFirstname.reset();
    this.newUserPassword.reset();
    this.newUserDepartment.reset();
    this.newUserPicture.reset();
  }

}
