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
  colors: string[] = ['#00838F', '#007D8A', '#007380', '#00788C', '#007A91'];
  ErrorColors: string[] = ['#FF6666', '#FF4C4C', '#FF3333', '#E63333', '#CC0000'];
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
  handleImageError():void {
    const imgElement:HTMLImageElement = document.querySelector('.profilePicture') as HTMLImageElement;
    imgElement.src = 'data:image/png;base64,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';
  }

  rightColor(user: number, booking: Date): string {
    const rightDate: Date = new Date(booking)
    if (this.enoughLunchTimeADay(rightDate) === false) {
      return this.ErrorColors[user];
    } else {
      return this.colors[user]
    }
  }

  protected localStorageFavAssignment() {
    localStorage.setItem('favoriteAssignment', this.favAssignment.value);
  }

  protected onToggleChange(event: any) {
    const todayDate: Date = new Date(Date.now());
    if (event.checked) this.startTime = new Date(); else this.stopTime = new Date();
    if (this.startTime !== null && this.stopTime !== null) {
      if (this.currentUser) this.timeService.createNewBooking(this.currentUser, localStorage.getItem('favoriteAssignment') ?? "", 'Work', this.startTime, this.stopTime, todayDate)
      this.startTime = null;
      this.stopTime = null;
      window.location.reload();
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
    if (cursedDate) return new Date(cursedDate); else return undefined;
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

  protected enoughLunchTimeADay(date: Date): boolean | undefined {
    if (this.currentUser?.bookings) return this.timeService.enoughLunchBrake(this.currentUser?.bookings, date);
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
    if (period === 'PM' && hours < 12) hours += 12; else if (period === 'AM' && hours === 12) hours = 0;
    return `${hours.toString().padStart(2, '0')}`;
  }

}

