Reactive forms and template-driven forms process and manage form data differently. Each approach offers different advantages.

|FORMS|DETAILS|
|:--|:--|
|Reactive forms|Provide direct, explicit access to the underlying form's object model. Compared to template-driven forms, they are more robust: they're more scalable, reusable, and testable. If forms are a key part of your application, or you're already using reactive patterns for building your application, use reactive forms.|
|Template-driven forms|Rely on directives in the template to create and manipulate the underlying object model. They are useful for adding a simple form to an app, such as an email list signup form. They're straightforward to add to an app, but they don't scale as well as reactive forms. If you have very basic form requirements and logic that can be managed solely in the template, template-driven forms could be a good fit.|

### Setup in reactive forms

With reactive forms, you define the form model directly in the component class. The `[formControl]` directive links the explicitly created `[FormControl](https://angular.io/api/forms/FormControl)` instance to a specific form element in the view, using an internal value accessor.

The following component implements an input field for a single control, using reactive forms. In this example, the form model is the `[FormControl](https://angular.io/api/forms/FormControl)` instance.

```ts
import { Component } from '@angular/core';
import { FormControl } from '@angular/forms';

@Component({
  selector: 'app-reactive-favorite-color',
  template: `
    Favorite Color: <input type="text" [formControl]="favoriteColorControl">
  `
})
export class FavoriteColorComponent {
  favoriteColorControl = new FormControl('');
}
```

![formControl](../images/FormControl.png)
Fig: Direct access to Form  Model in a reactive form.


### Setup in template-driven forms
In template-driven forms, the form model is implicit, rather than explicit. The directive `[NgModel](https://angular.io/api/forms/NgModel)` creates and manages a `[FormControl](https://angular.io/api/forms/FormControl)` instance for a given form element.

The following component implements the same input field for a single control, using template-driven forms.

```ts
import { Component } from '@angular/core';

@Component({
  selector: 'app-template-favorite-color',
  template: `
    Favorite Color: <input type="text" [(ngModel)]="favoriteColor">
  `
})
export class FavoriteColorComponent {
  favoriteColor = '';
}
```

In a template-driven form the source of truth is the template. You do not have direct programmatic access to the `[FormControl](https://angular.io/api/forms/FormControl)` instance, as shown in Figure 2.

![templateDrivenForm](../images/TemplateDrivenForm.png)
Fig: Indirect access to forms model in a template-driven form.

### Reactive Forms

## Adding a basic form control

There are three steps to using form controls.

1. Register the reactive forms module in your application. This module declares the reactive-form directives that you need to use reactive forms.
	```ts
	import { ReactiveFormsModule } from '@angular/forms';

		@NgModule({
		  imports: [
		    // other imports ...
		    ReactiveFormsModule
		  ],
		})
		export class AppModule { }
    ```
    
2. Generate a new component and instantiate a new `[FormControl](https://angular.io/api/forms/FormControl)
    ```ts
    import { Component } from '@angular/core';
	import { FormControl } from '@angular/forms';
	
	@Component({
	  selector: 'app-name-editor',
	  templateUrl: './name-editor.component.html',
	  styleUrls: ['./name-editor.component.css']
	})
	export class NameEditorComponent {
	  name = new FormControl('');
	}
	```
3. Register the `[FormControl](https://angular.io/api/forms/FormControl)` in the template.
    ```html
    <label for="name">Name: </label>
	<input id="name" type="text" [formControl]="name">
    ```

You can then display the form by adding the component to the template.

The following examples show how to add a single form control. In the example, the user enters their name into an input field, captures that input value, and displays the current value of the form control element.



## Grouping form controls

