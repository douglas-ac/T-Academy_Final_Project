import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AnnouncePartComponent } from './announce-part.component';

describe('AnnouncePartComponent', () => {
  let component: AnnouncePartComponent;
  let fixture: ComponentFixture<AnnouncePartComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AnnouncePartComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AnnouncePartComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
