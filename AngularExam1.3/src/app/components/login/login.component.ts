import {Component, OnInit} from '@angular/core';
import {FormControl, ReactiveFormsModule} from "@angular/forms";
import {MemberService} from "../../services/memberService/member.service";
import {MatFormField, MatLabel, MatSuffix} from "@angular/material/form-field";
import {MatInput} from "@angular/material/input";
import {MatIcon} from "@angular/material/icon";
import {MatButton, MatIconButton} from "@angular/material/button";

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [ReactiveFormsModule, MatFormField, MatInput, MatLabel, MatIcon, MatIconButton, MatSuffix, MatButton,],
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss'
})
export class LoginComponent implements OnInit {
  username: FormControl = new FormControl('');
  userPassword: FormControl = new FormControl('');

  constructor(protected memberService: MemberService) {
  }

  ngOnInit() {
    localStorage.setItem('currentUser', "");
  }

  protected login(): void {
    this.memberService.login(this.username.value, this.userPassword.value);
  }



}
