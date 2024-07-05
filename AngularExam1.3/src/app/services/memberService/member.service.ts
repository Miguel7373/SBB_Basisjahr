import {Inject, Injectable, PLATFORM_ID} from '@angular/core';
import {AdminModel, MemberModel, SuperiorModel} from "../../models/memberModel";
import {Router} from "@angular/router";
import {isPlatformBrowser} from "@angular/common";

@Injectable({
  providedIn: 'root'
})
export class MemberService {


  private members: MemberModel[] = []
  private admins: AdminModel[] = []
  private superiors: SuperiorModel[] = []
  private loginTryCount: number = 0;

  constructor(private router: Router, @Inject(PLATFORM_ID) private platformId: Object) {
    if (isPlatformBrowser(this.platformId)) {
      if (!(localStorage.getItem('members')) || JSON.parse((localStorage.getItem('members')) ?? "").length === 0) {
        this.members.push({
          memberId: 1,
          username: "Pawn",
          surname: "Karuizawa",
          firstname: "Kei",
          password: "1234",
          department: "Informatik",
          picture: "",
          bookings: []
        }, {
          memberId: 2,
          username: "Rook",
          surname: "Horikita",
          firstname: "Suzune",
          password: "1234",
          department: "",
          picture: "",
          bookings: []
        })
      } else {
        this.members = [...JSON.parse(localStorage.getItem('members') ?? ""),];
      }
      if (!(localStorage.getItem('admins')) || JSON.parse((localStorage.getItem('admins')) ?? "").length === 0) {
        this.admins.push({
          memberId: 3,
          username: "john.doe@user.com",
          surname: "Horikita",
          firstname: "Manabu",
          password: "qwerty",
          department: "",
          picture: "",
          bookings: []
        })
      } else {
        this.admins = [...JSON.parse(localStorage.getItem('admins') ?? ""),];
      }
      if (!(localStorage.getItem('superiors')) || JSON.parse((localStorage.getItem('superiors')) ?? "").length === 0) {
        this.superiors.push({
          memberId: 4,
          username: "King",
          surname: "Ayanokoji",
          firstname: "Kiyotaka",
          password: "1234",
          department: "GL",
          picture: "",
          members: [],
          bookings: []
        })
      } else {
        this.superiors = [...JSON.parse(localStorage.getItem('superiors') ?? ""),];
      }

      this.setLocalStorageData()
    }
  }

  setLocalStorageData(): void {
    localStorage.setItem('members', JSON.stringify(this.members));
    localStorage.setItem('admins', JSON.stringify(this.admins));
    localStorage.setItem('superiors', JSON.stringify(this.superiors));
  }

  addMember(memberData: MemberModel | AdminModel | SuperiorModel | undefined, currentType: string) {
    if (memberData !== undefined) {
      if (currentType === 'Superior') {
        this.superiors.push(memberData as SuperiorModel)
        localStorage.setItem('superiors', JSON.stringify(this.superiors))
      } else if (currentType === 'Admin') {
        this.admins.push(memberData as AdminModel)
        localStorage.setItem('admins', JSON.stringify(this.admins))
      } else if (currentType === 'Member') {
        this.members.push(memberData as MemberModel)
        localStorage.setItem('members', JSON.stringify(this.members))
      }
    }
  }

  getCurrentUser(): MemberModel | AdminModel | SuperiorModel | undefined {

    let storedUser: string = ""
    storedUser = localStorage.getItem('currentUser') ?? "";
    if (storedUser) {
      return JSON.parse(storedUser);
    }

    return undefined;
  }

  getAllMembersName(): string[] {
    return this.members.map(member => member.username)
  }

  getAllOfSuperiorsMembersName(): string[] {
    const checkingUser: MemberModel | SuperiorModel | AdminModel | undefined = this.getCurrentUser();
    const superior: SuperiorModel | undefined = this.superiors.find(superior => superior.memberId === checkingUser?.memberId);
    if (superior) {
      return superior.members;
    }
    return [];

  }

  getAllSuperiorName(): string[] {
    return this.superiors.map(superior => superior.username)
  }

