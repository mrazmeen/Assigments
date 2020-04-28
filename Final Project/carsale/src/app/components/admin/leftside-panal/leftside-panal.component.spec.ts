import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LeftsidePanalComponent } from './leftside-panal.component';

describe('LeftsidePanalComponent', () => {
  let component: LeftsidePanalComponent;
  let fixture: ComponentFixture<LeftsidePanalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LeftsidePanalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LeftsidePanalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
