import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShoppingEditsComponent } from './shopping-edits.component';

describe('ShoppingEditsComponent', () => {
  let component: ShoppingEditsComponent;
  let fixture: ComponentFixture<ShoppingEditsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ShoppingEditsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ShoppingEditsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
