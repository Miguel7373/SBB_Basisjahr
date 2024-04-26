import {Router, RouterLink} from "@angular/router";
import {MatButton, MatIconButton} from "@angular/material/button";
import {Component, OnInit} from "@angular/core";
import {MemberService} from "../../services/memberService/member.service";
import {AdminModel, MemberModel, SuperiorModel} from "../../models/memberModel";
import {MatIcon} from "@angular/material/icon";
import {MatTooltip} from "@angular/material/tooltip";
import {DatePipe, NgStyle} from "@angular/common";
import {TimeService} from "../../services/timeService/time.service";
import {MatFormField, MatLabel} from "@angular/material/form-field";
import {MatOption} from "@angular/material/autocomplete";
import {MatSelect} from "@angular/material/select";
import {FormControl, ReactiveFormsModule} from "@angular/forms";

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [MatButton, RouterLink, MatIcon, MatIconButton, MatTooltip, DatePipe, MatFormField, MatLabel, MatOption, MatSelect, ReactiveFormsModule, NgStyle],
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
  members: string[] = [];
  showingMember: string[] = [];
  selectedMembers: FormControl = new FormControl(["King"])
  colors = ['#92A8D1', '#759FC8', '#A1BBD9', '#6B90BF', '#9EB5CC'];
  topMinutesBooking: number = 0;
  bottomMinutesBooking: number = 0;

  constructor(protected memberService: MemberService, protected timeService: TimeService, private router: Router) {
  }

  ngOnInit() {
    this.currentUser = this.memberService.getCurrentUser();
    if (this.currentUser) if (!this.memberService.getAllSuperiorIds().includes(this.currentUser.memberId)) {
      this.members.push(this.currentUser.username);
    }
    if (this.currentUser) this.showingMember.push(this.currentUser?.username, ...this.memberService.getAllOfSuperiorsMembersName());
    this.initWeek();
    this.exactDate = this.currentWeekStart;
    this.memberService.setCurrentUser();
    this.initWeek();

  }

  loadAllMembers(member: string) {
    if (!this.members.find(m => this.memberService.getUserByUsername(m)?.memberId === this.memberService.getUserByUsername(member)?.memberId)) {
      this.members.push(member);
    } else {
      this.members = this.members.filter(m => this.memberService.getUserByUsername(m)?.memberId !== this.memberService.getUserByUsername(member)?.memberId)
    }
  }

  initWeek(): void {
    this.currentWeekStart = this.getStartOfWeek();
    this.currentWeekEnd = this.getEndOfWeek(this.currentWeekStart);
    this.weekDays = ['Sun', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat'];
    this.timeSlots = ['12:00 AM', '1:00 AM', '2:00 AM', '3:00 AM', '4:00 AM', '5:00 AM', '6:00 AM', '7:00 AM', '8:00 AM', '9:00 AM', '10:00 AM', '11:00 AM', '12:00 PM', '1:00 PM', '2:00 PM', '3:00 PM', '4:00 PM', '5:00 PM', '6:00 PM', '7:00 PM', '8:00 PM', '9:00 PM', '10:00 PM', '11:00 PM'];
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
    endOfWeek.setHours(0, 0, 0, 0);
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
      switch (day) {
        case 'Sun' : {
          this.exactDate?.setDate(this.currentWeekStart?.getDate() + 0);
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

  toAddEvent(time: string, day: string, usage: string) {
    const date = this.getDateOfDay(day)
    if (date) {
      this.router.navigate(["event", usage]);
      this.memberService.setCreatingDate(time, `${date}`)
    }
  }

  getAllBookings(member: string) {
    return this.memberService.getUserByUsername(member)?.bookings ?? []
  }

  getWeekDayOfDate(dateString: Date) {
    const h = this.getNormalDate(dateString)
    if (h) {
      const date = new Date(h)
      const dayIndex = date.getDay();
      if (this.weekDays) {
        return this.weekDays[dayIndex]
      }
    }
    return undefined
  }

  getNormalDate(cursedDate: Date) {
    if (cursedDate) {
      const NormalDate: Date = new Date(cursedDate)
      return NormalDate;
    } else {
      return undefined
    }
  }

  getRightBookingStartTime(timeFrom: Date, timeSlot: string) {
    const newTimeFrom = new Date(timeFrom)
    const timeSlotHours = parseInt(this.convertTo24Hour(timeSlot));
    return newTimeFrom.getHours() <= timeSlotHours;
  }

  firstTimeOfBooking(timeFrom: Date, timeSlot: string) {
    const newDateTimeFrom: Date = new Date(timeFrom)
    const timeSlotHours = parseInt(this.convertTo24Hour(timeSlot));


    return timeSlotHours == newDateTimeFrom.getHours();
  }

  getRightBookingEndTime(timeUntil: Date, timeSlot: string) {
    const newDateTimeUntil = new Date(timeUntil);
    const timeSlotHours = parseInt(this.convertTo24Hour(timeSlot));
    if (newDateTimeUntil.getMinutes() > 0 && newDateTimeUntil.getHours() === timeSlotHours) {
      return true
    }
    return newDateTimeUntil.getHours() > timeSlotHours;
  }


  convertTo24Hour(time12h: string): string {
    const [time, period] = time12h.split(' ');
    let [hours, minutes] = time.split(':').map(Number);
    if (period === 'PM' && hours < 12) {
      hours += 12;
    } else if (period === 'AM' && hours === 12) {
      hours = 0;
    }
    return `${hours.toString().padStart(2, '0')}`;
  }

  enoughLunchTimeADay(): boolean | undefined {
    if (this.currentUser?.bookings) return this.timeService.enoughLunchBrake(this.currentUser?.bookings);
    return undefined
  }


  calculateBookingsInTimeSlot(day: number, timeslot: number, members: string[]): number {
    let amount = 1;
    members.forEach(member => {
      const user = this.memberService.getUserByUsername(member);
      if (user) {
        user.bookings.forEach(booking => {
          let [hoursFrom, minutesFrom] = `${booking.timeFrom}`.split(':').map(Number);
          let [hoursUntil, minutesUntil] = `${booking.timeUntil}`.split(':').map(Number);
          for (let i = hoursFrom; i < hoursUntil; i++) {
            const newDate = new Date(booking.date)
            if (!(minutesUntil > 0) && hoursUntil === i) {
              if (this.currentWeekStart && this.currentWeekEnd) if (day === newDate.getDay() && i === timeslot && newDate >= this.currentWeekStart && newDate <= this.currentWeekEnd) {
                amount++;
              }
            }

          }
        });
      }
    });
    return amount;
  }

  topOfMinutesBooking(day: number, timeslot: number, timeFrom: Date, timeUntil: Date): string {
    const newTimeFrom = new Date(timeFrom);
    const newTimeUntil = new Date(timeUntil);
    newTimeFrom.setMinutes(newTimeFrom.getMinutes())
    for (let i = newTimeFrom.getHours(); i <= newTimeUntil.getHours(); i++) {
      if ((newTimeFrom.getMinutes() > 0) && newTimeFrom.getHours() === i) {
        if (newTimeFrom.getMinutes() !== 0 && i === timeslot) {
          this.topMinutesBooking = newTimeFrom.getMinutes() * 100 / 60;
          return newTimeFrom.getMinutes() * 100 / 60 + "%";
        }
      }
    }
    this.topMinutesBooking = 0;
    return "0";
    // min * 100 / 60
    // bottom minutes und top minutes in % dan zusammen - 100% gibt height

  }

  bottomOfMinutesBooking(day: number, timeslot: number, timeUntil: Date, timeFrom: Date): string {
    const newTimeUntil: Date = new Date(timeUntil)
    const newTimeFrom: Date = new Date(timeFrom)
    newTimeUntil.setMinutes(newTimeUntil.getMinutes());
    for (let i = newTimeFrom.getHours(); i <= newTimeUntil.getHours(); i++) {
      if ((newTimeUntil.getMinutes() > 0) && newTimeUntil.getHours() === i) {
        if (newTimeUntil.getMinutes() !== 0 && i === timeslot) {
          this.bottomMinutesBooking = (60 - newTimeUntil.getMinutes()) * 100 / 60;
          return (60 - newTimeUntil.getMinutes()) * 100 / 60 + "%";
        }
      }
    }
    this.bottomMinutesBooking = 0;
    return "0";

  }

  heightOfBooking(): number {
    return 100 - (this.topMinutesBooking + this.bottomMinutesBooking)
  }
}
