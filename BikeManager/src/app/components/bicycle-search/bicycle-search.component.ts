import { Component } from '@angular/core';
import {FullBicycleModel} from "../../models/bicycleModel";
import {RouterLink} from "@angular/router";
import {BicycleServiceService} from "../../services/bicycleService/bicycle-service.service";
import {FormBuilder, FormControl, FormGroup, ReactiveFormsModule, Validators} from "@angular/forms";
import {NgForOf, NgIf} from "@angular/common";
import {UpperCaseWithCopyrightPipe} from "../../pipes/upperCaseWithCopyright/upper-case-with-copyright.pipe";
import {CurrencyPipe} from "../../pipes/currency/currency.pipe";

@Component({
  selector: 'app-bicycle-search',
  standalone: true,
  imports: [
    RouterLink,
    ReactiveFormsModule,
    CurrencyPipe,
    NgForOf,
    NgIf,
    UpperCaseWithCopyrightPipe,
    CurrencyPipe
  ],
  templateUrl: './bicycle-search.component.html',
  styleUrl: './bicycle-search.component.scss'
})
export class BicycleSearchComponent {
  bicycles: FullBicycleModel | undefined;
  showBicycles: boolean = false;

  constructor(private bicycleService: BicycleServiceService) {
  }
  searchBarInput: FormControl=new FormControl('')


  displayBicycle(){
    this.bicycles = this.bicycleService.getFullBicycle(this.searchBarInput.value)
    this.showBicycles = true;

  }
}
