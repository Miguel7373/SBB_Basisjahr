import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditOrAddGradeComponent } from './edit-or-add-grade.component';

describe('EditOrAddGradeComponent', () => {
  let component: EditOrAddGradeComponent;
  let fixture: ComponentFixture<EditOrAddGradeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EditOrAddGradeComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(EditOrAddGradeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
