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

  createNewBooking(currentUser: MemberModel | AdminModel | SuperiorModel, assignmentName: string, timeCodeName: string, startTime: Date, endTime: Date, date: Date): void {
    const decimalStartTime = startTime.getHours() + (startTime.getMinutes() / 60);
    const decimalEndTime = endTime.getHours() + (endTime.getMinutes() / 60);
    if (decimalEndTime - decimalStartTime >= 0.25) {
      if (startTime < endTime && startTime && endTime) {
        let newBookings: TimeModel[] = currentUser.bookings;
        let members: MemberModel[] = [];
        let superiors: SuperiorModel[] = [];
        let admins: AdminModel[] = [];
        const newBooking: TimeModel = {
          timeFrom: startTime, timeUntil: endTime, date: date, assignment: assignmentName, timeCode: timeCodeName
        }
        console.log(newBooking)
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
          alert("Du huso gib nid z glichä i eywa");
        }
      } else {
        alert("eywa was minus zit gschaffent bisch du dum ja");
      }
    }else {
      alert("The Booking has to be longer than 15 minutes")
    }
    this.memberService.setCurrentUser();
  }

  editBooking(editingBooking: TimeModel, currentUser: MemberModel | AdminModel | SuperiorModel, newAssignmentName: string, newTimeCodeName: string, newStartTime: Date, newEndTime: Date, newDate: Date): void {
    if (this.memberService.getAllMemberIds().includes(currentUser.memberId)) {
      localStorage.setItem('members', JSON.stringify(this.editUserSpecific(this.memberService.getMemberArray(), editingBooking, currentUser, newAssignmentName, newTimeCodeName, newStartTime, newEndTime, newDate)));
    } else if (this.memberService.getAllAdminIds().includes(currentUser.memberId)) {
      localStorage.setItem('admins', JSON.stringify(this.editUserSpecific(this.memberService.getAdminArray(), editingBooking, currentUser, newAssignmentName, newTimeCodeName, newStartTime, newEndTime, newDate)));
    } else if (this.memberService.getAllSuperiorIds().includes(currentUser.memberId)) {
      localStorage.setItem('superiors', JSON.stringify(this.editUserSpecific(this.memberService.getSuperiorArray(), editingBooking, currentUser, newAssignmentName, newTimeCodeName, newStartTime, newEndTime, newDate)));
    }
  }

  deleteBooking(currentUser: MemberModel | AdminModel | SuperiorModel, editingBooking: TimeModel): void {
    if (this.memberService.getAllMemberIds().includes(currentUser.memberId)) {
      localStorage.setItem('members', JSON.stringify(this.deleteSpecificUser(currentUser, editingBooking, this.memberService.getMemberArray())));
      this.memberService.setCurrentUser()
    } else if (this.memberService.getAllAdminIds().includes(currentUser.memberId)) {
      localStorage.setItem('admins', JSON.stringify(this.deleteSpecificUser(currentUser, editingBooking, this.memberService.getAdminArray())));
      this.memberService.setCurrentUser()
    } else if (this.memberService.getAllSuperiorIds().includes(currentUser.memberId)) {
      localStorage.setItem('superiors', JSON.stringify(this.deleteSpecificUser(currentUser, editingBooking, this.memberService.getSuperiorArray())));
      this.memberService.setCurrentUser()
    }
  }

  deleteSpecificUser(currentUser: MemberModel | AdminModel | SuperiorModel, editingBooking: TimeModel, UserArray: MemberModel[] | AdminModel[] | SuperiorModel[]): MemberModel[] | AdminModel[] | SuperiorModel[] {
    let currentMember: MemberModel | undefined = UserArray.find(member => member.memberId === currentUser.memberId);
    if (currentMember) {
      let bookingIndex: number = this.findIndexOfBooking(currentMember, editingBooking);
      if (bookingIndex !== -1) currentMember.bookings.splice(bookingIndex, 1);
    }
    return UserArray;
  }

  findIndexOfBooking(currentMember: MemberModel | AdminModel | SuperiorModel, editingBooking: TimeModel): number {
    return currentMember.bookings.findIndex(booking => this.rightDateFormat(booking.timeFrom).getHours() + (this.rightDateFormat(booking.timeFrom).getMinutes() * 60) === this.rightDateFormat(editingBooking.timeFrom).getHours() + (this.rightDateFormat(editingBooking.timeFrom).getMinutes() * 60) && this.rightDateFormat(booking.date).getDate() == this.rightDateFormat(editingBooking.date).getDate());
  }

  editUserSpecific(UserArray: (MemberModel | AdminModel | SuperiorModel)[], editingBooking: TimeModel, currentUser: MemberModel | AdminModel | SuperiorModel, newAssignmentName: string, newTimeCodeName: string, newStartTime: Date, newEndTime: Date, newDate: Date): (MemberModel | AdminModel | SuperiorModel)[] {
    let currentMember: MemberModel | undefined = UserArray.find(member => member.memberId === currentUser.memberId);
    if (currentMember) {
      let bookingIndex: number = this.findIndexOfBooking(currentMember, editingBooking);
      if (bookingIndex !== -1) {
        const newBooking: TimeModel = {
          assignment: newAssignmentName,
          timeCode: newTimeCodeName,
          timeFrom: newStartTime,
          timeUntil: newEndTime,
          date: newDate
        };
        console.log(currentMember.bookings.filter(booking => booking !== JSON.parse(JSON.stringify(editingBooking))), currentMember.bookings, JSON.parse(JSON.stringify(editingBooking)))
        const newCurrentMember = currentMember.bookings.filter(booking => booking.date !== JSON.parse(JSON.stringify(editingBooking)).date && (booking.timeFrom !== JSON.parse(JSON.stringify(editingBooking)).timeFrom || booking.timeUntil !== JSON.parse(JSON.stringify(editingBooking)).timeUntil))
        console.log(newCurrentMember)
        if (this.validateNoOverlappingBookings(newBooking, newCurrentMember)) {
          currentMember.bookings[bookingIndex].assignment = newAssignmentName;
          currentMember.bookings[bookingIndex].timeCode = newTimeCodeName;
          currentMember.bookings[bookingIndex].timeFrom = newStartTime;
          currentMember.bookings[bookingIndex].timeUntil = newEndTime;
          currentMember.bookings[bookingIndex].date = newDate;
        } else {
          alert("Error: Overlapping bookings detected. Changes not applied. HS");
        }
      }
    }
    return UserArray;
  }

  rightDateFormat(date: Date): Date {
    return new Date(date);
  }

  validateNoOverlappingBookings(newBooking: TimeModel, bookings: TimeModel[]): boolean {
    let trueOrFalse: boolean = true;
    if (bookings.length !== 0) {
      for (const booking of bookings) {
        const newDate: Date = new Date(booking.date)
        const nevio: string = newDate.toLocaleDateString("de-DE")
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

  enoughLunchBrake(bookings: TimeModel[]): boolean {
    let enoughLunchBrakeInADay: boolean = false;
    let totalWorkedTimeInMinutes: number = 0;
    let totalWorkedTimeInHours: number = 0;
    const currentDate: Date = new Date()
    if (bookings.length !== 0) {
      for (let booking of bookings) {
        const newBookingDateTimeFrom: Date = new Date(booking.timeFrom);
        const newBookingDateTimeUntil: Date = new Date(booking.timeUntil);
        if (booking.timeCode === 'Work') {
          const correctDate: string = new Date(booking.date).toLocaleDateString("de-DE");
          const correctCurrentDate: string = currentDate.toLocaleDateString("de-DE");
          if (correctDate === correctCurrentDate) {
            totalWorkedTimeInMinutes += (newBookingDateTimeUntil.getMinutes() - newBookingDateTimeFrom.getMinutes());
            totalWorkedTimeInHours += (newBookingDateTimeUntil.getHours() - newBookingDateTimeFrom.getHours());
          }
        }
      }
      const newDateBookings: TimeModel[] = this.newBookingsInRightDateFormatArray(bookings)
      const bookingLength: number = newDateBookings.length - 1;
      const totalTimeInWorkplace: number = (newDateBookings[bookingLength].timeUntil.getHours() + (newDateBookings[bookingLength].timeUntil.getMinutes() / 60)) - (newDateBookings[0].timeFrom.getHours() + (newDateBookings[0].timeFrom.getMinutes() / 60));
      totalWorkedTimeInHours += (totalWorkedTimeInMinutes / 60);
      const totalBrakeTime: number = totalTimeInWorkplace - totalWorkedTimeInHours;
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
      const newBookingTimeFrom: Date = new Date(booking.timeFrom);
      const newBookingTimeUntil: Date = new Date(booking.timeUntil);
      booking.timeFrom = newBookingTimeFrom
      booking.timeUntil = newBookingTimeUntil
      newBooking.push(booking)
    }
    return newBooking.sort((a: TimeModel, b: TimeModel) => a.timeFrom.getHours() - b.timeFrom.getHours() && a.timeFrom.getMinutes() - b.timeFrom.getMinutes())
  }

  getToEditDate(newDateToEdit: Date, newStartTimeToEdit: Date, currentUser: MemberModel | AdminModel | SuperiorModel): TimeModel | undefined {
    for (let booking of currentUser.bookings) {
      const checkedBooking: Date = new Date(booking.date)
      if (checkedBooking.toLocaleDateString('de-De') === newDateToEdit.toLocaleDateString('de-De')) {
        const newBookingTimeFrom: Date = new Date(booking.timeFrom)
        const newBookingTimeUntil: Date = new Date(booking.timeUntil)
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

