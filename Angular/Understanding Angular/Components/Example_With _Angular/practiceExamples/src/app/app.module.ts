import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { HelloWorldComponent } from './hello-world/hello-world.component';
import { ParentComponentComponent } from './parent-component/parent-component.component';
import { ChildComponentComponent } from './child-component/child-component.component';
import { AdService } from 'src/services/ad.service';
import { AdBannerComponent } from './ad-banner.component';
import { AdDirective } from './ad.directive';
import { DirectiveDemo } from './directiveDemo.directive';
import { DirectiveDemoComponent } from './directive-demo/directive-demo.component';
import { HighlightDirective } from './highlightDirective.directive';

@NgModule({
  declarations: [
    AppComponent,
    HelloWorldComponent,
    ParentComponentComponent,
    ChildComponentComponent,
    AdBannerComponent,
    AdDirective,
    DirectiveDemo,
    DirectiveDemoComponent,
    HighlightDirective
  ],
  imports: [
    BrowserModule
  ],
  providers: [AdService],
  bootstrap: [AppComponent]
})
export class AppModule { }
