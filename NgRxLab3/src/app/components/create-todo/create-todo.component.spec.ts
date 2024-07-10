import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateTODOComponent } from './create-todo.component';

describe('CreateTODOComponent', () => {
  let component: CreateTODOComponent;
  let fixture: ComponentFixture<CreateTODOComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CreateTODOComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CreateTODOComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
