import {Injectable} from '@angular/core';
import {AssignmentModel} from "../../models/assignmentModel";

@Injectable({
  providedIn: 'root'
})
export class AssignmentService {
  assignments: AssignmentModel[] = []

  constructor() {
    if (!(localStorage.getItem('assignments'))) {
      this.assignments.push({
        assignmentId: 1, text: "It Team"
      }, {
        assignmentId: 2, text: "OutDorWork"
      }, {
        assignmentId: 3, text: "Dogs"
      })
    } else {
      this.assignments = [...JSON.parse(localStorage.getItem('assignments') ?? ""),]
    }
    this.setLocalStorageData();
  }

  addAssignment(newAssignmentName: string): void {
    if (!this.getAssignmentNames().includes(newAssignmentName)) {
      this.assignments.push({assignmentId: this.totalCountOfAssignments(), text: newAssignmentName});
      localStorage.setItem('assignments', JSON.stringify(this.assignments))
    }
  }

  getAllAssignmentsName(): string[] {
    return this.assignments.map(assignment => assignment.text)
  }

  private setLocalStorageData(): void {
    localStorage.setItem('assignments', JSON.stringify(this.assignments));
  }

  private getAssignmentNames() {
    return this.assignments.map(assignment => assignment.text)
  }

  private totalCountOfAssignments(): number {
    const storedAssignments: string | null = localStorage.getItem('assignments');
    if (storedAssignments) {
      const assignments: AssignmentModel[] = JSON.parse(storedAssignments)
      return assignments.length + 1
    }
    return 1

  }
}
