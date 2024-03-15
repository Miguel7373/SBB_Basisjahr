import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BicycleSearchComponent } from './bicycle-search.component';

describe('BicycleSearchComponent', () => {
  let component: BicycleSearchComponent;
  let fixture: ComponentFixture<BicycleSearchComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [BicycleSearchComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(BicycleSearchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
