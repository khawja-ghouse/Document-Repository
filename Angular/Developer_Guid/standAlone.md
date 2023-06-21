### The `standalone` flag and component `imports`
Components, directives, and pipes can now be marked as `standalone: true`. Angular classes marked as standalone do not need to be declared in an `[NgModule](https://angular.io/api/core/NgModule)` (the Angular compiler will report an error if you try).

Standalone components specify their dependencies directly instead of getting them through `[NgModule](https://angular.io/api/core/NgModule)`s. For example, if `PhotoGalleryComponent` is a standalone component, it can directly import another standalone component `ImageGridComponent`:

```ts
@Component({
  standalone: true,
  selector: 'photo-gallery',
  imports: [ImageGridComponent],
  template: `
    ... <image-grid [images]="imageList"></image-grid>
  `,
})
export class PhotoGalleryComponent {
  // component logic
}
```

`imports` can also be used to reference standalone directives and pipes. In this way, standalone components can be written without the need to create an `[NgModule](https://angular.io/api/core/NgModule)` to manage template dependencies.

### Using existing NgModules in a standalone component

When writing a standalone component, you may want to use other components, directives, or pipes in the component's template. Some of those dependencies might not be marked as standalone, but instead declared and exported by an existing `[NgModule](https://angular.io/api/core/NgModule)`. In this case, you can import the `[NgModule](https://angular.io/api/core/NgModule)` directly into the standalone component:

```ts
@Component({
  standalone: true,
  selector: 'photo-gallery',
  // an existing module is imported directly into a standalone component
  imports: [MatButtonModule],
  template: `
    ...
    <button mat-button>Next Page</button>
  `,
})
export class PhotoGalleryComponent {
  // logic
}
```

## Bootstrapping an application using a standalone component

An Angular application can be bootstrapped without any `[NgModule](https://angular.io/api/core/NgModule)` by using a standalone component as the application's root component. This is done using the `[bootstrapApplication](https://angular.io/api/platform-browser/bootstrapApplication)` API:

```ts
// in the main.ts file
import {bootstrapApplication} from '@angular/platform-browser';
import {PhotoAppComponent} from './app/photo.app.component';

bootstrapApplication(PhotoAppComponent);
```

### Configuring dependency injection[](https://angular.io/guide/standalone-components#configuring-dependency-injection "Link to this heading")

When bootstrapping an application, often you want to configure Angular’s dependency injection and provide configuration values or services for use throughout the application. You can pass these as providers to `[bootstrapApplication](https://angular.io/api/platform-browser/bootstrapApplication)`:

```ts

bootstrapApplication(PhotoAppComponent, {
  providers: [
    {provide: BACKEND_URL, useValue: 'https://photoapp.looknongmodules.com/api'},
    // ...
  ]
});
```
