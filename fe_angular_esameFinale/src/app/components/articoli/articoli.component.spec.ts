import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ArticoliComponent } from './articoli.component';

describe('ArticoliComponent', () => {
  let component: ArticoliComponent;
  let fixture: ComponentFixture<ArticoliComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ArticoliComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ArticoliComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
