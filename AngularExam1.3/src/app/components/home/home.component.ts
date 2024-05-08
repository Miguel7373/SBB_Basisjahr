import {Router, RouterLink} from "@angular/router";
import {MatButton, MatIconButton} from "@angular/material/button";
import {Component, OnInit} from "@angular/core";
import {MemberService} from "../../services/memberService/member.service";
import {AdminModel, MemberModel, SuperiorModel} from "../../models/memberModel";
import {MatIcon} from "@angular/material/icon";
import {MatTooltip} from "@angular/material/tooltip";
import {DatePipe, NgForOf, NgIf, NgStyle} from "@angular/common";
import {TimeService} from "../../services/timeService/time.service";
import {MatFormField, MatLabel} from "@angular/material/form-field";
import {MatOption} from "@angular/material/autocomplete";
import {MatSelect} from "@angular/material/select";
import {FormControl, ReactiveFormsModule} from "@angular/forms";
import {TimeModel} from "../../models/timeModel";
import {AssignmentService} from "../../services/assignmentService/assignment.service";
import {MatSlideToggle} from "@angular/material/slide-toggle";

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [MatButton, RouterLink, MatIcon, MatIconButton, MatTooltip, DatePipe, MatFormField, MatLabel, MatOption, MatSelect, ReactiveFormsModule, NgStyle, MatSlideToggle, NgForOf, NgIf],
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
  showingAssignments: string[] = [];
  favAssignment: FormControl = new FormControl((localStorage.getItem('favoriteAssignment') || ''))
  selectedMembers: FormControl = new FormControl([this.memberService.getCurrentUser()?.username])
  colors:string[] = ['#92A8D1', '#759FC8', '#A1BBD9', '#6B90BF', '#9EB5CC'];
  topMinutesBooking: number = 0;
  bottomMinutesBooking: number = 0;
  startTime: Date | null = null;
  stopTime: Date | null = null;

  constructor(protected memberService: MemberService, private timeService: TimeService, private assignmentService: AssignmentService, private router: Router) {
  }

  ngOnInit() {
    this.currentUser = this.memberService.getCurrentUser();
    if (this.currentUser) if (!this.memberService.getAllSuperiorIds().includes(this.currentUser.memberId)) this.members.push(this.currentUser.username);
    this.showingAssignments = this.assignmentService.getAllAssignmentsName();
    if (this.currentUser) this.showingMember.push(this.currentUser?.username, ...this.memberService.getAllOfSuperiorsMembersName());
    this.initWeek();
    this.exactDate = this.currentWeekStart;
    this.memberService.setCurrentUser();
    this.initWeek();

  }

  protected localStorageFavAssignment() {
    localStorage.setItem('favoriteAssignment', this.favAssignment.value);
  }

  protected onToggleChange(event: any) {
    const todayDate: Date = new Date(Date.now());
    if (event.checked) this.startTime = new Date();
    else this.stopTime = new Date();
    if (this.startTime !== null && this.stopTime !== null) {
      if (this.currentUser) this.timeService.createNewBooking(this.currentUser, localStorage.getItem('favoriteAssignment') ?? "", 'Work', this.startTime, this.stopTime, todayDate)
      this.startTime = null;
      this.stopTime = null;
    }
  }

  protected loadAllMembers(member: string) {
    if (!this.members.find(m => this.memberService.getUserByUsername(m)?.memberId === this.memberService.getUserByUsername(member)?.memberId)) {
      this.members.push(member);
    } else {
      this.members = this.members.filter(m => this.memberService.getUserByUsername(m)?.memberId !== this.memberService.getUserByUsername(member)?.memberId)
    }
  }

  protected previousWeek(): void {
    if (this.currentWeekStart && this.currentWeekEnd) {
      this.currentWeekStart.setDate(this.currentWeekStart.getDate() - 7);
      this.currentWeekEnd.setDate(this.currentWeekEnd.getDate() - 7);
      this.currentWeekEndString = this.currentWeekEnd?.toDateString();
      this.currentWeekStartString = this.currentWeekStart?.toDateString();
    }
  }

  protected nextWeek(): void {
    if (this.currentWeekStart && this.currentWeekEnd) {
      this.currentWeekStart.setDate(this.currentWeekStart.getDate() + 7);
      this.currentWeekEnd.setDate(this.currentWeekEnd.getDate() + 7);
      this.currentWeekEndString = this.currentWeekEnd?.toDateString();
      this.currentWeekStartString = this.currentWeekStart?.toDateString();
    }
  }

  protected toAddEvent(time: string, day: string, usage: string) {
    const date: Date | undefined = this.getDateOfDay(day);
    if (date) {
      this.router.navigate(["event", usage]);
      this.memberService.setCreatingDate(time, `${date}`);
    }
  }

  protected getAllBookings(member: string): TimeModel[] {
    return this.memberService.getUserByUsername(member)?.bookings ?? [];
  }

  protected getWeekDayOfDate(dateString: Date): string | undefined {
    const dayIndex: number = new Date(this.getNormalDate(dateString) ?? "").getDay();
    if (this.weekDays) return this.weekDays[dayIndex];
    return undefined;
  }

  protected getNormalDate(cursedDate: Date): Date | undefined {
    if (cursedDate) return new Date(cursedDate);
    else return undefined;
  }

  protected getRightBookingStartTime(timeFrom: Date, timeSlot: string): boolean {
    return new Date(timeFrom).getHours() <= parseInt(this.convertTo24Hour(timeSlot));
  }

  protected firstTimeOfBooking(timeFrom: Date, timeSlot: string): boolean {
    return parseInt(this.convertTo24Hour(timeSlot)) == new Date(timeFrom).getHours();
  }

  protected getRightBookingEndTime(timeUntil: Date, timeSlot: string): boolean {
    const newDateTimeUntil: Date = new Date(timeUntil);
    const timeSlotHours: number = parseInt(this.convertTo24Hour(timeSlot));
    if (newDateTimeUntil.getMinutes() > 0 && newDateTimeUntil.getHours() === timeSlotHours) return true;
    return newDateTimeUntil.getHours() > timeSlotHours;
  }

  protected enoughLunchTimeADay(): boolean | undefined {
    if (this.currentUser?.bookings) return this.timeService.enoughLunchBrake(this.currentUser?.bookings);
    return;
  }

  protected calculateBookingsInTimeSlot(day: number, timeslot: number, members: string[]): number {
    let amount: number = 1;
    members.forEach(member => {
      const user: MemberModel | AdminModel | SuperiorModel | undefined = this.memberService.getUserByUsername(member);
      if (user) {
        user.bookings.forEach(booking => {
          let [hoursFrom, minutesFrom] = `${booking.timeFrom}`.split(':').map(Number);
          let [hoursUntil, minutesUntil] = `${booking.timeUntil}`.split(':').map(Number);
          for (let i = hoursFrom; i < hoursUntil; i++) {
            const newDate: Date = new Date(booking.date)
              if (!(minutesUntil > 0) && hoursUntil === i && this.currentWeekStart && this.currentWeekEnd && day === newDate.getDay() && i === timeslot && newDate >= this.currentWeekStart && newDate <= this.currentWeekEnd) {
                amount++;
              }
          }
        });
      }
    });
    return amount;
  }

  protected topOfMinutesBooking(timeslot: number, timeFrom: Date, timeUntil: Date): string {
    const newTimeFrom: Date = new Date(timeFrom);
    newTimeFrom.setMinutes(newTimeFrom.getMinutes())
    for (let i = newTimeFrom.getHours(); i <= new Date(timeUntil).getHours(); i++) {
      if ((newTimeFrom.getMinutes() > 0) && newTimeFrom.getHours() === i && newTimeFrom.getMinutes() !== 0 && i === timeslot) {
        this.topMinutesBooking = newTimeFrom.getMinutes() * 100 / 60;
        return newTimeFrom.getMinutes() * 100 / 60 + "%";
      }
    }
    this.topMinutesBooking = 0;
    return "0";
  }

  protected bottomOfMinutesBooking(timeslot: number, timeUntil: Date, timeFrom: Date): string {
    const newTimeUntil: Date = new Date(timeUntil)
    newTimeUntil.setMinutes(newTimeUntil.getMinutes());
    for (let i = new Date(timeFrom).getHours(); i <= newTimeUntil.getHours(); i++) {
      if ((newTimeUntil.getMinutes() > 0) && newTimeUntil.getHours() === i && newTimeUntil.getMinutes() !== 0 && i === timeslot) {
        this.bottomMinutesBooking = (60 - newTimeUntil.getMinutes()) * 100 / 60;
        return (60 - newTimeUntil.getMinutes()) * 100 / 60 + "%";
      }
    }
    this.bottomMinutesBooking = 0;
    return "0";
  }

  protected heightOfBooking(): number {
    return 100 - (this.topMinutesBooking + this.bottomMinutesBooking)
  }

  private initWeek(): void {
    this.currentWeekStart = this.getStartOfWeek();
    this.currentWeekEnd = this.getEndOfWeek(this.currentWeekStart);
    this.weekDays = ['Sun', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat'];
    this.timeSlots = ['12:00 AM', '1:00 AM', '2:00 AM', '3:00 AM', '4:00 AM', '5:00 AM', '6:00 AM', '7:00 AM', '8:00 AM', '9:00 AM', '10:00 AM', '11:00 AM', '12:00 PM', '1:00 PM', '2:00 PM', '3:00 PM', '4:00 PM', '5:00 PM', '6:00 PM', '7:00 PM', '8:00 PM', '9:00 PM', '10:00 PM', '11:00 PM'];
    this.currentWeekEndString = this.currentWeekEnd?.toDateString();
    this.currentWeekStartString = this.currentWeekStart?.toDateString();
  }

  private getStartOfWeek(): Date {
    const startOfWeek: Date = new Date();
    startOfWeek.setDate(startOfWeek.getDate() - startOfWeek.getDay());
    return startOfWeek;
  }

  private getEndOfWeek(startOfWeek: Date): Date {
    const endOfWeek: Date = new Date(startOfWeek);
    endOfWeek.setDate(endOfWeek.getDate() + 6);
    return endOfWeek;
  }

  private getDateOfDay(day: string): Date | undefined {
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

  private convertTo24Hour(time12h: string): string {
    const [time, period] = time12h.split(' ');
    let [hours, minutes] = time.split(':').map(Number);
    if (period === 'PM' && hours < 12) hours += 12;
    else if (period === 'AM' && hours === 12) hours = 0;
    return `${hours.toString().padStart(2, '0')}`;
  }
}










































