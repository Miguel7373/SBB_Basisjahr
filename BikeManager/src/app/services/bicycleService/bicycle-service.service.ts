import {Injectable} from '@angular/core';
import {BicycleModel} from "../../models/bicycleModel";
import {TypeModel} from "../../models/typeModel"
import {TypeServiceService} from "../typeService/type-service.service";
import {BrandServiceService} from "../brandService/brand-service.service";
import {BrandModel} from "../../models/brandModel";


@Injectable({
  providedIn: 'root'
})
export class BicycleServiceService {
  private bicycles: BicycleModel[] = [
    {bicycleId: 1, name: 'Mountain Bike', value: 500, typeId: 1, brandId: 1},
    {bicycleId: 2, name: 'Road Bike', value: 400, typeId: 2, brandId: 2},
  ]

  constructor(private typeService: TypeServiceService, private brandService: BrandServiceService) {
  }

  getBicycle(id: number): BicycleModel {
    return this.bicycles.find(b => b.bicycleId === id);
  }

  getAllBicycle(): BicycleModel[] {
    return this.bicycles.map(b => ({
      bicycleId: b.bicycleId,
      name: b.name,
      value: b.value,
      typeId: b.typeId,
      brandId: b.brandId
    }));
  }
  getFullBicycle(id: number): any {
    const bicycle = this.bicycles.find(b => b.bicycleId === id);
    if (bicycle) {
      const type: TypeModel = this.typeService.getType(bicycle.typeId);
      const brand: BrandModel = this.brandService.getBrand(bicycle.brandId);
      return this.bicycles.map(b =>({
        bicycleId: b.bicycleId,
        name: b.name,
        value: b.value,
        typeId: type ?  type.typeId : '',
        brandId: brand ? brand.brandId : '',
      }))

    }else {
      return null;
    }
  }
}
