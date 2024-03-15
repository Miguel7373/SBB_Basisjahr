import { TestBed } from '@angular/core/testing';
import { CanActivateFn } from '@angular/router';

import { bicycleGuard } from './bicycle.guard';

describe('bicycleGuard', () => {
  const executeGuard: CanActivateFn = (...guardParameters) => 
      TestBed.runInInjectionContext(() => bicycleGuard(...guardParameters));

  beforeEach(() => {
    TestBed.configureTestingModule({});
  });

  it('should be created', () => {
    expect(executeGuard).toBeTruthy();
  });
});
