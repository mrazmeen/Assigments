import { TestBed } from '@angular/core/testing';

import { CarsaleAuthGuardService } from './carsale-auth-guard.service';

describe('CarsaleAuthGuardService', () => {
  let service: CarsaleAuthGuardService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CarsaleAuthGuardService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
