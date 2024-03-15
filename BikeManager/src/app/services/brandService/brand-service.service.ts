import {Injectable} from '@angular/core';
import {BrandModel} from "../../models/brandModel";
import {BicycleServiceService} from "../bicycleService/bicycle-service.service";
import {TypeServiceService} from "../typeService/type-service.service";

@Injectable({
  providedIn: 'root'
})
export class BrandServiceService {
  private brands: BrandModel[] = [
    {brandId: 1, brand: 'Prada', isCheapBrand: true},
    {brandId: 2, brand: 'Nike', isCheapBrand: false},
  ]

  constructor() {
  }

  getBrandName(id: number): string {
    //@ts-ignore
    const brand = this.brands.find(b => b.brandId === id)
    if (!brand) throw new Error(`Brand with ID ${id} was not found.`);
    return brand.brand
  }

  getBrand(id: number): any {
    return this.brands.find(b => b.brandId === id);
  }
}
