import {Injectable} from '@angular/core';
import {TimecodesModel} from "../../models/timecodesModel";

@Injectable({
  providedIn: 'root'
})
export class TimeCodesService {
  private timecodes: TimecodesModel[] = []

  setLocalStorageData() {
    localStorage.setItem('timecodes', JSON.stringify(this.timecodes));
  }

  constructor() {
    if (!(localStorage.getItem('timecodes')) || JSON.parse((localStorage.getItem('timecodes')) ?? "").length === 0) {
      this.timecodes.push({
        timecodesId: 1,
        description: "Sick"
      }, {
        timecodesId: 2,
        description: "Compensation"
      }, {
        timecodesId: 3,
        description: "Professional school"
      }, {
        timecodesId: 4,
        description: "Holidays"
      },{
        timecodesId:5,
        description: "Work"
      })

    }else {
      this.timecodes = [
        ...JSON.parse(localStorage.getItem('timecodes')?? "")
      ]
    }
    this.setLocalStorageData();
  }

  addTimeCode(newTimeCodeName: string): void {
    this.timecodes.push({timecodesId: this.totalCountOfTimeCodes(), description: newTimeCodeName});
    localStorage.setItem('timecodes', JSON.stringify(this.timecodes))
  }
  totalCountOfTimeCodes(): number{
    const storedTimeCodes: string| null = localStorage.getItem('timecodes');
    if (storedTimeCodes){
      const timeCodes: TimecodesModel[] = JSON.parse(storedTimeCodes);
      return timeCodes.length + 1;
    }
    return 1
  }
  getAllTimeCodesDescriptions(){
    return this.timecodes.map(timeCode => timeCode.description);
  }

}
