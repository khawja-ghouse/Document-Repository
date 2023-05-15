Here are some of the best links to get started on Angular.
1. Official Angular Website: [https://angular.io/](https://angular.io/)
2. Angular University: [https://angular-university.io/](https://angular-university.io/)
3. Angular Style Guide: [https://angular.io/guide/styleguide](https://angular.io/guide/styleguide)
4. Angular Developer Guide on Mozilla: [https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array)


### What is Angular?

This topic can help you understand Angular: what Angular is, what advantages it provides, and what you might expect as you start to build your applications.

Angular is a popular open-source web application framework for building dynamic and interactive web applications.
Angular is a development platform, built on **TypeScript**. As a platform, Angular includes:

-   A component-based framework for building scalable web applications
-   A collection of well-integrated libraries that cover a wide variety of features, including routing, forms management, client-server communication, and more
-  A suite of developer tools to help you develop, build, test, and update your code

Some key features of Angular include its use of TypeScript, a strongly-typed superset of JavaScript that provides improved type-checking and code organization; its **component-based architecture,** which promotes modularity and reusability; and its built-in support for reactive programming with RxJS.

## Angular applications: The essentials

This section explains the core ideas behind Angular. Understanding these ideas can help you design and build your applications more effectively.


### 1. Components

Components are the building blocks that compose an application.  A component includes a TypeScript class with a ***@Component()*** decorator, an HTML template, and styles. The `@Component()` decorator specifies the following Angular-specific information:
-   A CSS selector that defines how the component is used in a template. HTML elements in your template that match this selector become instances of the component.
-  An HTML template that instructs Angular how to render the component.
-   An optional set of CSS styles that define the appearance of the template's HTML elements

The @Component decorator is used to define a new component in Angular. It is a TypeScript decorator that is applied to the class that represents the component. The decorator provides metadata about the component, such as its selector, template, and styles.

Example
```typescript
import { Component } from '@angular/core';

@Component({
  selector: 'app-hello',
  template: '<h1>Hello, {{ name }}!</h1>',
  styles: ['h1 { color: blue; }']
})

export class HelloComponent {
  name = 'World';
}

```

In this example, we define a new component called **HelloComponent**. The @Component decorator is applied to the class, and it provides three pieces of metadata:

-   **selector**: This specifies the name of the component, which is used to identify it in the template of other components. In this case, the selector is 'app-hello'.
    
-   **template**: This specifies the HTML template for the component. In this case, the template is a simple string that displays the message "Hello, World!".
    
-   **styles**: This specifies the CSS styles for the component. In this case, we define a style for the h1 element that sets its color to blue.
    

The HelloComponent class also defines a name property, which is used in the template to display the message "Hello, World!". The name property could be set dynamically based on input data or user interactions.

Once a component is defined using the @Component decorator, it can be used in other components or in the root application by including its selector in the template. For example, we could use the HelloComponent in another component's template like this:

```html
<app-hello></app-hello>
```

When Angular renders this component, the resulting DOM looks like this:

```html
<app-hello>
	<h1>Hello, World</h1>
</app-hello>

```

### Templates

Every component has an HTML template that declares how that component renders. You define this template either inline or by file path.

Angular adds syntax elements that extend HTML so you can insert dynamic values from your component. Angular automatically updates the rendered DOM when your component's state changes. One application of this feature is inserting dynamic text, as shown in the following example.

```HTML
<p>{{ message }}</p>
```

The value of the message comes from the component class:

```Typescript
import { Component } from '@angular/core';

@Component ({
  selector: 'hello-world-interpolation',
  templateUrl: './hello-world-interpolation.component.html'
})
export class HelloWorldInterpolationComponent {
    message = 'Hello, World!';
}
```

When the application loads the component and its template, the user sees the following:

```HTML
<p>Hello, World!</p>
```

Notice the use of double curly braces—they instruct Angular to interpolate the contents within them.

Angular also supports property bindings, to help you set values for properties and attributes of HTML elements and pass values to your application's presentation logic.

```HTML
<p [id]="sayHelloId" 
   [style.color]="fontColor"> 
   You can set my color in the component! 
</p>
```
Notice the use of the square brackets—that syntax indicates that you're binding the property or attribute to a value in the component class.

Declare event listeners to listen for and respond to user actions such as keystrokes, mouse movements, clicks, and touches. You declare an event listener by specifying the event name in parentheses:

```HTML
<button
  type="button"
  [disabled]="canClick"
  (click)="sayMessage()">
  Trigger alert message
</button>
```
The preceding example calls a method, which is defined in the component class:

```Typescript
sayMessage() { 
alert(this.message); 
}
```

The following is a combined example of Interpolation, Property Binding, and Event Binding within an Angular template:

*hello-world-binding.component.ts*

```TYPEscript
import { Component } from '@angular/core';

@Component ({
  selector: 'hello-world-bindings',
  templateUrl: './hello-world-bindings.component.html'
})
export class HelloWorldBindingsComponent {
  fontColor = 'blue';
  sayHelloId = 1;
  canClick = false;
  message = 'Hello, World';

  sayMessage() {
    alert(this.message);
  }
}
```

*hello-world-bindings.component.html*
```HTML
<button
  type="button"
  [disabled]="canClick"
  (click)="sayMessage()">
  Trigger alert message
</button>

<p
  [id]="sayHelloId"
  [style.color]="fontColor">
  You can set my color in the component!
</p>

<p>My color is {{ fontColor }}</p>
```
