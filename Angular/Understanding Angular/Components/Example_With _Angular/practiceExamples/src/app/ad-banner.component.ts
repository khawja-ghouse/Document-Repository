import { Component, Input, OnDestroy, OnInit, ViewChild } from '@angular/core';

import { AdDirective } from './ad.directive';
import { AdItem } from './ad-item';
import { AdComponent } from './ad.component';
import { DirectiveDemo } from './directiveDemo.directive';


@Component({
  selector: 'app-ad-banner',
  template: `
    <div class="ad-banner-example">
      <h3 ChangeBackGroundColor>Advertisements</h3>

      <p adHost></p>
      <ng-template ></ng-template>
    </div>
  `
})
export class AdBannerComponent implements OnInit, OnDestroy {

  @Input() ads: AdItem[] = [];

  currentAdIndex = -1;

  @ViewChild(AdDirective, {static: true}) adHos111!: AdDirective;

  private clearTimer: VoidFunction | undefined;

  ngOnInit(): void {
    console.log('Inside ngOninit');
    this.loadComponent();
    this.getAds();
  }

  ngOnDestroy() {
    console.log('inside ngDestroy');

    this.clearTimer?.();
  }

  loadComponent() {
    console.log('Inside loadComponent');
    console.log(this.adHos111.message);

    this.currentAdIndex = (this.currentAdIndex + 1) % this.ads.length;
    console.log("Index value",this.currentAdIndex);
    const adItem = this.ads[this.currentAdIndex];

    // This is always taking the reference of ad-banner component and clearing the view
    const viewContainerRef = this.adHos111.viewContainerRef;
    viewContainerRef.clear();
    // @Input properties present in adItems are getting initialized as well
    const componentRef = viewContainerRef.createComponent<AdComponent>(adItem.component);
    componentRef.instance.data = adItem.data;
  }

  getAds() {
    console.log('Inside getAds !!');

    const interval = setInterval(() => {
      this.loadComponent();
    }, 3000);
    this.clearTimer = () => { console.log('inside clearInterval call back');

    clearInterval(interval)};
    console.log('end of setting time interval');

  }
}
