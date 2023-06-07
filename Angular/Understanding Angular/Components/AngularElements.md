_Angular elements_ are Angular components packaged as _custom elements_ (also called Web Components), a web standard for defining new HTML elements in a framework-agnostic way.

[Custom elements](https://developer.mozilla.org/docs/Web/Web_Components/Using_custom_elements) are a Web Platform feature currently supported by Chrome, Edge (Chromium-based), Firefox, Opera, and Safari, and available in other browsers through polyfills.
A custom element extends HTML by allowing you to define a tag whose content is created and controlled by JavaScript code. The browser maintains a `CustomElementRegistry` of defined custom elements, which maps an instantiable JavaScript class to an HTML tag.

The `@angular/elements` package exports a `[createCustomElement](https://angular.io/api/elements/createCustomElement)()` API that provides a bridge from Angular's component interface and change detection functionality to the built-in DOM API
Transforming a component to a custom element makes all of the required Angular infrastructure available to the browser. Creating a custom element is simple and straightforward, and automatically connects your component-defined view with change detection and data binding, mapping Angular functionality to the corresponding built-in HTML equivalents.

## Using custom elements[](https://angular.io/guide/elements#using-custom-elements "Link to this heading")

Custom elements bootstrap themselves - they start automatically when they are added to the DOM, and are automatically destroyed when removed from the DOM. Once a custom element is added to the DOM for any page, it looks and behaves like any other HTML element, and does not require any special knowledge of Angular terms or usage conventions.