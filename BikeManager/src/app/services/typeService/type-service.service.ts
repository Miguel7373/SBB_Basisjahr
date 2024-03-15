import {Injectable} from '@angular/core';
import {TypeModel} from "../../models/typeModel";

@Injectable({
  providedIn: 'root'
})
export class TypeServiceService {
  private types: TypeModel[] = [
    {typeId: 1, typename: "Mountain"},
    {typeId: 2, typename: 'Road'}
  ]

  constructor() {
  }

  getTypeName(ids: number[]): string[] {
    return ids.map(id => {
      //@ts-ignore
      const type = this.types.find(b => b.typeId === id)
      if (!type) throw new Error(`Brand with ID ${id} was not found.`);
      return type.typename
    });
  }

  getType(ids: number[]): TypeModel[] {

    return ids.map(id => {
      //@ts-ignore
      const type = this.types.find(b => b.typeId == id)
      if (!type) throw new Error(`Brand with ID ${id} was not found.`);
      return type
    })
  }
}
