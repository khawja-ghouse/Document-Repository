import { Directive, ViewContainerRef } from '@angular/core';

@Directive({
  selector: '[adHost]',
})
export class AdDirective {
  message !:string;
  constructor(public viewContainerRef: ViewContainerRef) {
    this.message = "Message from directive !!!"
  }
}
