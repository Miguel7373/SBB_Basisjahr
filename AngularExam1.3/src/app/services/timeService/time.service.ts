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
    const decimalStartTime: number = startTime.getHours() + (startTime.getMinutes() / 60);
    const decimalEndTime: number = endTime.getHours() + (endTime.getMinutes() / 60);
    if (decimalEndTime - decimalStartTime >= 0.25) {
      if (startTime < endTime && startTime && endTime) {
        let newBookings: TimeModel[] = currentUser.bookings;
        let members: MemberModel[] = [];
        let superiors: SuperiorModel[] = [];
        let admins: AdminModel[] = [];
        const newBooking: TimeModel = {
          timeFrom: startTime, timeUntil: endTime, date: date, assignment: assignmentName, timeCode: timeCodeName
        }
        if (this.validateNoOverlappingBookings(newBooking, currentUser.bookings) || currentUser.bookings.length === 0) {
          newBookings.push(newBooking);
          if (this.memberService.getAllMembersName().includes(currentUser.username)) {
            localStorage.setItem('members', JSON.stringify(this.createBooking(members, newBookings , this.memberService.getMemberArray(), currentUser)));
          } else if (this.memberService.getAllAdminsName().includes(currentUser.username)) {
            localStorage.setItem('admins', JSON.stringify(this.createBooking(admins, newBookings , this.memberService.getAdminArray(), currentUser)));
          } else if (this.memberService.getAllSuperiorName().includes(currentUser.username)) {
            localStorage.setItem('superiors', JSON.stringify(this.createBooking(superiors, newBookings , this.memberService.getSuperiorArray(), currentUser)));
          }
        } else {
          alert("You can't work at the same Time");
        }
      } else {
        alert("You cant work minus hours");
      }
    } else {
      alert("Invalid Booking")
    }
    this.memberService.setCurrentUser();
  }
  createBooking(users:MemberModel[] | AdminModel[] | SuperiorModel[], newBookings: TimeModel[], userArray: MemberModel[] | AdminModel[] | SuperiorModel[], currentUser:MemberModel | AdminModel | SuperiorModel): MemberModel[] | AdminModel[] | SuperiorModel[] {
    users = userArray.map(user => user.memberId === currentUser.memberId ? {
      ...user, bookings: newBookings
    } : user);
    return users
  }

  editBooking(editingBooking: TimeModel, currentUser: MemberModel | AdminModel | SuperiorModel, newAssignmentName: string, newTimeCodeName: string, newStartTime: Date, newEndTime: Date, newDate: Date): void {
    if (this.memberService.getAllMemberIds().includes(currentUser.memberId)) {
      localStorage.setItem('members', JSON.stringify(this.editUserSpecific(this.memberService.getMemberArray(), editingBooking, currentUser, newAssignmentName, newTimeCodeName, newStartTime, newEndTime, newDate)));
    } else if (this.memberService.getAllAdminIds().includes(currentUser.memberId)) {
      localStorage.setItem('admins', JSON.stringify(this.editUserSpecific(this.memberService.getAdminArray(), editingBooking, currentUser, newAssignmentName, newTimeCodeName, newStartTime, newEndTime, newDate)));
    } else if (this.memberService.getAllSuperiorIds().includes(currentUser.memberId)) {
      localStorage.setItem('superiors', JSON.stringify(this.editUserSpecific(this.memberService.getSuperiorArray(), editingBooking, currentUser, newAssignmentName, newTimeCodeName, newStartTime, newEndTime, newDate)));
    }
    this.memberService.setCurrentUser();
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
        const newCurrentMember:TimeModel[] = currentMember.bookings.filter(booking => booking.date !== JSON.parse(JSON.stringify(editingBooking)).date && (booking.timeFrom !== JSON.parse(JSON.stringify(editingBooking)).timeFrom || booking.timeUntil !== JSON.parse(JSON.stringify(editingBooking)).timeUntil))
        if (newBooking.timeFrom < newBooking.timeUntil && newBooking.timeFrom && newBooking.timeUntil) {
          if (this.validateNoOverlappingBookings(newBooking, newCurrentMember)) {

            currentMember.bookings[bookingIndex].assignment = newAssignmentName;
            currentMember.bookings[bookingIndex].timeCode = newTimeCodeName;
            currentMember.bookings[bookingIndex].timeFrom = newStartTime;
            currentMember.bookings[bookingIndex].timeUntil = newEndTime;
            currentMember.bookings[bookingIndex].date = newDate;
          } else {
            alert("Error: Overlapping bookings detected. Changes not applied.");
          }
        } else alert("You cant Work minus houers")
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
        const newRightDate: string = newDate.toLocaleDateString("de-DE")
        const newBookingDate: string = newBooking.date.toLocaleDateString("de-DE")
        if (newBookingDate === newRightDate) {
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

  enoughLunchBrake(bookings: TimeModel[], date: Date): boolean {
    let totalWorkedTimeInMinutes: number = 0;
    let totalWorkedTimeInHours: number = 0;
    const currentDate: Date = date;
    let newDateBookings: TimeModel[] = this.newBookingsInRightDateFormatArray(bookings);
    newDateBookings = newDateBookings.filter(booking => new Date(booking.date).getDay() === currentDate.getDay());
    if (newDateBookings.length >= 2) {
      newDateBookings = newDateBookings.sort((a, b) => {
        const timeA:number = new Date(a.timeFrom).getHours() + (new Date(a.timeFrom).getMinutes() / 60);
        const timeB:number = new Date(b.timeFrom).getHours() + (new Date(b.timeFrom).getMinutes() / 60);
        return timeA - timeB;
      });
      let highestBreakTime:number = 0;
      for (let i = 0; i < newDateBookings.length - 1; i++) {
        const breakTime: number = ((newDateBookings[i + 1].timeFrom).getHours() + (new Date(newDateBookings[i + 1].timeFrom).getMinutes() / 60) - ((newDateBookings[i].timeUntil).getHours() + (new Date(newDateBookings[i].timeUntil).getMinutes() / 60)));
        if (breakTime > highestBreakTime) highestBreakTime = breakTime;
      }
      for (let booking of newDateBookings) {
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
      if ((totalWorkedTimeInHours + (totalWorkedTimeInMinutes / 60)) >= 9 && highestBreakTime >= 1) return true
      return (totalWorkedTimeInHours + (totalWorkedTimeInMinutes / 60)) < 9 && highestBreakTime >= 0.5;

    }
    return true;
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
    return undefined;
  }
}
