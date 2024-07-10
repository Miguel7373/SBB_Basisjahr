import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowTODOComponent } from './show-todo.component';

describe('ShowTODOComponent', () => {
  let component: ShowTODOComponent;
  let fixture: ComponentFixture<ShowTODOComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ShowTODOComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ShowTODOComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
