import {Time} from "@angular/common";

export interface TimeModel{
  timeFrom:Time;
  timeUntil:Time;
  date: Date;
  assignment: string;
  timeCode: string;
}
