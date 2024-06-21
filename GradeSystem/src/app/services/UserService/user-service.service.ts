import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {UserModel} from "../../models/UserModel";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) {
  }
  login(email:string, password:string){
    return this.http.post<{token: string, expiresIn: number}>('http://localhost:8080/auth/login',{
      email: email,
      password: password
    });
  }
  getCurrentUser() {
    return this.http.get('http://localhost:8080/users/me');
  }
  signup(email:string, password:string, fullName:string){
    return this.http.post<UserModel>('http://localhost:8080/auth/signup', {
      email:email,
      password:password,
      fullName:fullName
    })
  }

}
