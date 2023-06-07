In Angular, a _template_ is a chunk of HTML. Use special syntax within a template to build on many of Angular's features.

Each Angular template in your application is a section of HTML to include as a part of the page that the browser displays. An Angular HTML template renders a view, or user interface, in the browser, just like regular HTML, but with a lot more functionality.

When you generate an Angular application with the Angular CLI, the `app.component.html` file is the default template containing placeholder HTML.

The template syntax guides show you how to control the UX/UI by coordinating data between the class and the template.

### Empower your HTML 
Extend the HTML vocabulary of your applications With special Angular syntax in your templates. For example, Angular helps you get and set DOM (Document Object Model) values dynamically with features such as built-in template functions, variables, event listening, and data binding.
Almost all HTML syntax is valid template syntax. However, because an Angular template is part of an overall webpage, and not the entire page, you don't need to include elements such as `<html>`, `<body>`, or `<base>`, and can focus exclusively on the part of the page you are developing.

**NOTE:** To eliminate the risk of script injection attacks, Angular does not support the `<script>` element in templates. Angular ignores the `<script>` tag and outputs a warning to the browser console

## More on template syntax

You might also be interested in the following:

|TOPICS|DETAILS|
|:--|:--|
|[Interpolation](https://angular.io/guide/interpolation)|Learn how to use interpolation and expressions in HTML.|
|[Template statements](https://angular.io/guide/template-statements)|Respond to events in your templates.|
|[Binding syntax](https://angular.io/guide/binding-syntax)|Use binding to coordinate values in your application.|
|[Property binding](https://angular.io/guide/property-binding)|Set properties of target elements or directive `@[Input](https://angular.io/api/core/Input)()` decorators.|
|[Attribute, class, and style bindings](https://angular.io/guide/attribute-binding)|Set the value of attributes, classes, and styles.|
|[Event binding](https://angular.io/guide/event-binding)|Listen for events and your HTML.|
|[Two-way binding](https://angular.io/guide/two-way-binding)|Share data between a class and its template.|
|[Built-in directives](https://angular.io/guide/built-in-directives)|Listen to and modify the behavior and layout of HTML.|
|[Template reference variables](https://angular.io/guide/template-reference-variables)|Use special variables to reference a DOM element within a template.|
|[Inputs and Outputs](https://angular.io/guide/inputs-outputs)|Share data between the parent context and child directives or components|
|[Template expression operators](https://angular.io/guide/template-expression-operators)|Learn about the pipe operator (`\|`), and protect against `null` or `undefined` values in your HTML.|
|[SVG in templates](https://angular.io/guide/svg-in-templates)|Dynamically generate interactive graphics.|
