import {Injectable} from '@angular/core';
import {AdminModel, MemberModel, SuperiorModel} from "../../models/memberModel";
import {TimeModel} from "../../models/timeModel";
import {MemberService} from "../memberService/member.service";

@Injectable({
  providedIn: 'root'
})
export class TimeService {
  constructor(protected memberService: MemberService) {
  }

  createNewBooking(currentUser: MemberModel | AdminModel | SuperiorModel, assignmentName: string, timeCodeName: string, startTime: Date, endTime: Date, date: Date) {
    if (startTime < endTime && startTime && endTime) {
      let newBookings: TimeModel[] = currentUser.bookings;
      let members: MemberModel[] = [];
      let superiors: SuperiorModel[] = [];
      let admins: AdminModel[] = [];
      const newBooking: TimeModel = {
        timeFrom: startTime,
        timeUntil: endTime,
        date: date,
        assignment: assignmentName,
        timeCode: timeCodeName
      }
      if (this.validateNoOverlappingBookings(newBooking, currentUser.bookings) || currentUser.bookings.length === 0) {
        newBookings.push(newBooking);
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
      } else {
        alert("Du huso gib nid z glichä i eywa")
      }
    } else {
      alert("eywa was minus zit gschaffent bisch du dum ja")
    }
    this.memberService.setCurrentUser();

  }

  editBooking(editingBooking: TimeModel,currentUser: MemberModel | AdminModel | SuperiorModel, assignmentName: string, timeCodeName: string, startTime: Date, endTime: Date, date: Date) {

  }

  deleteBooking(currentUser: MemberModel | AdminModel | SuperiorModel) {

  }

  validateNoOverlappingBookings(newBooking: TimeModel, bookings: TimeModel[]): boolean {
    let trueOrFalse: boolean = true;
    if (bookings.length !== 0) {
      for (const booking of bookings) {
        const newDate: Date = new Date(booking.date)
        const nevio = newDate.toLocaleDateString("de-DE")
        const raffi: string = newBooking.date.toLocaleDateString("de-DE")
        if (raffi === nevio) {
          const bookingTimeFrom: Date = new Date(booking.timeFrom)
          const bookingTimeUntil: Date = new Date(booking.timeUntil)
          if (!(bookingTimeUntil <= newBooking.timeFrom || newBooking.timeUntil <= bookingTimeFrom)) {
            trueOrFalse = false;
          }
        }
      }
      return trueOrFalse;
    } else {
      return true
    }
  }

  enoughLunchBrake(bookings: TimeModel[]) {
    let enoughLunchBrakeInADay: boolean = false;
    let totalWorkedTimeInMinutes: number = 0;
    let totalWorkedTimeInHours: number = 0;
    const currentDate: Date = new Date()
    if (bookings.length !== 0) {
      for (let booking of bookings) {
        const newBookingDateTimeFrom: Date = new Date(booking.timeFrom);
        const newBookingDateTimeUntil: Date = new Date(booking.timeUntil);
        if (booking.timeCode === 'Work') {
          const correctDate = new Date(booking.date).toLocaleDateString("de-DE");
          const correctCurrentDate = currentDate.toLocaleDateString("de-DE");
          if (correctDate === correctCurrentDate) {
            totalWorkedTimeInMinutes += (newBookingDateTimeUntil.getMinutes() - newBookingDateTimeFrom.getMinutes());
            totalWorkedTimeInHours += (newBookingDateTimeUntil.getHours() - newBookingDateTimeFrom.getHours());
          }
        }
      }


      const newDateBookings: TimeModel[] = this.newBookingsInRightDateFormatArray(bookings)
      const bookingLength = newDateBookings.length - 1;
      const wholeFirstTime = newDateBookings[0].timeFrom.getHours() + (newDateBookings[0].timeFrom.getMinutes() / 60);
      const wholeLastTime = newDateBookings[bookingLength].timeUntil.getHours() + (newDateBookings[bookingLength].timeUntil.getMinutes() / 60);
      const totalTimeInWorkplace = wholeLastTime - wholeFirstTime
      totalWorkedTimeInHours += (totalWorkedTimeInMinutes / 60);
      const totalBrakeTime = totalTimeInWorkplace - totalWorkedTimeInHours;
      if (totalWorkedTimeInHours >= 9 && totalBrakeTime >= 1) enoughLunchBrakeInADay = true
      if (totalWorkedTimeInHours < 9 && totalBrakeTime >= 0.5) enoughLunchBrakeInADay = true

    } else {
      return true
    }
    return enoughLunchBrakeInADay;
  }

  newBookingsInRightDateFormatArray(bookings: TimeModel[]): TimeModel[] {
    const newBooking: TimeModel[] = [];
    for (let booking of bookings) {
      const newBookingTimeFrom = new Date(booking.timeFrom);
      const newBookingTimeUntil = new Date(booking.timeUntil);
      booking.timeFrom = newBookingTimeFrom
      booking.timeUntil = newBookingTimeUntil
      newBooking.push(booking)

    }
    return newBooking.sort((a, b) => a.timeFrom.getHours() - b.timeFrom.getHours() && a.timeFrom.getMinutes() - b.timeFrom.getMinutes())
  }

  getToEditDate(newDateToEdit: Date, newStartTimeToEdit: Date, currentUser: MemberModel | AdminModel | SuperiorModel):TimeModel|undefined {
    for (let booking of currentUser.bookings) {
      const checkedBooking = new Date(booking.date)

      if (checkedBooking.toLocaleDateString('de-De') === newDateToEdit.toLocaleDateString('de-De')) {

        const newBookingTimeFrom:Date = new Date(booking.timeFrom)
        const newBookingTimeUntil:Date = new Date(booking.timeUntil)
        for (let i = (newBookingTimeFrom.getHours() * 60); i <= (newBookingTimeUntil.getHours() * 60) + newBookingTimeUntil.getMinutes(); i++) {
          if (i === (newStartTimeToEdit.getHours() * 60) + newStartTimeToEdit.getMinutes()) {
            booking.timeUntil = newBookingTimeUntil;
            booking.timeFrom = newBookingTimeFrom;
            return booking;
          }
        }
      }
    }
    return undefined
  }
}
