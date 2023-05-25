An NgModule describes how the application parts fit together. Every application has at least one Angular module, the _root_ module, which must be present for bootstrapping the application on launch. By convention and by default, this NgModule is named `AppModule`.

When you use the Angular CLI command `ng new` to generate an app, the default `AppModule` looks like the following:
```Typescript
/* JavaScript imports */
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';

/* the AppModule class with the @NgModule decorator */
@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
```
After the import statements is a class with the **`@[NgModule](https://angular.io/api/core/NgModule)`** decorator.

The `@NgModule` decorator identifies `AppModule` as an NgModule class @NgModule takes a metadata object that tells Angular how to compile and launch the application.

|   MetaDATA OBJECT |                      Details                                                                         |
|   --------------------  | ------------------------------------------------------------------------ | 
|  declarations             | This applications lone component                                       |
| imports                     | Import BrowserModule to have  browser-specific services such as      |
|                                   |  DOM rendering, sanitization, and location.                     |
| providers                  | The service providers.                                                 |
|  bootstrap                |  The _root_ component that Angular creates and inserts into 
|             |              the `index.html` host web page.|

The default application created by the Angular CLI only has one component, `AppComponent`, so it is in both the `declarations` and the `bootstrap` arrays.

### The `declarations` array
- The module's `declarations` array tells Angular which components belong to that module. As you create more components, add them to `declarations`.
- You must declare every component in exactly one `NgModule` class. If you use a component without declaring it, Angular returns an error message.
- The `declarations` array only takes declarables. Declarables are components, [directives](https://angular.io/guide/attribute-directives), and [pipes](https://angular.io/guide/pipes). All of a module's declarables must be in the `declarations` array. Declarables must belong to exactly one module. The compiler emits an error if you try to declare the same class in more than one module.
- These declared classes are visible within the module but invisible to components in a different module, unless they are exported from this module and the other module imports this one.
``` Typescript
declarations: [
  YourComponent,
  YourPipe,
  YourDirective
]
```

### The `imports` arrays
The module's `imports` array appears exclusively in the `@[NgModule]` metadata object. It tells Angular about other NgModules that this particular module needs to function properly.

```Typescript
imports: [
  BrowserModule,
  FormsModule,
  HttpClientModule
],
```

This list of modules are those that export components, directives, or pipes that component templates in this module reference. In this case, the component is `AppComponent`, which references components, directives, or pipes in `BrowserModule`, `FormsModule`, or `HttpClientModule`. A component template can reference another component, directive, or pipe when the referenced class is declared in this module, or the class was imported from another module.

## The `providers` array

The providers array is where you list the services the application needs. When you list services here, they are available app-wide. You can scope them when using feature modules and lazy loading. For more information, see [Providers](https://angular.io/guide/providers).

### The `bootstrap` array

The application launches by bootstrapping the root `AppModule`, which is also referred to as an `entryComponent`. Among other things, the bootstrapping process creates the component(s) listed in the `bootstrap` array and inserts each one into the browser DOM.

Each bootstrapped component is the base of its own tree of components. Inserting a bootstrapped component usually triggers a cascade of component creations that fill out that tree.

While you can put more than one component tree on a host web page, most applications have only one component tree and bootstrap a single root component.

This one root component is usually called `AppComponent` and is in the root module's `bootstrap` array.