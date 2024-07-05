import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {UserModel} from "../../models/UserModel";

@Injectable({
  providedIn: 'root'
})
export class UserService {
  loginBool: boolean = false;
  basisURL:string = `http://localhost:8080`;

  constructor(private http: HttpClient) {
  }
  login(email:string, password:string){
    this.loginBool = true;
    return this.http.post<{token: string, expiresIn: number}>(this.basisURL + '/auth/login',{
      email: email,
      password: password
    });
  }
  getCurrentUser() {
    return this.http.get(this.basisURL + '/users/me');
  }
  signup(email:string, password:string, fullName:string){
    return this.http.post<UserModel>(this.basisURL + '/auth/signup', {
      email:email,
      password:password,
      fullName:fullName
    })
  }

}
