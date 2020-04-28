import { TestBed } from '@angular/core/testing';

import { CarsaleCheckTokenService } from './carsale-check-token.service';

describe('CarsaleCheckTokenService', () => {
  let service: CarsaleCheckTokenService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CarsaleCheckTokenService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
