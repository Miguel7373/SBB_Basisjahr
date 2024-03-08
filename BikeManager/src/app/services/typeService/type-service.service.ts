import { Injectable } from '@angular/core';
import {TypeModel} from "../../models/typeModel";

@Injectable({
  providedIn: 'root'
})
export class TypeServiceService {
private types: TypeModel[] = [
  {typeId: 1, type: "Mountain"},
  {typeId: 2, type: 'Road'}
]
  constructor() { }

  getType(id: number): TypeModel{
   return this.types.find(b => b.typeId === id)
  }
  getTypeName(idName: number): string{
  const isId = this.getType(idName);
  return isId.type;
  }
}
