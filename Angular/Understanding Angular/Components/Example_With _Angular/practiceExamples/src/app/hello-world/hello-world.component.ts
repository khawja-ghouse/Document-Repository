import { AfterContentInit, AfterViewChecked, AfterViewInit, Component, DoCheck, Input, OnChanges,  OnInit,  SimpleChanges ,ViewChild} from '@angular/core';
import { AdDirective } from '../ad.directive';
import { HeroJobAdComponent } from '../hero-job-ad.component';
import { DirectiveDemoComponent } from '../directive-demo/directive-demo.component';

@Component({
  selector: 'app-hello-world',
  templateUrl: './hello-world.component.html',
  styleUrls: ['./hello-world.component.css']
})
export class HelloWorldComponent  implements OnChanges,OnInit, DoCheck, AfterViewInit, AfterViewChecked, AfterContentInit  {

  constructor() { }

  @ViewChild(AdDirective, {static: true}) adHostDirective!: AdDirective;


  @Input() count!: number;

  ngOnChanges(changes: SimpleChanges) {
    console.log('Inside ngOnchanges!!')
    console.log(changes);
  }

  ngOnInit() {
    console.log('Inside ngOnInit!!')
    this.loadComponent();
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

  loadComponent(){
    const containerRef = this.adHostDirective.viewContainerRef;
    containerRef.clear();
    const componentRef = containerRef.createComponent(DirectiveDemoComponent);
    setTimeout(() => {
      containerRef.clear();
    }, 5000);

  }
}
