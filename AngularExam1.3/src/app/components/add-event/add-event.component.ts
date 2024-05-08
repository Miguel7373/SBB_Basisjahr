import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, RouterLink} from "@angular/router";
import {FormControl, ReactiveFormsModule} from "@angular/forms";
import {MatIcon} from "@angular/material/icon";
import {MatButton, MatIconButton} from "@angular/material/button";
import {MatTooltip} from "@angular/material/tooltip";
import {MatFormField, MatLabel} from "@angular/material/form-field";
import {MatInput} from "@angular/material/input";
import {AssignmentService} from "../../services/assignmentService/assignment.service";
import {MatOption} from "@angular/material/autocomplete";
import {MatSelect} from "@angular/material/select";
import {TimeCodesService} from "../../services/timecodesService/time-codes.service";
import {TimeService} from "../../services/timeService/time.service";
import {MemberService} from "../../services/memberService/member.service";
import {AdminModel, MemberModel, SuperiorModel} from "../../models/memberModel";
import {TimeModel} from "../../models/timeModel";

@Component({
  selector: 'app-add-event',
  standalone: true,
  imports: [
    ReactiveFormsModule,
    MatIcon,
    MatIconButton,
    MatTooltip,
    RouterLink,
    MatFormField,
    MatInput,
    MatLabel,
    MatButton,
    MatOption,
    MatSelect
  ],
  templateUrl: './add-event.component.html',
  styleUrl: './add-event.component.scss'
})
export class AddEventComponent implements OnInit {
  startTime: string = JSON.parse(localStorage.getItem('creatingTime') ?? "");
  date: string = JSON.parse(localStorage.getItem('creatingDate') ?? "");
  newStart: FormControl = new FormControl('10:00');
  newEnd: FormControl = new FormControl('');
  assignments: string[] = this.assignmentService.getAllAssignmentsName();
  selectedAssignments: FormControl = new FormControl('');
  timeCodes: string[] = this.timeCodesService.getAllTimeCodesDescriptions();
  selectedTimeCode: FormControl = new FormControl('');
  usage: string = this.route.snapshot.params['usage'];
  clickedBookingTimeFrom: string = "";
  clickedBookingTimeUntil: string = "";
  clickedBookingAssignment: string = "";
  clickedBookingTimeCode: string = "";
  startTimeEdit: FormControl = new FormControl('');
  endTimeEdit: FormControl = new FormControl('');
  assignmentsEdit: string = "";
  timeCodeEdit: string = "";
  currentUser: MemberModel | SuperiorModel | AdminModel | undefined = this.memberService.getCurrentUser()
  editingBooking: TimeModel | undefined;

  constructor(private route: ActivatedRoute,
              private assignmentService: AssignmentService,
              private timeCodesService: TimeCodesService,
              private timeService: TimeService,
              private memberService: MemberService,) {
  }

  ngOnInit() {
    this.newStart.reset(this.startTime)
    this.getClickedBooking()
    this.newStart.setValue(this.convertTo24Hour(this.startTime))
    console.log(this.convertTo24Hour(this.startTime))
    this.endTimeEdit.setValue(this.clickedBookingTimeUntil);
    this.startTimeEdit.setValue(this.clickedBookingTimeFrom);
    this.assignmentsEdit = (this.clickedBookingAssignment);
    this.timeCodeEdit = (this.clickedBookingTimeCode);
  }

  protected CreateNewBookingForUser() {
    if (this.date && this.currentUser) {
      const newDateTimeStart: Date = new Date();
      const newDateTimeEnd: Date = new Date();
      let [hoursStart, minutesStart] = this.newStart.value.split(':').map(Number);
      let [hoursEnd, minutesEnd] = this.newEnd.value.split(':').map(Number);
      newDateTimeStart.setHours(hoursStart);
      newDateTimeStart.setMinutes(minutesStart);
      newDateTimeEnd.setHours(hoursEnd);
      newDateTimeEnd.setMinutes(minutesEnd);
      const newDate: Date = new Date(this.date);
      if (this.selectedAssignments.value && this.selectedTimeCode.value) {
        this.timeService.createNewBooking(this.currentUser, this.selectedAssignments.value, this.selectedTimeCode.value, newDateTimeStart, newDateTimeEnd, newDate)
      } else {
        alert("Please select them all")
      }
    }
  }

  protected editBooking() {
    if (this.date && this.currentUser) {
      const newEditDateTimeStart: Date = new Date();
      const newEditDateTimeEnd: Date = new Date();
      let [hoursStart, minutesStart] = this.startTimeEdit.value.split(':').map(Number);
      let [hoursEnd, minutesEnd] = this.endTimeEdit.value.split(':').map(Number);
      newEditDateTimeStart.setHours(hoursStart);
      newEditDateTimeStart.setMinutes(minutesStart);
      newEditDateTimeEnd.setHours(hoursEnd);
      newEditDateTimeEnd.setMinutes(minutesEnd);
      const newDate: Date = new Date(this.date);
      if (this.editingBooking) this.timeService.editBooking(this.editingBooking, this.currentUser, this.assignmentsEdit, this.timeCodeEdit, newEditDateTimeStart, newEditDateTimeEnd, newDate)
    }
  }

  protected deleteBooking() {
    if (this.editingBooking && this.currentUser) this.timeService.deleteBooking(this.currentUser, this.editingBooking)
  }

  private getClickedBooking() {
    if (this.date && this.currentUser) {
      const newDateToEdit: Date = new Date(this.date);
      let [hours, minutes] = `${this.convertTo24Hour(this.startTime)}`.split(':').map(Number);
      const newStartTimeToEdit: Date = new Date();
      newStartTimeToEdit.setHours(hours, minutes);
      this.editingBooking = this.timeService.getToEditDate(newDateToEdit, newStartTimeToEdit, this.currentUser);
      const formatTime = (hour: number, minute: number) => `${(hour < 10 ? '0' : '') + hour}:${(minute < 10 ? '0' : '') + minute}`;
      const newHoursTimeFrom: string = formatTime(this.editingBooking?.timeFrom.getHours() || 0, this.editingBooking?.timeFrom.getMinutes() || 0);
      const newHoursTimeUntil: string = formatTime(this.editingBooking?.timeUntil.getHours() || 0, this.editingBooking?.timeUntil.getMinutes() || 0);
      this.clickedBookingTimeUntil = newHoursTimeUntil;
      this.clickedBookingTimeFrom = newHoursTimeFrom;
      if (this.editingBooking?.assignment) this.clickedBookingAssignment = this.editingBooking?.assignment;
      if (this.editingBooking?.timeCode) this.clickedBookingTimeCode = this.editingBooking?.timeCode;
    }

  }

  private convertTo24Hour(time12h: string): string {
    const [time, period] = time12h.split(' ');
    let [hours, minutes] = time.split(':').map(Number);
    if (period === 'PM' && hours < 12) {
      hours += 12;
    } else if (period === 'AM' && hours === 12) {
      hours = 0;
    }
    return `${hours.toString().padStart(2, '0')}:${minutes.toString().padStart(2, '0')}`;
  }
}

