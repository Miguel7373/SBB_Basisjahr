import {Router, RouterLink} from "@angular/router";
import {MatButton, MatIconButton} from "@angular/material/button";
import {Component, OnInit} from "@angular/core";
import {MemberService} from "../../services/memberService/member.service";
import {AdminModel, MemberModel, SuperiorModel} from "../../models/memberModel";
import {MatIcon} from "@angular/material/icon";
import {MatTooltip} from "@angular/material/tooltip";
import {DatePipe} from "@angular/common";

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [MatButton, RouterLink, MatIcon, MatIconButton, MatTooltip, DatePipe],
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss',
})
export class HomeComponent implements OnInit {
  exactDate: Date | undefined;
  currentWeekStart: Date | undefined;
  currentWeekEnd: Date | undefined;
  weekDays: string[] | undefined;
  timeSlots: string[] | undefined;
  currentUser: MemberModel | SuperiorModel | AdminModel | undefined;
  currentWeekStartString?: string = "";
  currentWeekEndString?: string = "";

  constructor(protected memberService: MemberService, private router: Router) {
  }

  ngOnInit() {
    this.currentUser = this.memberService.getCurrentUser();
    this.initWeek();
    this.exactDate = this.currentWeekStart;
  }

  initWeek(): void {
    this.currentWeekStart = this.getStartOfWeek();
    this.currentWeekEnd = this.getEndOfWeek(this.currentWeekStart);
    this.weekDays = ['Sun', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat'];
    this.timeSlots = ['6:00 AM', '7:00 AM', '8:00 AM', '9:00 AM', '10:00 AM', '11:00 AM', '12:00 PM', '1:00 PM', '2:00 PM', '3:00 PM', '4:00 PM', '5:00 PM', "6:00 PM", '7:00 PM'];
    this.currentWeekEndString = this.currentWeekEnd?.toDateString();
    this.currentWeekStartString = this.currentWeekStart?.toDateString();
  }

  getStartOfWeek(): Date {
    const startOfWeek = new Date();
    startOfWeek.setHours(0, 0, 0, 0);
    startOfWeek.setDate(startOfWeek.getDate() - startOfWeek.getDay());
    return startOfWeek;
  }

  getEndOfWeek(startOfWeek: Date): Date {
    const endOfWeek = new Date(startOfWeek);
    endOfWeek.setDate(endOfWeek.getDate() + 6);
    endOfWeek.setHours(23, 59, 59, 999);
    return endOfWeek;
  }

  previousWeek(): void {
    if (this.currentWeekStart && this.currentWeekEnd) {
      this.currentWeekStart.setDate(this.currentWeekStart.getDate() - 7);
      this.currentWeekEnd.setDate(this.currentWeekEnd.getDate() - 7);
      this.currentWeekEndString = this.currentWeekEnd?.toDateString();
      this.currentWeekStartString = this.currentWeekStart?.toDateString();
    }
  }

  nextWeek(): void {
    if (this.currentWeekStart && this.currentWeekEnd) {
      this.currentWeekStart.setDate(this.currentWeekStart.getDate() + 7);
      this.currentWeekEnd.setDate(this.currentWeekEnd.getDate() + 7);
      this.currentWeekEndString = this.currentWeekEnd?.toDateString();
      this.currentWeekStartString = this.currentWeekStart?.toDateString();
    }
  }

  getDateOfDay(day: string) {

    if (this.currentWeekStart && this.exactDate) {
      console.log(this.currentWeekStart.getDate())
      switch (day) {
        case 'Sun' : {
          this.exactDate?.setDate(this.currentWeekStart?.getDate() + 0);
          console.log(this.currentWeekStart.getDate())
          return this.exactDate;
        }
        case 'Mon' : {
          this.exactDate?.setDate(this.currentWeekStart?.getDate() + 1);
          return this.exactDate;
        }
        case 'Tue': {
          this.exactDate?.setDate(this.currentWeekStart.getDate() + 2);
          return this.exactDate;
        }
        case 'Wed': {
          this.exactDate?.setDate(this.currentWeekStart.getDate() + 3);
          return this.exactDate;
        }
        case 'Thu': {
          this.exactDate?.setDate(this.currentWeekStart.getDate() + 4);
          return this.exactDate;
        }
        case 'Fri': {
          this.exactDate?.setDate(this.currentWeekStart.getDate() + 5);
          return this.exactDate;
        }
        case 'Sat': {
          this.exactDate?.setDate(this.currentWeekStart.getDate() + 6);
          return this.exactDate;
        }
      }
    }
    return undefined
  }

  toAddEvent(time: string, day: string) {
    const date = this.getDateOfDay(day)
    const StringDate = date?.toDateString();
    this.router.navigate(["addEvent", time, StringDate])
  }
}
