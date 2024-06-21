import {GradeModel} from "./GradeModel";

export interface GradeSubjectOutModel{
  name: string
  subject_id: number
  gradeDateList:GradeModel[]
}
