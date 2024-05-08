import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditOrAddSubjectComponent } from './edit-or-add-subject.component';

describe('EditOrAddSubjectComponent', () => {
  let component: EditOrAddSubjectComponent;
  let fixture: ComponentFixture<EditOrAddSubjectComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EditOrAddSubjectComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(EditOrAddSubjectComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