  getAllAdminsName(): string[] {
    return this.admins.map(admin => admin.username)
  }

  getAllMemberIds(): number[] {
    return this.members.map(member => member.memberId);
  }

  getAllSuperiorIds(): number[] {
    return this.superiors.map(superior => superior.memberId);
  }

  getAllAdminIds(): number[] {
    return this.admins.map(admin => admin.memberId);
  }


  validatePassword(username: string, password: string, users: MemberModel[] | AdminModel[] | SuperiorModel[]): MemberModel | AdminModel | SuperiorModel | undefined {
    return users.find(user => user.username === username && user.password === password);
  }

  login(username: string, password: string): void {
    let loginUser: MemberModel | AdminModel | SuperiorModel | undefined;

    loginUser = this.validatePassword(username, password, this.members);
    if (loginUser) {
      localStorage.setItem('currentUser', JSON.stringify(loginUser));
      this.router.navigate(["home"]);
      return;
    }

    loginUser = this.validatePassword(username, password, this.admins);
    if (loginUser) {
      localStorage.setItem('currentUser', JSON.stringify(loginUser));
      this.router.navigate(["home"]);
      return;
    }

    loginUser = this.validatePassword(username, password, this.superiors);
    if (loginUser) {
      localStorage.setItem('currentUser', JSON.stringify(loginUser));
      this.router.navigate(["home"]);
      return;
    }
    this.loginTryCount += 1;
  }


  getLoginTryCount(): number {
    return this.loginTryCount;
  }

  getTotalCount(): number {
    const members: MemberModel[] = JSON.parse(localStorage.getItem('members') ?? "");
    const superiors: SuperiorModel[] = JSON.parse(localStorage.getItem('superiors') ?? "");
    const admins: AdminModel[] = JSON.parse(localStorage.getItem('admins') ?? "");
    return members.length + superiors.length + admins.length;
  }

  deleteMember(memberName: string) {
    if (this.getAllSuperiorName().includes(memberName)) {
      localStorage.setItem('superiors', JSON.stringify(this.deleteUser(this.superiors, memberName)));
    } else if (this.getAllAdminsName().includes(memberName)) {
      localStorage.setItem('admins', JSON.stringify(this.deleteUser(this.admins, memberName)));
    } else if (this.getAllMembersName().includes(memberName)) {
      localStorage.setItem('members', JSON.stringify(this.deleteUser(this.members, memberName)));
    }
  }
  deleteUser(users: MemberModel[] | AdminModel[] | SuperiorModel[], memberName:string): MemberModel[] | AdminModel[] | SuperiorModel[]{
    return users.filter(user => user.username !== memberName);
  }

  editMembersOwnProfile(currentUser: MemberModel | AdminModel | SuperiorModel, newPassword: string, newPicture: string, passwordOrPicture: boolean) {
    const updateField: string = passwordOrPicture ? 'password' : 'picture';
    const updateValue: string = passwordOrPicture ? newPassword : newPicture;
    if (this.getCurrentUser()?.password !== updateValue) {
      if (this.getAllMembersName().includes(currentUser.username)) {
        this.members = this.editOwnUser(this.members,currentUser.memberId, updateField, updateValue);
        localStorage.setItem('members', JSON.stringify(this.members));
      } else if (this.getAllAdminsName().includes(currentUser.username)) {
        this.admins = this.editOwnUser(this.admins, currentUser.memberId, updateField, updateValue);
        localStorage.setItem('admins', JSON.stringify(this.admins));
      } else if (this.getAllSuperiorName().includes(currentUser.username)) {
        localStorage.setItem('superiors', JSON.stringify(this.editOwnUser(this.superiors, currentUser.memberId, updateField, updateValue)));
        alert(this.editOwnUser(this.superiors, currentUser.memberId, updateField, updateValue)[0].picture);
      }
    } else alert("That`s Already your password")
  }
  editOwnUser(users: MemberModel[] | AdminModel[] | SuperiorModel[],userId:number, updateField:string, updateValue:string): MemberModel[] | AdminModel[] | SuperiorModel[]{
    users = users.map(member => member.memberId === userId ? {
      ...member, [updateField]: updateValue
    } : member);
    alert(users[0].picture)
    return users;
  }


