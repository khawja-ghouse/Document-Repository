For every Angular component you write, you can define not only an HTML template, but also the CSS styles that go with that template, specifying any selectors, rules, and media queries that you need.

One way to do this is to set the `styles` property in the component metadata. The `styles` property takes an array of strings that contain CSS code. Usually you give it one string, as in the following example:

```TS
@Component({
  selector: 'app-root',
  template: `
    <h1>Tour of Heroes</h1>
    <app-hero-main [hero]="hero"></app-hero-main>
  `,
  styles: ['h1 { font-weight: normal; }']
})
export class HeroAppComponent {
/* . . . */
}
```

### Authoring a component to support customization
As component author, you can explicitly design a component to accept customization in one of four different ways.

1. **Use CSS Custom Properties (recommended)**
2.  **Declare global CSS with `@mixin`**
3. **Customize with CSS `::part`**
4. **Provide a TypeScript API**

## Loading component styles

There are several ways to add styles to a component:

- By setting `styles` or `styleUrls` metadata
- Inline in the template HTML
- With CSS imports

The scoping rules outlined earlier apply to each of these loading patterns.

### Styles in component metadata[](https://angular.io/guide/component-styles#styles-in-component-metadata "Link to this heading")

Add a `styles` array property to the `@[Component](https://angular.io/api/core/Component)` decorator.

Each string in the array defines some CSS for this component
```ts
@Component({
  selector: 'app-root',
  template: `
    <h1>Tour of Heroes</h1>
    <app-hero-main [hero]="hero"></app-hero-main>
  `,
  styles: ['h1 { font-weight: normal; }']
})
export class HeroAppComponent {
/* . . . */
}
```

### Style files in component metadata

Load styles from external CSS files by adding a `styleUrls` property to a component's `@[Component](https://angular.io/api/core/Component)` decorator:

```ts
@Component({
  selector: 'app-root',
  template: `
    <h1>Tour of Heroes</h1>
    <app-hero-main [hero]="hero"></app-hero-main>
  `,
  styleUrls: ['./hero-app.component.css']
})
export class HeroAppComponent {
/* . . . */
}
```

```css
hero-app.component.css
h1 {
  font-weight: normal;
}
```

### Template link tags

You can also write `<link>` tags into the component's HTML template.

```ts
@Component({
  selector: 'app-hero-team',
  template: `
    <!-- We must use a relative URL so that the AOT compiler can find the stylesheet -->
    <link rel="stylesheet" href="../assets/hero-team.component.css">
    <h3>Team</h3>
    <ul>
      <li *ngFor="let member of hero.team">
        {{member}}
      </li>
    </ul>`
})
```

### CSS @imports

Import CSS files into the CSS files using the standard CSS `@import` rule. n this case, the URL is relative to the CSS file into which you're importing.

```css
/* The AOT compiler needs the `./` to show that this is local */
@import './hero-details-box.css';
```

### External and global style files[](https://angular.io/guide/component-styles#external-and-global-style-files "Link to this heading")

When building with the CLI, you must configure the `angular.json` to include _all external assets_, including external style files.

Register **global** style files in the `styles` section which, by default, is pre-configured with the global `styles.css` file.