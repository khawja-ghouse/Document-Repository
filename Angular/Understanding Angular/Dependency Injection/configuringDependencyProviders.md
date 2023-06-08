## Specifying a provider token

If you specify the service class as the provider token, the default behavior is for the injector to instantiate that class using the `new` operator.

In the following example, the `Logger` class provides a `Logger` instance.

```ts
providers: [Logger]
```

You can, however, configure a DI to use a different class or any other different value to associate with the `Logger` class. So when the `Logger` is injected, this new value is used instead.

In fact, the class provider syntax is a shorthand expression that expands into a provider configuration, defined by the `[Provider](https://angular.io/api/core/Provider)` interface.

Angular expands the `providers` value in this case into a full provider object as follows:

```ts
[{ provide: Logger, useClass: Logger }]
```

The expanded provider configuration is an object literal with two properties:

- The `provide` property holds the token that serves as the key for both locating a dependency value and configuring the injector.
- The second property is a provider definition object, which tells the injector how to create the dependency value. The provider-definition key can be one of the following:
    - useClass - this option tells Angular DI to instantiate a provided class when a dependency is injected
    - useExisting - allows you to alias a token and reference any existing one.
    - useFactory - allows you to define a function that constructs a dependency.
    - useValue - provides a static value that should be used as a dependency.

The section below describes how to use the mentioned provider definition keys.

### Class providers: useClass

The `useClass` provider key lets you create and return a new instance of the specified class. You can use this type of provider to substitute an alternative implementation for a common or default class. The alternative implementation can, for example, implement a different strategy, extend the default class, or emulate the behavior of the real class in a test case. In the following example, the `BetterLogger` class would be instantiated when the `Logger` dependency is requested in a component or any other class.

```ts
[{ provide: Logger, useClass: BetterLogger }]
```

### Alias providers: useExisting
The `useExisting` provider key lets you map one token to another. In effect, the first token is an alias for the service associated with the second token, creating two ways to access the same service object.

In the following example, the injector injects the singleton instance of `NewLogger` when the component asks for either the new or the old logger. In this way, `OldLogger` is an alias for `NewLogger`.
```ts
[ NewLogger,
  // Alias OldLogger w/ reference to NewLogger
  { provide: OldLogger, useExisting: NewLogger}]
```

Ensure you do not alias `OldLogger` to `NewLogger` with `useClass`, as this creates two different `NewLogger` instances.

### Factory providers: useFactory
The `useFactory` provider key lets you create a dependency object by calling a factory function. With this approach you can create a dynamic value based on information available in the DI and elsewhere in the app.

### Value providers: useValue

The `useValue` key lets you associate a fixed value with a DI token. Use this technique to provide runtime configuration constants such as website base addresses and feature flags. You can also use a value provider in a unit test to provide mock data in place of a production data service. The next section provides more information about the `useValue` key.
