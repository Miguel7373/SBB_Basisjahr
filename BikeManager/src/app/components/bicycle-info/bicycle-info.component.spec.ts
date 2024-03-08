import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BicycleInfoComponent } from './bicycle-info.component';

describe('BicycleInfoComponent', () => {
  let component: BicycleInfoComponent;
  let fixture: ComponentFixture<BicycleInfoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [BicycleInfoComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(BicycleInfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
