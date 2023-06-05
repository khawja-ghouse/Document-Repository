import { Directive, ElementRef } from "@angular/core";
@Directive({
  selector: '[ChangeBackGroundColor]'
})
export class DirectiveDemo {

  constructor(private elRef: ElementRef){
    this.elRef.nativeElement.style.color = '#00cc66';
    this.elRef.nativeElement.style.backgroundColor = '#ccccff';
    this.elRef.nativeElement.style.fontSize = '20px';
  }
}