  editUser(username: string, newUsername: string, newSurname: string, newFirstname: string, newPassword: string, newDepartment: string, newPicture: string, members: string[]) {
    const currentUser: AdminModel | SuperiorModel | MemberModel | undefined = this.getUserByUsername(username);
    let addableMember: string[] = []
    for (let i = 0; i < members.length; i++) {
      addableMember.push((members[i]))
    }
    if (currentUser) {
      if (this.getAllSuperiorName().includes(currentUser.username)) {
        this.updateUserList(1, this.superiors, currentUser.username, newUsername, newSurname, newFirstname, newPassword, newDepartment, newPicture, members)
      } else if (this.getAllAdminsName().includes(currentUser.username)) {
        this.updateUserList(2, this.admins, currentUser.username, newUsername, newSurname, newFirstname, newPassword, newDepartment, newPicture, members)
      } else if (this.getAllMembersName().includes(currentUser.username)) {
        this.updateUserList(3, this.members, currentUser.username, newUsername, newSurname, newFirstname, newPassword, newDepartment, newPicture, members)
      }
    }
  }

  updateUserList(toSave: number, users: AdminModel[] | SuperiorModel[] | MemberModel[] | undefined, currentUsername: string, newUsername: string, newSurname: string, newFirstname: string, newPassword: string, newDepartment: string, newPicture: string, members: string[]) {
    if (users) {
      users = users.map(user => user.username === currentUsername ? {
        ...user,
        username: newUsername,
        surname: newSurname,
        firstname: newFirstname,
        password: newPassword,
        department: newDepartment,
        picture: newPicture
      } : user)
      if (members.length !== 0) {
        users = users.map(user => user.username === currentUsername ? {
          ...user, members: members
        } : user)
      }
      switch (toSave) {
        case 1:
          localStorage.setItem('superiors', JSON.stringify(users));
          break;
        case 2:
          localStorage.setItem('admins', JSON.stringify(users));
          break;
        case 3:
          localStorage.setItem('members', JSON.stringify(users));
          break;
      }
    }
  }


  getUserByUsername(username: string): MemberModel | AdminModel | SuperiorModel | undefined {
    const currentUser: MemberModel | SuperiorModel | AdminModel | undefined = this.getCurrentUser();
    if (currentUser && currentUser.username === username) return currentUser;
    const member: MemberModel | undefined = this.members.find(member => member.username === username);
    if (member) return member;
    const admin: AdminModel | undefined = this.admins.find(admin => admin.username === username);
    if (admin) return admin;
    const superior: SuperiorModel | undefined = this.superiors.find(superior => superior.username === username);
    if (superior) return superior;
    return undefined;
  }

  getSuperiorArray(): SuperiorModel[] {
    return this.superiors;
  }

  getAdminArray(): AdminModel[] {
    return this.admins;
  }

  getMemberArray(): MemberModel[] {
    return this.members;
  }

  setCurrentUser(): void {
    const OldUser = JSON.parse(localStorage.getItem('currentUser') ?? "");
    const user: MemberModel | undefined = this.members.find(user => user.memberId === OldUser.memberId);
    if (user) {
      localStorage.setItem('currentUser', JSON.stringify(user));
    }
    const admin: AdminModel | undefined = this.admins.find(admin => admin.memberId === OldUser.memberId);
    if (admin) {
      localStorage.setItem('currentUser', JSON.stringify(admin));
    }
    const superior: SuperiorModel | undefined = this.superiors.find(superior => superior.memberId === OldUser.memberId);
    if (superior) {
      localStorage.setItem('currentUser', JSON.stringify(superior));
      return;
    }
  }



  setCreatingDate(time: string, date: string) {
    localStorage.setItem('creatingTime', JSON.stringify(time))
    localStorage.setItem('creatingDate', JSON.stringify(date))
  }
}


