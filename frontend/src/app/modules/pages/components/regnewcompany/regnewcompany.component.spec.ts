import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RegnewcompanyComponent } from './regnewcompany.component';

describe('RegnewcompanyComponent', () => {
  let component: RegnewcompanyComponent;
  let fixture: ComponentFixture<RegnewcompanyComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RegnewcompanyComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RegnewcompanyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
