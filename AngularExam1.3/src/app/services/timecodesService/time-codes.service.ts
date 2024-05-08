import {Injectable} from '@angular/core';
import {TimecodesModel} from "../../models/timecodesModel";

@Injectable({
  providedIn: 'root'
})
export class TimeCodesService {
  private timecodes: TimecodesModel[] = []

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
      }, {
        timecodesId: 5,
        description: "Work"
      })

    } else {
      this.timecodes = [
        ...JSON.parse(localStorage.getItem('timecodes') ?? "")
      ]
    }
    this.setLocalStorageData();
  }

  setLocalStorageData(): void {
    localStorage.setItem('timecodes', JSON.stringify(this.timecodes));
  }

  getTimeCodesNames() {
    return this.timecodes.map(timeCode => timeCode.description)
  }

  addTimeCode(newTimeCodeName: string): void {
    if (!this.getTimeCodesNames().includes(newTimeCodeName)) {
      this.timecodes.push({timecodesId: this.totalCountOfTimeCodes(), description: newTimeCodeName});
      localStorage.setItem('timecodes', JSON.stringify(this.timecodes))
    }
  }

  totalCountOfTimeCodes(): number {
    const storedTimeCodes: string | null = localStorage.getItem('timecodes');
    if (storedTimeCodes) {
      const timeCodes: TimecodesModel[] = JSON.parse(storedTimeCodes);
      return timeCodes.length + 1;
    }
    return 1
  }

  getAllTimeCodesDescriptions(): string[] {
    return this.timecodes.map(timeCode => timeCode.description);
  }

}
