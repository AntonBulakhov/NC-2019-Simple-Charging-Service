import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ModaladdwalletComponent } from './modaladdwallet.component';

describe('ModaladdwalletComponent', () => {
  let component: ModaladdwalletComponent;
  let fixture: ComponentFixture<ModaladdwalletComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ModaladdwalletComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ModaladdwalletComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
