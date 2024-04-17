import { TestBed } from '@angular/core/testing';

import { TimeCodesService } from './time-codes.service';

describe('TimecodesService', () => {
  let service: TimeCodesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TimeCodesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
