import {CanActivateFn, Router} from '@angular/router';
import {inject} from "@angular/core";
import {MemberService} from "../services/memberService/member.service";

export const loginGuard: CanActivateFn = (route, state) => {
  if(inject(MemberService).getCurrentUser() === undefined){
    inject(Router).navigate(["/"]);
    return false;
  }
  return inject(MemberService).getCurrentUser() !== undefined;
};
