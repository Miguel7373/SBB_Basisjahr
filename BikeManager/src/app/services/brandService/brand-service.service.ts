import {Injectable} from '@angular/core';
import {BrandModel} from "../../models/brandModel";

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

  getBrand(id: number): BrandModel {
    return this.brands.find(b => b.brandId === id);
  }

  getBrandName(idName: number): string {
    const idBrandName = this.getBrand(idName);
    return idBrandName.brand
  }


}
