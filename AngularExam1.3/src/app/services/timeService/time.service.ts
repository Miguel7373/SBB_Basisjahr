import {Injectable} from '@angular/core';
import {AdminModel, MemberModel, SuperiorModel} from "../../models/memberModel";
import {Time} from "@angular/common";
import {TimeModel} from "../../models/timeModel";
import {MemberService} from "../memberService/member.service";

@Injectable({
  providedIn: 'root'
})
export class TimeService {
  constructor(protected memberService: MemberService) {
  }

  createNewBooking(currentUser: MemberModel | AdminModel | SuperiorModel, assignmentName: string, timeCodeName: string, startTime: Time, endTime: Time, date: Date) {
    if (startTime < endTime && startTime && endTime) {
      let newBookings: TimeModel[] = currentUser.bookings;
      let members: MemberModel[] = [];
      let superiors: SuperiorModel[] = [];
      let admins: AdminModel[] = [];
      console.log(startTime.hours)
      const newBooking: TimeModel = {
        timeFrom: startTime,
        timeUntil: endTime,
        date: date,
        assignment: assignmentName,
        timeCode: timeCodeName
      }
      console.log("hallo2")
      newBookings.push(newBooking);
      if (this.validateNoOverlappingBookings(newBooking, currentUser.bookings)) {

        if (this.memberService.getAllMembersName().includes(currentUser.username)) {
          members = this.memberService.getMemberArray().map(member => member.memberId === currentUser.memberId ? {
            ...member, bookings: newBookings
          } : member);
          localStorage.setItem('members', JSON.stringify(members));
        } else if (this.memberService.getAllAdminsName().includes(currentUser.username)) {
          admins = this.memberService.getAdminArray().map(admin => admin.memberId === currentUser.memberId ? {
            ...admin, bookings: newBookings
          } : admin);
          localStorage.setItem('admins', JSON.stringify(admins));
        } else if (this.memberService.getAllSuperiorName().includes(currentUser.username)) {
          superiors = this.memberService.getSuperiorArray().map(superior => superior.memberId === currentUser.memberId ? {
            ...superior, bookings: newBookings
          } : superior);
          localStorage.setItem('superiors', JSON.stringify(superiors));
        }
      }else {
        alert("Du huso gib nid z glichä i eywa")
      }
    }else {
      alert("eywa was minus zit gschaffent bisch du dum ja")
    }
  }

  editBooking(currentUser: MemberModel | AdminModel | SuperiorModel) {

  }

  deleteBooking(currentUser: MemberModel | AdminModel | SuperiorModel) {

  }

  validateNoOverlappingBookings(newBooking: TimeModel, bookings: TimeModel[]): boolean {
    let trueOrFalse: boolean = false;
    for (const booking of bookings) if (booking.timeFrom < newBooking.timeFrom) if (booking.timeUntil < newBooking.timeFrom) trueOrFalse = true; else if (booking.timeFrom > newBooking.timeFrom) if (newBooking.timeUntil < booking.timeFrom) trueOrFalse = true; else trueOrFalse = true;
    return trueOrFalse;
  }
}
