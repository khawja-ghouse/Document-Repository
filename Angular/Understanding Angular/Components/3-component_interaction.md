## Angular Components Interaction Methods

Data sharing between the angular components is possible with the following ways,

- Sharing Data from Parent to Child:  **@Input**
- Sharing Data from Child to Parent:  **@ViewChild**
- Sharing Data from Child to Parent:  **@Output & EventEmitter** 
- Sharing Data Between Various Components:  **Service**

### Sharing Data from Parent to Child:  @Input

Firstly, parent to child component communication in angular provides a decorator called @Input decorator which can be used to pass data from Parent to Child. This is one of the most common methods of sharing data from Parent to Child in Angular application. Now, let’s see the working of the @Input decorator in the following snippets,

```Typescript
Parent_Component
import {Component } from '@angular/core';

@Component({
	selector: 'app-component',
	template:`
		<child-component [childMessage]="parentMessage"></child-component>
	`,
	styleUrls:['./app.scss']
})
export class AppComponent{
parentMessage = 'Its a message from parent App Component ';

constructor(){}
}

Child_Component
---------------------------------------------------------------------------------------------
import {Component } from '@angular/core';

@Component({
	selector: 'child-component',
	template:`
		This is a message from Parent {{childMessage}}
	`,
	styleUrls:['./app.scss']
})
export class ChildComponent{
@Input() childMessage:string;
constructor(){}
}
```

### Sharing Data from Child to Parent:  @ViewChild


```typescript
import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { ChildComponentComponent } from '../child-component/child-component.component';

@Component({
  selector: 'app-parent-component',
  templateUrl: './parent-component.component.html',
  styleUrls: ['./parent-component.component.css']
})

export class ParentComponentComponent implements OnInit,AfterViewInit {
  // with this we can access properties, function
  @ViewChild(ChildComponentComponent) child: any;
  
  constructor() { }
  // we need to implement this because only at this point the child component is ready
  ngAfterViewInit(): void {
    console.log('Inside ngAfterViewInit');
    this.message = this.child.message;
    console.log("From Parent : ",this.message);
  }

  message!: string;
  ngOnInit(): void 
  }
}
```

```Typescript
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-child-component',
  templateUrl: './child-component.component.html',
  styleUrls: ['./child-component.component.css']
})

export class ChildComponentComponent implements OnInit {

  message = "Its a message from child Component !!";
  constructor() { }
  ngOnInit(): void {
  }
}
```

### Sharing Data from Child to Parent:  @Output & EventEmitter

Decorator that marks a class field as an output property and supplies configuration metadata. The DOM property bound to the output property is automatically updated during change detection.
Use the `@Output()` decorator in the child component or directive to allow data to flow from the child _out_ to the parent.
An `@Output()` property should normally be initialized to an Angular [`EventEmitter`](https://docs.w3cub.com/angular~10/api/core/eventemitter) with values flowing out of the component as [events](https://docs.w3cub.com/angular~10/guide/event-binding).

                data flow
Parent   <--------------- Child 

<div style="background-color:#ccc;padding:5px">
Just like with @Input, you can use @Output on the property of the child component but its type should be EventEmitter.
</div>

```ts
// ChildComponent.ts

import { Component, EventEmitter, OnInit, Output } from '@angular/core';
@Component({
  selector: 'app-child-component',
  templateUrl: './child-component.component.html',
  styleUrls: ['./child-component.component.css']
})

export class ChildComponentComponent implements OnInit {
  message = "Its a message from child Component !!";
  @Output() newItemEvent = new EventEmitter<string>();

  constructor() { }
  ngOnInit(): void {
  }
  addNewItem(value: string) {
    this.newItemEvent.emit(value);
  }
}

childComponent.html
<label>Add an item: <input #newItem></label>
<button (click)="addNewItem(newItem.value)">Add to parent's list</button>

---------------------------------------------------------------------------------------------

parent.ts
import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { ChildComponentComponent } from '../child-component/child-component.component';

@Component({
  selector: 'app-parent-component',
  templateUrl: './parent-component.component.html',
  styleUrls: ['./parent-component.component.css']
})
export class ParentComponentComponent implements OnInit,AfterViewInit {
  // with this we can access properties, function
  @ViewChild(ChildComponentComponent) child: any;


  constructor() { }
  // we need to implement this because only at this point the child component is ready
  ngAfterViewInit(): void {
    console.log('Inside ngAfterViewInit');
    this.message = this.child.message;
    console.log("From Parent : ",this.message);
  }

  message!: string;
  newMessage! : string;
  ngOnInit(): void {

  }

  items = ['item1', 'item2', 'item3', 'item4'];

  receivedItemsFromChild(newItem: string) {
    this.items.push(newItem);
  }

}

parent.html

<app-child-component (newItemEvent)="receivedItemsFromChild($event)"></app-child-component>

<!-- (newItemEvent) this an event binding  -->

<ul>

  <li *ngFor="let item of items">{{item}}</li>

</ul>
```

