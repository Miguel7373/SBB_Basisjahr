import {Injectable} from '@angular/core';
import {FullBicycleModel, IdBicycleModel} from "../../models/bicycleModel";
import {TypeModel} from "../../models/typeModel"
import {TypeServiceService} from "../typeService/type-service.service";
import {BrandServiceService} from "../brandService/brand-service.service";
import {BrandModel} from "../../models/brandModel";
import {BehaviorSubject, Observable} from "rxjs";


@Injectable({
  providedIn: 'root'
})
export class BicycleServiceService {
  private bicycles: IdBicycleModel[] = [
    {bicycleId: 1, name: 'Mountain Bike', value: 500, typeIds: [1], brandId: 1},
    {bicycleId: 2, name: 'Road Bike', value: 4000000000000, typeIds: [2,1], brandId: 2},
  ]

  constructor(private typeService: TypeServiceService, private brandService: BrandServiceService) {
  }

  private buttonStateSubject = new BehaviorSubject<boolean>(true);

  getState(): boolean{
    return this.buttonStateSubject.value
}

  toggleButtonState(): void {
    this.buttonStateSubject.next(!this.buttonStateSubject.value);
  }


  getBicycle(id: number): IdBicycleModel {
    console.log(typeof id)
    const bicycle = this.bicycles.find(b=> b.bicycleId === +id)
    if (!bicycle){
      throw new Error(`Bicycle With the ID ${id} was not found.`)
    }
    return bicycle;
  }

  getAllBicycle(): IdBicycleModel[] {
    return this.bicycles;
  }
  getFullBicycle(id: number): FullBicycleModel {
    const bicycle = this.getBicycle(id);
    if (bicycle) {
      return {
        bicycleId: bicycle.bicycleId ,
        name: bicycle.name ,
        value: bicycle.value ,
        type: this.typeService.getTypeName(bicycle.typeIds),
        brand: this.brandService.getBrandName(bicycle.brandId)
      }
    }else {
      return {
        bicycleId: 0 ,
        name: "" ,
        value: 0 ,
        type: [],
        brand: ""
      };
    }
  }
  getBicycleByBrandId(id: number): IdBicycleModel[] {
    const bicycle = this.bicycles.filter(bicycle => bicycle.brandId === id);
    if (!bicycle) throw new Error(`Brand with ID ${id} was not found.`);
    return bicycle
  }
  getBicycleOfBrand(id:number): FullBicycleModel[] {
    const brand = this.brandService.getBrand(id)
    const bicycle: IdBicycleModel[] = this.getBicycleByBrandId(brand.brandId)
    if (bicycle) {
      return bicycle.map(b => ({
        bicycleId: b.bicycleId,
        name: b.name,
        value: b.value,
        type: this.typeService.getTypeName(b.typeIds),
        brand: this.brandService.getBrandName(b.brandId)
      }))
    }else {
      return [];
    }
  }

}

