import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AllGradesForSubjectsComponent } from './all-grades-for-subjects.component';

describe('AllGradesForSubjectsComponent', () => {
  let component: AllGradesForSubjectsComponent;
  let fixture: ComponentFixture<AllGradesForSubjectsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AllGradesForSubjectsComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AllGradesForSubjectsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
