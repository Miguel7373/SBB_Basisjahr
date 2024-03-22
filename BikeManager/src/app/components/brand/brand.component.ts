import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, RouterLink} from "@angular/router";
import { NgForOf, NgIf} from "@angular/common";
import {BicycleServiceService} from "../../services/bicycleService/bicycle-service.service";
import {BrandServiceService} from "../../services/brandService/brand-service.service";
import {FullBicycleModel} from "../../models/bicycleModel";
import {CurrencyPipe} from "../../pipes/currency/currency.pipe";
import {UpperCaseWithCopyrightPipe} from "../../pipes/upperCaseWithCopyright/upper-case-with-copyright.pipe";
import {MatRadioButton, MatRadioGroup} from "@angular/material/radio";
import {FormsModule} from "@angular/forms";
import {MatProgressSpinnerModule} from "@angular/material/progress-spinner";
import {MatSlider, MatSliderThumb} from "@angular/material/slider";
import {MatButton} from "@angular/material/button";


@Component({
  selector: 'app-brand',
  standalone: true,
  imports: [
    RouterLink,
    UpperCaseWithCopyrightPipe,
    MatRadioGroup,
    MatRadioButton,
    FormsModule,
    MatProgressSpinnerModule,
    MatSlider,
    MatSliderThumb,
    MatButton,
    CurrencyPipe

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
  }

  loadBicycles(): void {
    this.bicycles = this.bicycleService.getBicycleOfBrand(this.brandId);
    this.showBicycles = true;
  }
}
