import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ModaltoupComponent } from './modaltoup.component';

describe('ModaltoupComponent', () => {
  let component: ModaltoupComponent;
  let fixture: ComponentFixture<ModaltoupComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ModaltoupComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ModaltoupComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
