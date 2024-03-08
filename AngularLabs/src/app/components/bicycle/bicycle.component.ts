import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Bicycle, BicycleImage, GoogleCustomSearchResponse } from '../interfaces';
import {NgForOf, NgIf} from "@angular/common";
import {FormControl, ReactiveFormsModule} from "@angular/forms";

@Component({
  selector: 'app-bicycle',
  templateUrl: './bicycle.component.html',
  styleUrls: ['./bicycle.component.scss'],
  imports: [
    NgIf,
    NgForOf,
    ReactiveFormsModule
  ],
  standalone: true
})

export class BicycleComponent implements OnInit {
  public bicycle: Bicycle = { name: '', url: '' };
  favoriteBicycle: BicycleImage[] = [];

  constructor(private httpClient: HttpClient) {}

  searchBarInput: FormControl=new FormControl('')

  ngOnInit(): void {
    this.bicycle.name = 'Specialized Diverge Pro Carbon';
    this.bicycle.url =
      'https://assets.specialized.com/i/specialized/96220-10_DIVERGE-PRO-CARBON-ETAP-REDWD-SMK-CHRM_HERO?bg=rgb(241,241,241)&w=2500&h=1406&fmt=auto';
  }

  public displayBicycleName() {
    alert(this.searchBarInput.value);
  }

  public getFavoriteBicycleImage() {
    const url =
      'https://www.googleapis.com/customsearch/v1?key=AIzaSyDNGfS6NUdgwXOwKu9xlZPJFm84ylG6J4g&cx=005124428384360536924:rstfldysumw&q=' +
      this.searchBarInput.value +
      '&searchType=image&safe=high';

    this.httpClient.get<GoogleCustomSearchResponse>(url).subscribe((response: GoogleCustomSearchResponse) => {
      for (let i = 0; i < 4; i++) {
        let item: BicycleImage = response.items[i];
        item.image.height = (200 / item.image.width) * item.image.height;
        item.image.width = 200;
        this.favoriteBicycle.push(item);
      }
    });
  }
}
