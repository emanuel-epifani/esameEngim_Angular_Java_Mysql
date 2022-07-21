import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TariffeComponent } from './tariffe.component';

describe('TariffeComponent', () => {
  let component: TariffeComponent;
  let fixture: ComponentFixture<TariffeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TariffeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TariffeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
