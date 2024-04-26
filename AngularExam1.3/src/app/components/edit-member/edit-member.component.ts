import {Component, OnInit} from '@angular/core';
import {MatButton, MatIconButton} from "@angular/material/button";
import {MatFormField, MatLabel} from "@angular/material/form-field";
import {MatInput} from "@angular/material/input";
import {MatOption} from "@angular/material/autocomplete";
import {MatSelect} from "@angular/material/select";
import {FormControl, ReactiveFormsModule} from "@angular/forms";
import {ActivatedRoute, RouterLink} from "@angular/router";
import {MatIcon} from "@angular/material/icon";
import {MemberService} from "../../services/memberService/member.service";

@Component({
  selector: 'app-edit-member',
  standalone: true,
  imports: [
    MatButton,
    MatFormField,
    MatInput,
    MatLabel,
    MatOption,
    MatSelect,
    ReactiveFormsModule,
    RouterLink,
    MatIcon,
    MatIconButton
  ],
  templateUrl: './edit-member.component.html',
  styleUrl: './edit-member.component.scss'
})
export class EditMemberComponent implements OnInit {
  userName: string = "";
  selected: string | undefined = undefined;
  allAttributes: string[] | undefined;
  member: FormControl = new FormControl('')
  members: string[] = []
  newData: FormControl = new FormControl('')

  constructor(private route: ActivatedRoute, protected memberService: MemberService) {
  }
  onSubmit() {
    if (this.selected) {
      this.memberService.editUserParts(this.selected, this.userName, this.member.value, this.newData.value);
    }
  }
  ngOnInit(): void {
    this.userName = this.route.snapshot.params['user'];
  }
  loadAllMembers() {
    if (this.memberService.getAllSuperiorName().includes(this.userName)) {
      this.allAttributes = this.memberService.getAllSuperiorAttributes();
    } else {
      this.allAttributes = this.memberService.getAllMemberAttributes()
    }
  }
  allMembersToAssign() {
    this.members = this.memberService.getAllMembersName()
  }
}
