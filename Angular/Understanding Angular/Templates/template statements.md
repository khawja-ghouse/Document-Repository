Template statements are methods or properties that you can use in your HTML to respond to user events. With template statements, your application can engage users through actions such as displaying dynamic content or submitting forms.

In the following example, the template statement `deleteHero()` appears in quotes to the right of the equals sign `=` character as in `(event)="statement"`.

```html
<button type="button" (click)="deleteHero()">Delete hero</button>
```
When the user clicks the **Delete hero** button, Angular calls the `deleteHero()` method in the component class.

Use template statements with elements, components, or directives in response to events.

Like [template expressions](https://angular.io/guide/interpolation), template statements use a language that looks like JavaScript. However, the parser for template statements differs from the parser for template expressions. In addition, the template statements parser specifically supports both basic assignment (`=`) and chaining expressions with semicolons (`;`).
The following JavaScript and template expression syntax is not allowed:
- `new`
- Increment and decrement operators, `++` and `--`
- Operator assignment, such as `+=` and `-=`
- The bitwise operators, such as `|` and `&`
- The [pipe operator](https://angular.io/guide/pipes)

**Statement context**
Statements have a context —a particular part of the application to which the statement belongs.

Statements can refer only to what's in the statement context, which is typically the component instance. For example, `deleteHero()` of `(click)="deleteHero()"` is a method of the component in the following snippet.

app.component.html
```html
<button type="button" (click)="deleteHero()">Delete hero</button>
```
The statement context may also refer to properties of the template's own context. In the following example, the component's event handling method, `onSave()` takes the template's own `$event` object as an argument. On the next two lines, the `deleteHero()` method takes a [template input variable](https://angular.io/guide/structural-directives#shorthand), `hero`, and `onSubmit()` takes a [template reference variable](https://angular.io/guide/template-reference-variables), `#heroForm`.

```HTML
<button type="button" (click)="onSave($event)">Save</button>
<button type="button" *ngFor="let hero of heroes" (click)="deleteHero(hero)">{{hero.name}}</button>
<form #heroForm (ngSubmit)="onSubmit(heroForm)"> ... </form>
```

In this example, the context of the `$event` object, `hero`, and `#heroForm` is the template.

Template context names take precedence over component context names. In the preceding `deleteHero(hero)`, the `hero` is the template input variable, not the component's `hero` property.