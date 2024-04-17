import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, RouterLink} from "@angular/router";
import {FormControl, ReactiveFormsModule} from "@angular/forms";
import {MatIcon} from "@angular/material/icon";
import {MatButton, MatIconButton} from "@angular/material/button";
import {MatTooltip} from "@angular/material/tooltip";
import {MatFormField, MatLabel} from "@angular/material/form-field";
import {MatInput} from "@angular/material/input";
import {Time} from "@angular/common";
import {AssignmentService} from "../../services/assignmentService/assignment.service";
import {MatOption} from "@angular/material/autocomplete";
import {MatSelect} from "@angular/material/select";
import {TimeCodesService} from "../../services/timecodesService/time-codes.service";
import {TimeService} from "../../services/timeService/time.service";
import {MemberService} from "../../services/memberService/member.service";
import {AdminModel, MemberModel, SuperiorModel} from "../../models/memberModel";

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
  startTime: string = '06:00';
  date?: string;
  newStart: FormControl = new FormControl('');
  newEnd: FormControl = new FormControl('');
  assignments: string[] = [];
  selectedAssignments: FormControl = new FormControl('');
  timeCodes: string[] = [];
  selectedTimeCode: FormControl = new FormControl('');


  constructor(private route: ActivatedRoute, protected assignmentService:AssignmentService, protected timeCodesService:TimeCodesService,protected bookingService:TimeService,protected memberService:MemberService) {
  }

  ngOnInit() {
    const time: Time = ({hours: 7, minutes:30})

    this.startTime = this.route.snapshot.params['time'];
    this.date = this.route.snapshot.params['date'];
    this.startTime = this.convertTo24Hour(this.startTime);
    this.newStart.reset(this.startTime)
    console.log(this.newStart.value)

    console.log(this.startTime)
  }
  convertTo24Hour(time12h: string): string {
    const [time, period] = time12h.split(' ');
    let [hours, minutes] = time.split(':').map(Number);
    if (period === 'PM' && hours < 12) {
      hours += 12;
    } else if (period === 'AM' && hours === 12) {
      hours = 0;
    }
    return `${hours.toString().padStart(2, '0')}:${minutes.toString().padStart(2, '0')}`;
  }
  getAllAssignments(){
    this.assignments = this.assignmentService.getAllAssignmentsName();
  }
  getAllTimeCodes(){
    this.timeCodes = this.timeCodesService.getAllTimeCodesDescriptions();
  }
  CreateNewBookingForUser(){
    const user: MemberModel|AdminModel|SuperiorModel|undefined = this.memberService.getCurrentUser();
    if (this.date && user){
    const newDate: Date = new Date(this.date);
      console.log("hallo")
      this.bookingService.createNewBooking(user,this.selectedAssignments.value,this.selectedTimeCode.value,this.newStart.value, this.newEnd.value,newDate)

    }
  }
  print(){
    console.log(this.memberService.getCurrentUser()?.bookings)

  }
}

