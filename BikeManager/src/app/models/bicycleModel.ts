
interface BicycleModel{
  bicycleId: number | undefined
  name: string | undefined
  value: number | undefined
}

export interface IdBicycleModel extends BicycleModel{
  typeIds: number[]
  brandId: number
}

export interface FullBicycleModel extends BicycleModel{
  type: string[]
  brand: string
}
