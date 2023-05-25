### Introduction to modules

Angular applications are modular and Angular has its own modularity system called _NgModules_. NgModules are containers for a cohesive block of code dedicated to an application domain, a workflow, or a closely related set of capabilities. They can contain components, service providers, and other code files whose scope is defined by the containing NgModule. They can import functionality that is exported from other NgModules, and export selected functionality for use by other NgModules.

Every Angular application has at least one NgModule class, [the _root module_](https://angular.io/guide/bootstrapping), which is conventionally named `AppModule` and resides in a file named `app.module.ts`. You launch your application by _bootstrapping_ the root NgModule.

While a small application might have only one NgModule, most applications have many more _feature modules_. The _root_ NgModule for an application is so named because it can include child NgModules in a hierarchy of any depth.

NgModule metadata
An NgModule is defined by a class decorated with @NgModule(). The @NgModule() decorator is a function that takes a single metadata object, whose properties describe the module. The most important properties are as follows.

- `declarations`
    The [components](https://angular.io/guide/architecture-components), _directives_, and _pipes_ that belong to this NgModule.
- `exports`
	The subset of declarations that should be visible and usable in the _component templates_ of other NgModules.
- `imports`
	Other modules whose exported classes are needed by component templates declared in _this_ NgModule.
- `providers`
	Creators of [services](https://angular.io/guide/architecture-services) that this NgModule contributes to the global collection of services; they become accessible in all parts of the application. (You can also specify providers at the component level.)
- `bootstrap`
	The main application view, called the _root component_, which hosts all other application views. Only the _root NgModule_ should set the `bootstrap` property.

Here's a simple root NgModule defination

```typescript
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
@NgModule({
  imports:      [ BrowserModule ],
  providers:    [ Logger ],
  declarations: [ AppComponent ],
  exports:      [ AppComponent ],
  bootstrap:    [ AppComponent ]
})
export class AppModule { }
```

### NgModules and components

**NgModules provide a _compilation context_ for their components**. A root **NgModule** always has a root component that is created during bootstrap but any **NgModule** can include any number of additional components, which can be loaded through the router or created through the template. The components that belong to an **NgModule** share a compilation context.

![[./Images/NgModule1.png]]

A component and its template together define a _view_. A component can contain a _view hierarchy_, which allows you to define arbitrarily complex areas of the screen that can be created, modified, and destroyed as a unit. A view hierarchy can mix views defined in components that belong to different NgModules. This is often the case, especially for UI libraries.

![[./Images/NgModule2.png]]

When you create a component, it's associated directly with a single view, called the _host view_. The host view can be the root of a view hierarchy, which can contain _embedded views_, which are in turn the host views of other components. Those components can be in the same NgModule, or can be imported from other NgModules. Views in the tree can be nested to any depth.

In JavaScript each _file_ is a module and all objects defined in the file belong to that module. The module declares some objects to be public by marking them with the `export` key word. Other JavaScript modules use _import statements_ to access public objects from other modules.

```typescript
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';

export class AppModule { }
```

## Angular libraries

![[./Images/angularLibrary.png]]

Angular loads as a collection of JavaScript modules. You can think of them as library modules. Each Angular library name begins with the `@angular` prefix. Install them with the node package manager `npm` and import parts of them with JavaScript `import` statements.

For example, import Angular's `[Component](https://angular.io/api/core/Component)` decorator from the `@angular/core` library like this.

```typescript
import { Component } from '@angular/core';
```

You also import NgModules from Angular _libraries_ using JavaScript import statements. For example, the following code imports the **BrowserModule** NgModule from the `platform-browser` library.

```typescript
import { BrowserModule } from '@angular/platform-browser';
```

In the example of the simple root module above, the application module needs material from within `[BrowserModule](https://angular.io/api/platform-browser/BrowserModule)`. To access that material, add it to the `@[NgModule](https://angular.io/api/core/NgModule)` metadata `imports` like this.

```typescript
imports:      [ BrowserModule ],
```

In this way, we're using the Angular and JavaScript module systems _together_.