import { AfterContentInit, AfterViewChecked, AfterViewInit, Component, DoCheck, Input, OnChanges,  OnInit,  SimpleChanges } from '@angular/core';

@Component({
  selector: 'app-hello-world',
  templateUrl: './hello-world.component.html',
  styleUrls: ['./hello-world.component.css']
})
export class HelloWorldComponent  implements OnChanges,OnInit, DoCheck, AfterViewInit, AfterViewChecked, AfterContentInit  {

  constructor() { }


  @Input() count!: number;

  ngOnChanges(changes: SimpleChanges) {
    console.log('Inside ngOnchanges!!')
    console.log(changes);
  }

  ngOnInit() {
    console.log('Inside ngOnInit!!')
  }

  ngDoCheck() {
    console.log('Inside ngDoCheck!!');
  }

  // Once the view is abailable
  ngAfterViewInit(): void {
    // Mainly if we want to change the color of the button once the view is ready
    // We cant do this in ngOnit because the view is not yet ready at this stage ...
   console.log('Inside ngAfterViewInit');
  }

  // Called on any change in the view.
  ngAfterViewChecked(): void {
    console.log('Inside ngAfterViewChecked');
  }

  ngAfterContentInit(): void {
    console.log('Inside ngAfterContentInit');
  }



}
