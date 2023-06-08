### Service Examples

```ts
export class Logger {
  log(msg: any)   { console.log(msg); }
  error(msg: any) { console.error(msg); }
  warn(msg: any)  { console.warn(msg); }
}
```

Services can depend on other services. For example, here's a `HeroService` that depends on the `Logger` service, and also uses `BackendService` to get heroes. That service in turn might depend on the `[HttpClient](https://angular.io/api/common/http/HttpClient)` service to fetch heroes asynchronously from a server.

```ts
export class HeroService {
  private heroes: Hero[] = [];

  constructor(
    private backend: BackendService,
    private logger: Logger) { }

  getHeroes() {
    this.backend.getAll(Hero).then( (heroes: Hero[]) => {
      this.logger.log(`Fetched ${heroes.length} heroes.`);
      this.heroes.push(...heroes); // fill cache
    });
    return this.heroes;
  }
}
```

#### Creating an injectable service
Angular CLI provides a command to create a new service. In the following example, you add a new service to your application, which was created earlier with the `ng new` command.

To generate a new `HeroService` class in the `src/app/heroes` folder, follow these steps:

1. Run this [Angular CLI](https://angular.io/cli) command:
      `ng generate service heroes/hero`
  This command creates the following default HeroService.
```ts
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class HeroService {

}
```

The `@[Injectable](https://angular.io/api/core/Injectable)()` decorator specifies that Angular can use this class in the DI system. The metadata, `providedIn: 'root'`, means that the `HeroService` is visible throughout the application.

2. Add a `getHeroes()` method that returns the heroes from `mock.heroes.ts` to get the hero mock data:
```ts
import { Injectable } from '@angular/core';
import { HEROES } from './mock-heroes';

@Injectable({
  // declares that this service should be created
  // by the root application injector.
  providedIn: 'root',
})
export class HeroService {
  getHeroes() { return HEROES; }
}
```

For clarity and maintainability, it is recommended that you define components and services in separate files.

#### Injecting services

To inject a service as a dependency into a component, you can use component's `constructor()` and supply a constructor argument with the dependency type. The following example specifies the `HeroService` in the `HeroListComponent` constructor. The type of the `heroService` is `HeroService`. Angular recognizes the `HeroService` as a dependency, since that class was previously annotated with the `@[Injectable](https://angular.io/api/core/Injectable)` decorator.

```ts
constructor(heroService: HeroService)
```
