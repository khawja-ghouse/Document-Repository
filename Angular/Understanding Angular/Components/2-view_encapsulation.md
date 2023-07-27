In Angular, a component's styles can be encapsulated within the component's host element so that they don't affect the rest of the application.

### Inspecting generated CSS

When using the emulated view encapsulation, Angular pre-processes all the component's styles so that they are only applied to the component's view.
In the DOM of a running Angular application, elements belonging to components using emulated view encapsulation have some extra attributes attached to them:

```html
<hero-details _nghost-pmm-5>
  <h2 _ngcontent-pmm-5>Mister Fantastic</h2>
  <hero-team _ngcontent-pmm-5 _nghost-pmm-6>
    <h3 _ngcontent-pmm-6>Team</h3>
  </hero-team>
</hero-details>
```

Attributes
**-nghost** : Are added to elements that enclose a component's view and that would be ShadowRoots in a native Shadow DOM encapsulation. This is typically the case for components' host elements.

**_ngcontent**:  Are added to child element within a component's view, those are used to match the elements with their respective emulated ShadowRoots (host elements with a matching `_nghost` attribute)

The exact values of these attributes are a private implementation detail of Angular. They are automatically created and you should never refer to them in application code.

They are targeted by the created component styles, which are injected in the `<head>` section of the DOM:
```CSS
[_nghost-pmm-5] {
  display: block;
  border: 1px solid black;
}
h3[_ngcontent-pmm-6] {
  background-color: white;
  border: 1px solid #777;
}
```
## Mixing encapsulation modes
As mentioned earlier, you specify the encapsulation mode in the Component's decorator on a _per component_ basis. This means that within your application you can have different components using different encapsulation strategies.

Although possible, this is not recommended. If it is really needed, you should be aware of how the styles of components using different encapsulation modes interact with each other:

|MODES|DETAILS|
|:--|:--|
|`ViewEncapsulation.Emulated`|The styles of components are added to the `<head>` of the document, making them available throughout the application, but their selectors only affect elements within their respective components' templates.|
|`ViewEncapsulation.None`|The styles of components are added to the `<head>` of the document, making them available throughout the application, so are completely global and affect any matching elements within the document.|
|`ViewEncapsulation.ShadowDom`|The styles of components are only added to the shadow DOM host, ensuring that they only affect elements within their respective components' views.|

The `viewEncapsulation` property is used to control how the encapsulation is applied on a per component basis. The default value is `ViewEncapsulation.Emulated`

`ViewEncapsulation.Emulated` means that styles are pre-processed and attached to component elements with extra attributes

If you set `viewEncapsulation` to `ViewEncapsulation.None`, Angular does not apply any sort of view encapsulation meaning that any styles specified for the component are applied globally and can affect any HTML element present within the application