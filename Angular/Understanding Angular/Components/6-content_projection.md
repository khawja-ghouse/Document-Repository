Content projection is a pattern in which you insert, or _project_, the content you want to use inside another component. For example, you could have a `Card` component that accepts content provided by another component.

The following sections describe common implementations of content projection in Angular, including:
1. **Single-slot content projection**
	The most basic form of content projection is **_single-slot content projection_**. Single-slot content projection refers to creating a component into which you can project one component.
	
	To create a component that uses single-slot content projection:
	
	1. Create a component.
	2. In the template for your component, add an `[<ng-content>](https://angular.io/api/core/ng-content)` element where you want the projected content to appear.
	
	For example, the following component uses an `[<ng-content>](https://angular.io/api/core/ng-content)` element to display a message.
	
	```ts
	import { Component } from '@angular/core';
	
	@Component({
	  selector: 'app-zippy-basic',
	  template: `
	    <h2>Single-slot content projection</h2>
	    <ng-content></ng-content>
	  `
	})
	export class ZippyBasicComponent {}
	```
	
	With the `[<ng-content>](https://angular.io/api/core/ng-content)` element in place, users of this component can now project their own message into the component. For example:
	
	app.component.html
	
	```html
	<app-zippy-basic>
	  <p>Is content projection cool?</p>
	</app-zippy-basic>
	```
	
	The `[<ng-content>](https://angular.io/api/core/ng-content)` element is a placeholder that does not create a real DOM element. Custom attributes applied to `[<ng-content>](https://angular.io/api/core/ng-content)` are ignored.
2. **Multi-slot content projection** [Multi-slot content projection]([Angular - Content projection](https://angular.io/guide/content-projection#multi-slot-content-projection))
3. **Conditional content projection**
