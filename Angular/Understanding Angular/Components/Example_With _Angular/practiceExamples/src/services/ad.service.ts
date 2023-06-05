import { Injectable } from '@angular/core';

import { HeroJobAdComponent } from '../app/hero-job-ad.component';
import { HeroProfileComponent } from '../app/hero-profile.component';
import { AdItem } from '../app/ad-item';

@Injectable()
export class AdService {
  getAds() {
    return [
      new AdItem(
        HeroProfileComponent,
        { name: 'Bombasto', bio: 'Brave as they come' }
      ),
      new AdItem(
        HeroProfileComponent,
        { name: 'Dr. IQ', bio: 'Smart as they come' }
      ),
      new AdItem(
        HeroJobAdComponent,
        { headline: 'Hiring for several positions', body: 'Submit your resume today!' }
      ),
      new AdItem(
        HeroJobAdComponent,
        { headline: 'Openings in all departments', body: 'Apply today' }
      )
    ];
  }
}
