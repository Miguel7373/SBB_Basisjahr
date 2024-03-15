import {type} from "node:os";

class BicycleModel{
  bicycleId: number | undefined
  name: string | undefined
  value: number | undefined
}

export class IdBicycleModel extends BicycleModel{
  typeIds: number[]
  brandId: number


  constructor(typeIds: number[], brandId: number) {
    super();
    this.typeIds = typeIds;
    this.brandId = brandId;
  }
}

export class FullBicycleModel extends BicycleModel{
  type: string[]
  brand: string

  constructor(type: string[], brand: string) {
    super();
    this.type = type;
    this.brand = brand;
  }
}
