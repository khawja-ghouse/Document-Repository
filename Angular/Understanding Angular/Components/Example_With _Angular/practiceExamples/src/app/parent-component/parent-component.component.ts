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
