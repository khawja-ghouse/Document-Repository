import { TestBed } from '@angular/core/testing';

import { SongsGetterService } from './songs-getter.service';

describe('SongsGetterService', () => {
  let service: SongsGetterService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SongsGetterService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
