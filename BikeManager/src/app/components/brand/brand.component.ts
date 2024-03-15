import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, RouterLink} from "@angular/router";
import { NgForOf, NgIf} from "@angular/common";
import {BicycleServiceService} from "../../services/bicycleService/bicycle-service.service";
import {BrandServiceService} from "../../services/brandService/brand-service.service";
import {FullBicycleModel} from "../../models/bicycleModel";
import {CurrencyPipe} from "../../pipes/currency/currency.pipe";
import {UpperCaseWithCopyrightPipe} from "../../pipes/upperCaseWithCopyright/upper-case-with-copyright.pipe";

@Component({
  selector: 'app-brand',
  standalone: true,
  imports: [
    RouterLink,
    NgForOf,
    CurrencyPipe,
    NgIf,
    CurrencyPipe,
    CurrencyPipe,
    CurrencyPipe,
    CurrencyPipe,
    UpperCaseWithCopyrightPipe
  ],
  templateUrl: './brand.component.html',
  styleUrl: './brand.component.scss'
})
export class BrandComponent implements OnInit{
  brandId: number = 1;
  bicycles: FullBicycleModel[] = [];
  showBicycles: boolean = false;

  constructor(protected bicycleService: BicycleServiceService, protected brandService: BrandServiceService, private route: ActivatedRoute) {
  }

  ngOnInit(): void{
    this.brandId = parseInt( this.route.snapshot.params['id'])
    console.log(this.brandId)
  }

  loadBicycles(): void {
    this.bicycles = this.bicycleService.getBicycleOfBrand(this.brandId);
    this.showBicycles = true;
  }
}
