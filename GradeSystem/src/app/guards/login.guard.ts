import {CanActivateFn, Router} from '@angular/router';
import {inject} from "@angular/core";
import {UserService} from "../services/UserService/user-service.service";

export const loginGuard: CanActivateFn = ():boolean => {
  if (!inject(UserService).loginBool){
    inject(Router).navigate(['/']);
    return false
  }
  return true
};

