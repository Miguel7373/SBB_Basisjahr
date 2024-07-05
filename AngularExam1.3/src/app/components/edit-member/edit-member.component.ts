import {Component, OnInit} from '@angular/core';
import {MatButton, MatIconButton} from "@angular/material/button";
import {MatFormField, MatLabel} from "@angular/material/form-field";
import {MatInput} from "@angular/material/input";
import {MatOption} from "@angular/material/autocomplete";
import {MatSelect} from "@angular/material/select";
import {FormControl, FormGroup, ReactiveFormsModule} from "@angular/forms";
import {ActivatedRoute, Router, RouterLink} from "@angular/router";
import {MatIcon} from "@angular/material/icon";
import {MemberService} from "../../services/memberService/member.service";

@Component({
  selector: 'app-edit-member',
  standalone: true,
  imports: [MatButton, MatFormField, MatInput, MatLabel, MatOption, MatSelect, ReactiveFormsModule, RouterLink, MatIcon, MatIconButton],
  templateUrl: './edit-member.component.html',
  styleUrl: './edit-member.component.scss'
})
export class EditMemberComponent implements OnInit {
  userName: string = "";
  member: FormControl = new FormControl('')
  members: string[] = []


  newData: FormGroup = new FormGroup({
    newUsername: new FormControl(''),
    newSurname: new FormControl(''),
    newFirstname: new FormControl(''),
    newPassword: new FormControl(''),
    newDepartment: new FormControl(''),
    newPicture: new FormControl(''),
  });


  constructor(private route: ActivatedRoute, protected memberService: MemberService, private router: Router) {
  }

  ngOnInit(): void {
    this.userName = this.route.snapshot.params['user'];
    const currentUser = this.memberService.getUserByUsername(this.userName);
    this.newData.setValue({
      newUsername: this.userName,
      newSurname: currentUser?.surname,
      newFirstname: currentUser?.firstname,
      newPassword: currentUser?.password,
      newDepartment: currentUser?.department,
      newPicture: currentUser?.picture
    });
  }

  protected onSubmit() {
    if (this.newData.value.newUsername && this.newData.value.newSurname && this.newData.value.newFirstname && this.newData.value.newPassword && this.newData.value.newDepartment){
    this.memberService.editUser(this.userName, this.newData.value.newUsername, this.newData.value.newSurname, this.newData.value.newFirstname, this.newData.value.newPassword, this.newData.value.newDepartment, this.newData.value.newPicture, this.members);
    this.router.navigate(['/settings']).then(() => {
      window.location.reload();
    });
    }else alert("Fill them all")
  }

  protected allMembersToAssign() {
    this.members = this.memberService.getAllMembersName()
  }
}
