## Dynamic component loader

The following example shows how to build a dynamic ad banner.

The hero agency is planning an ad campaign with several different ads cycling through the banner. New ad components are added frequently by several different teams. This makes it impractical to use a template with a static component structure.
Instead, you need a way to load a new component without a fixed reference to the component in the ad banner's template. 

### The anchor directive

Before adding components, you have to define an **anchor point** to tell Angular where to insert components.

The ad banner uses a helper directive called `AdDirective` to mark valid insertion points in the template.

**src/app/ad.directive.ts**

```ts
import { Directive, ViewContainerRef } from '@angular/core';

@Directive({
  selector: '[adHost]',
})
export class AdDirective {
  constructor(public viewContainerRef: ViewContainerRef) { }
}
```

`AdDirective` injects `[ViewContainerRef](https://angular.io/api/core/ViewContainerRef)` to gain access to the view container of the element that will host the dynamically added component.

In the `@[Directive](https://angular.io/api/core/Directive)` decorator, notice the selector name, `adHost`; that's what you use to apply the directive to the element. The next section shows you how.

### Loading components
Most of the ad banner implementation is in `ad-banner.component.ts`. To keep things simple in this example, the HTML is in the `@[Component](https://angular.io/api/core/Component)` decorator's `template` property as a template string.

The `<ng-template>` element is where you apply the directive you just made. To apply the `AdDirective`, recall the selector from `ad.directive.ts`, `[adHost]`. Apply that to `[<ng-template>](https://angular.io/api/core/ng-template)` without the square brackets. Now Angular knows where to dynamically load components.

```ts
template: `
  <div class="ad-banner-example">
    <h3>Advertisements</h3>
    <ng-template adHost></ng-template>
  </div>
`
```

The `<ng-template>` element is a good choice for dynamic components because it doesn't render any additional output.

**ad-banner.component.ts**
`AdBannerComponent` takes an array of `AdItem` objects as input, which ultimately comes from `AdService`. `AdItem` objects specify the type of component to load and any data to bind to the component.`AdService` returns the actual ads making up the ad campaign.

Passing an array of components to `AdBannerComponent` allows for a dynamic list of ads without static elements in the template.

`AdBannerComponent` takes an array of `AdItem` objects as input, which ultimately comes from `AdService`. `AdItem` objects specify the type of component to load and any data to bind to the component.`AdService` returns the actual ads making up the ad campaign.

Passing an array of components to `AdBannerComponent` allows for a dynamic list of ads without static elements in the template.

```ts
export class AdBannerComponent implements OnInit, OnDestroy {
  @Input() ads: AdItem[] = [];

  currentAdIndex = -1;

  @ViewChild(AdDirective, {static: true}) adHost!: AdDirective;

  private clearTimer: VoidFunction | undefined;

  ngOnInit(): void {
    this.loadComponent();
    this.getAds();
  }

  ngOnDestroy() {
    this.clearTimer?.();
  }

  loadComponent() {
    this.currentAdIndex = (this.currentAdIndex + 1) % this.ads.length;
    const adItem = this.ads[this.currentAdIndex];

    const viewContainerRef = this.adHost.viewContainerRef;
    viewContainerRef.clear();

    const componentRef = viewContainerRef.createComponent<AdComponent>(adItem.component);
    componentRef.instance.data = adItem.data;
  }

  getAds() {
    const interval = setInterval(() => {
      this.loadComponent();
    }, 3000);
    this.clearTimer = () => clearInterval(interval);
  }
}
```

Next, you're targeting the `viewContainerRef` that exists on this specific instance of the component. How do you know it's this specific instance? Because it's referring to `adHost`, and `adHost` is the directive you set up earlier to tell Angular where to insert dynamic components.

As you may recall, `AdDirective` injects `[ViewContainerRef](https://angular.io/api/core/ViewContainerRef)` into its constructor. This is how the directive accesses the element that you want to use to host the dynamic component.

To add the component to the template, you call `[createComponent](https://angular.io/api/core/createComponent)()` on `[ViewContainerRef](https://angular.io/api/core/ViewContainerRef)`.

The `[createComponent](https://angular.io/api/core/createComponent)()` method returns a reference to the loaded component. Use that reference to interact with the component by assigning to its properties or calling its methods.

The **AdComponent** interface

In the ad banner, all components implement a common `AdComponent` interface to standardize the API for passing data to the components.

Here are two sample components and the `AdComponent` interface for reference:

**ad.component.ts**
```ts
export interface AdComponent {
  data: any;
}
```


**hero-job-ad.component.ts**

```ts
import { Component, Input } from '@angular/core';

import { AdComponent } from './ad.component';

@Component({
  template: `
    <div class="job-ad">
      <h4>{{data.headline}}</h4>
      {{data.body}}
    </div>
  `
})
export class HeroJobAdComponent implements AdComponent {
  @Input() data: any;
}
```
**hero-profile.component.ts**
```ts
import { Component, Input } from '@angular/core';

import { AdComponent } from './ad.component';

@Component({
  template: `
    <div class="job-ad">
      <h4>{{data.headline}}</h4>
      {{data.body}}
    </div>
  `
})
export class HeroJobAdComponent implements AdComponent {
  @Input() data: any;
}
```

