import { Component, Input, OnChanges,  SimpleChanges } from '@angular/core';

@Component({
  selector: 'app-hello-world',
  templateUrl: './hello-world.component.html',
  styleUrls: ['./hello-world.component.css']
})
export class HelloWorldComponent implements OnChanges {

  constructor() { }

  @Input() title!: string;
  @Input() text!: string;

  ngOnChanges(changes: SimpleChanges) {
    console.log('Inside ngOnchanges!!')
    console.log(changes);
  }

}
