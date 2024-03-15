import {type} from "node:os";

export class TypeModel{
  typeId: number
  typename: string


  constructor(typeId: number, typename: string) {
    this.typeId = typeId;
    this.typename = typename;
  }
}

