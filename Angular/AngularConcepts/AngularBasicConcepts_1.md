### Introduction to Angular concepts
---

Angular is a platform and framework for building single-page client applications using HTML and TypeScript. Angular is written in TypeScript.
The architecture of an Angular application relies on certain fundamental concepts.
- The basic building blocks of the Angular framework are Angular **components** that are organized into **_NgModules_**
- **NgModules** collect related code into functional sets; an Angular application is defined by a set of **NgModules**.(In the real world, NgModule sets can be used to organize applications of all sizes. For example, a large e-commerce application might have separate NgModule sets for the home page, the product catalog, and the checkout process. A web application that has a home page, a product catalog, and a checkout process might have separate NgModule sets for each of these pages.)
- Components define **_views_**, which are sets of screen elements that Angular can choose among and modify according to your program logic and data
- Components use **_services_**, which provide specific functionality not directly related to views. Service providers can be _injected_ into components as _dependencies_, making your code modular, reusable, and efficient.

Modules, components and services are classes that use _decorators_. These decorators mark their type and provide metadata that tells Angular how to use them.
- The metadata for a component class associates it with a _template_ that defines a view. A **template combines ordinary HTML with Angular _directives_ and _binding markup_** that allow Angular to modify the **HTML before rendering it for display**.
- The metadata for a service class provides the information Angular needs to make it available to components through _dependency injection (DI)_.

### Modules
An **NgModule** declares a compilation context for a set of components that is dedicated to an application domain, a workflow, or a closely related set of capabilities. An NgModule can associate its components with related code, such as services, to form functional units.
Every Angular application has a _root module_, conventionally named `AppModule`, which provides the **bootstrap mechanism** that launches the application. An application typically contains many functional modules.

> **BootStrap Mechanism**
> The bootstrap mechanism in Angular is used to initialize an Angular application. It takes two arguments: the root element of the application and an object with configuration options. The root element is the element that will contain the Angular application. The configuration object can be used to specify things like the name of the application, the location of the application's scripts, and the application's dependencies.
> 
``` typescript
> 	angular.bootstrap(document.getElementById('myApp'), { 
> 	appName: 'My App', 
> 	scripts: ['app.js'], 
> 	dependencies: ['ng'] });
```
> This code will create an Angular application and attach it to the element with the ID `myApp`. The application will be loaded from the file `app.js` and will depend on the library `ng`. Once the application has been bootstrapped, you can start using Angular features like directives, bindings, and services.

Like JavaScript modules, NgModules can import functionality from other NgModules, and allow their own functionality to be exported and used by other NgModules. For example, to use the router service in your app, you import the `[Router](https://angular.io/api/router/Router)` NgModule.

### Components

Every Angular application has at least one component, the _root component_ that connects a component hierarchy with the page **document object model (DOM)**. Each component defines a class that contains application data and logic, and is associated with an HTML _template_ that defines a view to be displayed in a target environment.

The `@[Component](https://angular.io/api/core/Component)()` decorator identifies the class immediately below it as a component, and provides the template and related component-specific metadata.

### Templates, directives, and data binding
A template combines HTML with Angular markup that can modify HTML elements before they are displayed. Template _directives_ provide program logic, and _binding markup_ connects your application data and the DOM. There are two types of data binding:
- Event binding: Lets your application respond to user input in the target environment by updating your application data.
- Property binding: Lets you **interpolate** values that are computed from your application data into the HTML.

Before a view is displayed, Angular evaluates the directives and resolves the binding syntax in the template to modify the HTML elements and the DOM, according to your program data and logic. Angular supports _two-way data binding_, meaning that changes in the DOM, such as user choices, are also reflected in your program data.

### Services and dependency injection

For data or logic that isn't associated with a specific view, and that you want to share across components, you create a _service_ class. A service class definition is immediately preceded by the `@[Injectable](https://angular.io/api/core/Injectable)()` decorator. The decorator provides the metadata that allows other providers to be **injected** as dependencies into your class.
_Dependency injection_ (DI) lets you keep your component classes lean and efficient. They don't fetch data from the server, validate user input, or log directly to the console; they delegate such tasks to services.

### Routing
The Angular `[Router](https://angular.io/api/router/Router)` NgModule provides a service that lets you define a navigation path among the different application states and view hierarchies in your application. It is modeled on the familiar browser navigation conventions:

-   Enter a URL in the address bar and the browser navigates to a corresponding page
-   Click links on the page and the browser navigates to a new page
-   Click the browser's back and forward buttons and the browser navigates backward and forward through the history of pages you've seen

The router maps URL-like paths to views instead of pages. When a user performs an action, such as clicking a link, that would load a new page in the browser, the router intercepts the browser's behavior, and shows or hides view hierarchies.

The fallowing diagram shows how these basic pieces are related

![[../Images/buildingBlocksOfAngular.png]]



https://angular.io/guide/architecture
