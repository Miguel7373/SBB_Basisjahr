import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CelsiusToFahreinheitComponent } from './celsius-to-fahreinheit.component';

describe('CelsiusToFahreinheitComponent', () => {
  let component: CelsiusToFahreinheitComponent;
  let fixture: ComponentFixture<CelsiusToFahreinheitComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CelsiusToFahreinheitComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CelsiusToFahreinheitComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
