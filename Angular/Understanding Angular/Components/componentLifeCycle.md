Component Lifecycle

- A component instance has a **lifecycle that starts when Angular instantiates the component** class and renders the component view along with its child views. 
- The lifecycle continues with change detection, as Angular checks to see when data-bound properties change, and updates both the view and the component instance as needed.
- The lifecycle ends when Angular destroys the component instance and removes its rendered template from the DOM.
Directives have a similar lifecycle, as Angular creates, updates, and destroys instances in the course of execution.
Your application can use [lifecycle hook methods](https://angular.io/guide/glossary#lifecycle-hook "Definition of lifecycle hook") to tap into key events in the lifecycle of a component or directive to initialize new instances, initiate change detection when needed, respond to updates during change detection, and clean up before deletion of instances.

## Responding to lifecycle events

Respond to **events in the lifecycle of a component or directive by implementing one or more of the _lifecycle hook_ interfaces in the Angular `core` library**. The hooks give you the opportunity to act on a component or directive instance at the appropriate moment, as Angular creates, updates, or destroys that instance.

Each interface defines the prototype for a single hook method, whose name is the interface name prefixed with `ng`. For example, the` OnInit` interface has a hook method named `ngOnInit()` . If you implement this method in your component or directive class, Angular calls it shortly after checking the input properties for that component or directive for the first time.

#### Lifecycle event sequence
After your application instantiates a component or directive by calling its constructor, Angular calls the hook methods you have implemented at the appropriate point in the lifecycle of that instance.

Angular executes hook methods in the following sequence. Use them to perform the following kinds of operations.


1. **ngOnChanges()**

   **Purpose**: Respond when Angular sets or resets data-bound input properties. The method receives a **SimpleChanges** object of current and previous property values. This happens frequently, so any operation you perform here impacts performance significantly
   **Timing**: Called before `ngOnInit()` (if the component has bound inputs) and whenever one or more data-bound input properties change.
   If your component has no inputs or you use it without providing any inputs, the framework will not call `ngOnChanges()`.
	
   