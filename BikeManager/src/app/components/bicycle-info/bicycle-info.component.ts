import {Component, OnInit} from '@angular/core';
import {BicycleServiceService} from "../../services/bicycleService/bicycle-service.service";
import {AsyncPipe, NgForOf, NgIf} from "@angular/common";
import {RouterLink, RouterLinkActive} from "@angular/router";
import {IdBicycleModel} from "../../models/bicycleModel";
import {CurrencyPipe} from "../../pipes/currency/currency.pipe";
import {MatButton, MatFabButton} from "@angular/material/button";

@Component({
  selector: 'app-bicycle-info',
  standalone: true,
  imports: [
    CurrencyPipe,
    RouterLink,
    RouterLinkActive,
    AsyncPipe,
    CurrencyPipe,
    MatFabButton,
    MatButton
  ],
  templateUrl: './bicycle-info.component.html',
  styleUrl: './bicycle-info.component.scss'
})
export class BicycleInfoComponent{
  bicycles: IdBicycleModel[] = [];
  showBicycles: boolean = false;

  constructor(protected bicycleService: BicycleServiceService) { }


  toggleButtonState(): void {
    this.bicycleService.toggleButtonState();
  }


  loadBicycles(): void {
    this.bicycles = this.bicycleService.getAllBicycle();
    this.showBicycles = !this.showBicycles;
    throw new Error("dini mam")
  }
}
