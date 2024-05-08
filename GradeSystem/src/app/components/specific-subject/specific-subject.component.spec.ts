import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SpecificSubjectComponent } from './specific-subject.component';

describe('SpecificSubjectComponent', () => {
  let component: SpecificSubjectComponent;
  let fixture: ComponentFixture<SpecificSubjectComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SpecificSubjectComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(SpecificSubjectComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
