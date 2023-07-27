# Angular components overview

Components are the main building block for Angular applications. Each component consists of:

- An HTML template that declares what renders on the page
- A TypeScript class that defines behaviour
- A CSS selector that defines how the component is used in a template
- Optionally, CSS styles applied to the template

#### Creating a Component
The best way to create a component is with the Angular CLI. You can also create a component manually.

To create a component using the Angular CLI:

1. From a terminal window, navigate to the directory containing your application.
2. Run the `ng generate component <component-name>` command, where `<component-name>` is the name of your new component.

By default, this command creates the following:

- A directory named after the component
- A component file, `<component-name>.component.ts`
- A template file, `<component-name>.component.html`
- A CSS file, `<component-name>.component.css`
- A testing specification file, `<component-name>.component.spec.ts`

Where `<component-name>` is the name of your component.

Although the Angular CLI is the best way to create an Angular component, you can also create a component manually. This section describes how to create the core component file within an existing Angular project.

To create a new component manually:
1. Navigate to your Angular project directory.
2. Create a new file, `<component-name>.component.ts`. 
3. At the top of the file, add the following import statement.

```typescript
import { Component } from '@angular/core';
```

4. After the `import` statement, add a `@Component` decorator.
5. Choose a CSS selector for the component.
```typescript
@Component({
  selector: 'app-component-overview',
})
```
6. Define the HTML template that the component uses to display information. In most cases, this template is a separate HTML file.
```typescript
@Component({
  selector: 'app-component-overview',
  templateUrl: './component-overview.component.html',
})
```
7. Select the styles for the component's template. In most cases, you define the styles for your component's template in a separate file.
   ```typescript
   @Component({
  selector: 'app-component-overview',
  templateUrl: './component-overview.component.html',
  styleUrls: ['./component-overview.component.css']
})
```
8. Add a `class` statement that includes the code for the component.
   ```typescript
   export class ComponentOverviewComponent {

}
```
