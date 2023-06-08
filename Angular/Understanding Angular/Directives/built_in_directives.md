Directives are classes that add additional behaviour to elements in your Angular applications. Use Angular's built-in directives to manage forms, lists, styles, and what users see.

The different types of Angular directives are as fallows:
1. Attribute directives.
2. Structural directives.

## Built-in attribute directives

Many NgModules such as the [`RouterModule`](https://angular.io/guide/router "Routing and Navigation") and the [`FormsModule`](https://angular.io/guide/forms "Forms") define their own attribute directives. The most common attribute directives are as follows:

- **NgClass:** Adds and removes a set of CSS classes.
- **NgStyle**: Adds and removes a set of HTML styles.
- **NgModel**: Adds two-way data binding to an HTML form element.

Adding and removing classes with NgClass.

**Using NgClass with an expression**

On the element you'd like to style, add `[[ngClass](https://angular.io/api/common/NgClass)]` and set it equal to an expression. In this case, `isSpecial` is a boolean set to `true` in `app.component.ts`. Because `isSpecial` is true, `[ngClass](https://angular.io/api/common/NgClass)` applies the class of `special` to the `<div>`.

```html
<!-- toggle the "special" class on/off with a property -->
<div [ngClass]="isSpecial ? 'special' : ''">This div is special</div>

special is a class in the css file
```

**Using NgClass with a method.**
1. To use `[NgClass](https://angular.io/api/common/NgClass)` with a method, add the method to the component class. In the following example, `setCurrentClasses()` sets the property `currentClasses` with an object that adds or removes three classes based on the `true` or `false` state of three other component properties. 
   Each key of the object is a CSS class name. If a key is `true`, `[ngClass](https://angular.io/api/common/NgClass)` adds the class. If a key is `false`, `[ngClass](https://angular.io/api/common/NgClass)` removes the class.
```ts
currentClasses: Record<string, boolean> = {};
/* . . . */
setCurrentClasses() {
  // CSS classes: added/removed per current state of component properties
  this.currentClasses =  {
    saveable: this.canSave,
    modified: !this.isUnchanged,
    special:  this.isSpecial
  };
}
```

2. In the template, add the `[ngClass](https://angular.io/api/common/NgClass)` property binding to `currentClasses` to set the element's classes:
   ```html
   <div [ngClass]="currentClasses">This div is initially saveable, unchanged, and special.</div>
```

## Setting inline styles with `NgStyle`


Use `[NgStyle](https://angular.io/api/common/NgStyle)` to set multiple inline styles simultaneously, based on the state of the component.

1. To use `[NgStyle](https://angular.io/api/common/NgStyle)`, add a method to the component class.
    
    In the following example, `setCurrentStyles()` sets the property `currentStyles` with an object that defines three styles, based on the state of three other component properties.
    
    **src/app/app.component.ts**
    ```ts
    currentStyles: Record<string, string> = {};
/* . . . */
setCurrentStyles() {
  // CSS styles: set per current state of component properties
  this.currentStyles = {
    'font-style':  this.canSave      ? 'italic' : 'normal',
    'font-weight': !this.isUnchanged ? 'bold'   : 'normal',
    'font-size':   this.isSpecial    ? '24px'   : '12px'
  };
}
```

  
2. To set the element's styles, add an `[ngStyle](https://angular.io/api/common/NgStyle)` property binding to `currentStyles`.
    
    **src/app/app.component.html**
    
    ```html
    <div [ngStyle]="currentStyles">
	  This div is initially italic, normal weight, and extra large (24px).
	</div>
```
    

For this use case, Angular applies the styles upon initialization and in case of changes. To do this, the full example calls `setCurrentStyles()` initially with `ngOnInit()` and when the dependent properties change through a button click.

**Displaying and updating properties with ngModel**

Use the `NgModel` directive to display a data property and update that property when the user makes changes.

1. Import **FormsModule** and add it to the NgModule's imports list.

```ts
import { FormsModule } from '@angular/forms'; // <--- JavaScript import from Angular
/* . . . */
@NgModule({
  /* . . . */

  imports: [
    BrowserModule,
    FormsModule // <--- import into the NgModule
  ],
  /* . . . */
})
export class AppModule { }
```
2. Add an `[([ngModel](https://angular.io/api/forms/NgModel))]` binding on an HTML `<form>` element and set it equal to the property, here `name`.
```html
<label for="example-ngModel">[(ngModel)]:</label>
<input [(ngModel)]="currentItem.name" id="example-ngModel">
```
   This `[([ngModel](https://angular.io/api/forms/NgModel))]` syntax can only set a data-bound property.

 To customize your configuration, write the expanded form, which separates the property and event binding. Use [property binding](https://angular.io/guide/property-binding) to set the property and [event binding](https://angular.io/guide/event-binding) to respond to changes. The following example changes the `<input>` value to uppercase:
```html
<input [ngModel]="currentItem.name" (ngModelChange)="setUppercaseName($event)" id="example-uppercase">
```

## Building an attribute directive

1. To create a directive, use the CLI command [`ng generate directive`](https://angular.io/cli/generate).
   ``
```ts
import { Directive, ElementRef } from '@angular/core';

@Directive({
  selector: '[appHighlight]'
})
export class HighlightDirective {
    constructor(private el: ElementRef) {
       this.el.nativeElement.style.backgroundColor = 'yellow';
    }
}
```

### Applying an attribute directive
1. To use the `HighlightDirective`, add a `<p>` element to the HTML template with the directive as an attribute.
  ```html
  <p appHighlight>Highlight me!</p>
```

Angular creates an instance of the `HighlightDirective` class and injects a reference to the `<p>` element into the directive's constructor, which sets the `<p>` element's background style to yellow.

## Handling user events

```ts
import { Directive, ElementRef, HostListener } from '@angular/core';

@Directive({
  selector: '[appHighlight]'
})
export class HighlightDirective {

  constructor(private el: ElementRef) { }

  @HostListener('mouseenter') onMouseEnter() {
    this.highlight('yellow');
  }

  @HostListener('mouseleave') onMouseLeave() {
    this.highlight('');
  }

  private highlight(color: string) {
    this.el.nativeElement.style.backgroundColor = color;
  }

}

```


--- 

## Built-in structural directives

Structural directives are responsible for HTML layout. They shape or reshape the DOM's structure, typically by adding, removing, and manipulating the host elements to which they are attached.

This section introduces the most common built-in structural directives:

|COMMON BUILT-IN STRUCTURAL DIRECTIVES|DETAILS|
|:--|:--|
|[`NgIf`](https://angular.io/guide/built-in-directives#ngIf)|Conditionally creates or disposes of subviews from the template.|
|[`NgFor`](https://angular.io/guide/built-in-directives#ngFor)|Repeat a node for each item in a list.|
|[`NgSwitch`](https://angular.io/guide/built-in-directives#ngSwitch)|A set of directives that switch among alternative views.|

When structural directives are applied they generally are prefixed by an asterisk, `*`, such as `*[ngIf](https://angular.io/api/common/NgIf)`. This convention is shorthand that Angular interprets and converts into a longer form. Angular transforms the asterisk in front of a structural directive into an `[<ng-template>](https://angular.io/api/core/ng-template)` that surrounds the host element and its descendants.

For example, let's take the following code which uses an `*[ngIf](https://angular.io/api/common/NgIf)` to display the hero's name if `hero` exists:

```html
<div *ngIf="hero" class="name">{{hero.name}}</div>
```

Angular creates an `[<ng-template>](https://angular.io/api/core/ng-template)` element and applies the `*ngIf` directive onto it where it becomes a property binding in square brackets, `[[ngIf](https://angular.io/api/common/NgIf)]`. The rest of the `<div>`, including its class attribute, is then moved inside the `<ng-template>`

```html
<ng-template [ngIf]="hero">
  <div class="name">{{hero.name}}</div>
</ng-template>
```

Note that Angular does not actually create a real `[<ng-template>](https://angular.io/api/core/ng-template)` element, but instead only renders the `<div>` element.

```html
<div _ngcontent-c0>Mr. Nice</div>
```

The following example compares the shorthand use of the asterisk in `*[ngFor](https://angular.io/api/common/NgFor)` with the longhand `[<ng-template>](https://angular.io/api/core/ng-template)` form:

```html
<div
  *ngFor="let hero of heroes; let i=index; let odd=odd; trackBy: trackById"
  [class.odd]="odd">
  ({{i}}) {{hero.name}}
</div>

<ng-template ngFor let-hero [ngForOf]="heroes"
  let-i="index" let-odd="odd" [ngForTrackBy]="trackById">
  <div [class.odd]="odd">
    ({{i}}) {{hero.name}}
  </div>
</ng-template>
```
