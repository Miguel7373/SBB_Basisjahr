import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DeleteSubjectOrGradeComponent } from './delete-subject-or-grade.component';

describe('DeleteSubjectOrGradeComponent', () => {
  let component: DeleteSubjectOrGradeComponent;
  let fixture: ComponentFixture<DeleteSubjectOrGradeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DeleteSubjectOrGradeComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(DeleteSubjectOrGradeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
