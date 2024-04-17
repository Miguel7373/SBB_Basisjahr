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

  constructor(private router: Router, @Inject(PLATFORM_ID) private platformId: Object) {
    console.log(isPlatformBrowser(this.platformId));
    console.log(this.platformId);
    if (isPlatformBrowser(this.platformId)) {
      const t = localStorage.getItem('members');
      if (!(t) || JSON.parse((localStorage.getItem('members')) ?? "").length === 0) {
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
          username: "Big",
          surname: "Horikita",
          firstname: "Manabu",
          password: "1234",
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

  validatePassword(username: string, password: string): void {
    const user: MemberModel | undefined = this.members.find(user => user.username === username && user.password === password);
    if (user) {
      localStorage.setItem('currentUser', JSON.stringify(user));
      this.router.navigate(["home"]);
      return;
    }

    const admin = this.admins.find(admin => admin.username === username && admin.password === password);
    if (admin) {
      localStorage.setItem('currentUser', JSON.stringify(admin));
      this.router.navigate(["home"]);

      return;

    }

    const superior = this.superiors.find(superior => superior.username === username && superior.password === password);
    if (superior) {
      localStorage.setItem('currentUser', JSON.stringify(superior));
      this.router.navigate(["home"]);
      return;
    }
  }

  getTotalCount(): number {
    const members: MemberModel[] = JSON.parse(localStorage.getItem('members') ?? "");
    const superiors: SuperiorModel[] = JSON.parse(localStorage.getItem('superiors') ?? "");
    const admins: AdminModel[] = JSON.parse(localStorage.getItem('admins') ?? "");
    return members.length + superiors.length + admins.length;
  }

  deleteMember(memberName: string) {
    if (this.getAllSuperiorName().includes(memberName)) {
      this.superiors = this.superiors.filter(superior => superior.username !== memberName);
      localStorage.setItem('superiors', JSON.stringify(this.superiors));
    } else if (this.getAllAdminsName().includes(memberName)) {
      this.admins = this.admins.filter(admin => admin.username !== memberName);
      localStorage.setItem('admins', JSON.stringify(this.admins));
    } else if (this.getAllMembersName().includes(memberName)) {
      this.members = this.members.filter(member => member.username !== memberName);
      localStorage.setItem('members', JSON.stringify(this.members));
    }
  }

  editMembersOwnProfile(currentUser: MemberModel | AdminModel | SuperiorModel, newPassword: string, newPicture: string, passwordOrPicture: boolean) {
    const updateField: string = passwordOrPicture ? 'password' : 'picture';
    const updateValue: string = passwordOrPicture ? newPassword : newPicture;
    if (this.getAllMembersName().includes(currentUser.username)) {
      this.members = this.members.map(member => member.memberId === currentUser.memberId ? {
        ...member, [updateField]: updateValue
      } : member);
    } else if (this.getAllAdminsName().includes(currentUser.username)) {
      this.admins = this.admins.map(admin => admin.memberId === currentUser.memberId ? {
        ...admin, [updateField]: updateValue
      } : admin);
    } else if (this.getAllSuperiorName().includes(currentUser.username)) {
      this.superiors = this.superiors.map(superior => superior.memberId === currentUser.memberId ? {
        ...superior, [updateField]: updateValue
      } : superior);
    }
    this.setLocalStorageData();
  }

  getAllSuperiorAttributes(): string[] {
    type SuperiorAttributeKeys = keyof SuperiorModel;
    const attributeNames: SuperiorAttributeKeys[] = ['username', 'surname', 'firstname', 'password', 'department', 'picture', 'members'];

    return attributeNames as string[]
  }

  getAllMemberAttributes(): string[] {
    type MemberAttributeKeys = keyof MemberModel;

    const attributeNames: MemberAttributeKeys[] = ['username', 'surname', 'firstname', 'password', 'department', 'picture'];

    return attributeNames as string[];
  }

  editUserParts(changingAttribute: string, currentUserName: string,members: string[], newData: string, ) {
    console.log(newData)
    const addableMember: MemberModel[] = []
    for (let i = 0; i < members.length; i++) {
      addableMember.push(<MemberModel>this.getUserByUsername(members[i]))
    }
    const currentUser = this.getUserByUsername(currentUserName);
    if (currentUser) {
      if (this.getAllSuperiorName().includes(currentUserName)) {
        if (changingAttribute === 'members') {
          this.superiors = this.superiors.map(superior => superior.username === currentUserName ? {
            ...superior, members:addableMember
          } : superior);
        } else {
          this.superiors = this.superiors.map(superior => superior.username === currentUserName ? {
            ...superior, [changingAttribute]: newData
          } : superior);
        }
      } else if (this.getAllAdminsName().includes(currentUserName)) {
        this.admins = this.admins.map(admin => admin.username === currentUserName ? {
          ...admin, [changingAttribute]: newData
        } : admin);
      } else if (this.getAllMembersName().includes(currentUserName)) {
        this.members = this.members.map(member => member.username === currentUserName ? {
          ...member, [changingAttribute]: newData
        } : member);
      }
      this.setLocalStorageData();
    }
  }

  getUserByUsername(username: string): MemberModel | AdminModel | SuperiorModel | undefined {
    const currentUser = this.getCurrentUser();
    if (currentUser && currentUser.username === username) {
      return currentUser;
    }

    const member = this.members.find(member => member.username === username);
    if (member) {
      return member;
    }

    const admin = this.admins.find(admin => admin.username === username);
    if (admin) {
      return admin;
    }

    const superior = this.superiors.find(superior => superior.username === username);
    if (superior) {
      return superior;
    }

    return undefined;
  }
  getSuperiorArray(){
    return this.superiors;
  }
  getAdminArray(){
    return this.admins;
  }
  getMemberArray(){
    return this.members;
  }

}


