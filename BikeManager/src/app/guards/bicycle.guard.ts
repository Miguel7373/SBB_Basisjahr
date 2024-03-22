import { CanActivateFn } from '@angular/router';
import { BicycleServiceService} from "../services/bicycleService/bicycle-service.service";
import {inject} from "@angular/core";


export const bicycleGuard: CanActivateFn = (route, state) => {
  return inject(BicycleServiceService).getState();
};
