export class BrandModel {
  brandId: number
  brand: string
  isCheapBrand: boolean



  constructor(brandId: number, brand: string, isCheapBrand: boolean) {
    this.brandId = brandId;
    this.brand = brand;
    this.isCheapBrand = isCheapBrand;
  }
}
