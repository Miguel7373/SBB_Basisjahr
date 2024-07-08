import {TimeModel} from "./timeModel";

export interface MemberModel{
  memberId: number;
  username: string;
  surname:string;
  firstname:string;
  password:string;
  department: string;
  picture?: string;
  bookings: TimeModel[];
}
export interface AdminModel extends MemberModel{
}
export interface SuperiorModel extends MemberModel{
  members:string[];
}

