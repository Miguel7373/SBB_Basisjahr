import { TestBed } from '@angular/core/testing';

import { BicycleServiceService } from './bicycle-service.service';

describe('BicycleServiceService', () => {
  let service: BicycleServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BicycleServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
