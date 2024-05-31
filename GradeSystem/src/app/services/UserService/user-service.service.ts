import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

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
}
