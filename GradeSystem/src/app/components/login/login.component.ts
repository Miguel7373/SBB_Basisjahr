import {Component, OnDestroy, OnInit} from '@angular/core';
import {MatFormField, MatLabel} from "@angular/material/form-field";
import {MatInput} from "@angular/material/input";
import {MatButton} from "@angular/material/button";
import {ActivatedRoute, Router, RouterLink} from "@angular/router";
import {TranslateModule} from "@ngx-translate/core";
import {FormControl, ReactiveFormsModule} from "@angular/forms";
import {Subject, takeUntil} from "rxjs";
import {UserService} from "../../services/UserService/user-service.service";
import {UserModel} from "../../models/UserModel";


@Component({
  selector: 'app-login',
  standalone: true,
  imports: [
    MatFormField,
    MatInput,
    MatLabel,
    MatButton,
    RouterLink,
    TranslateModule,
    ReactiveFormsModule
  ],
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss'
})
export class LoginComponent implements OnInit, OnDestroy {
  email: FormControl = new FormControl('');
  password: FormControl = new FormControl('');
  fullName: FormControl = new FormControl('')
  loginOrRegister: boolean = true;
  private ngUnsubscribe = new Subject<void>();

  constructor(private route: ActivatedRoute, private userService: UserService, private router: Router) {
  }

  ngOnDestroy() {
    this.ngUnsubscribe.next();
    this.ngUnsubscribe.complete();
  }

  ngOnInit() {
  }

  login() {
    if (this.email.valid && this.password.valid) {
      this.userService.login(this.email.value, this.password.value).pipe(takeUntil(this.ngUnsubscribe)).subscribe((data) => {
        localStorage.setItem('token', data.token)
        this.router.navigate(['/home']);
      })
    }
  }

  register() {
    if (this.password.valid && this.email.valid && this.fullName.valid) {
      this.userService.signup(this.email.value, this.password.value, this.fullName.value).pipe(takeUntil(this.ngUnsubscribe)).subscribe((data:UserModel) => {
        this.router.navigate(['/login'])
      })
    }
  }

  goToRegister() {
    this.loginOrRegister = !this.loginOrRegister;
  }
}
