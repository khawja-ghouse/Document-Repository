Directives are instructions in the DOM !

We are using directives without knowing that it is a directive, components are one such directive. Once we place the selector of are component somewhere in are template at this point  we are instructing Angular to add the content of are component template and business logic in are types in this place where we used the selector.

Components are directives with the template, there are also directives without the templates. 

![[Pasted image 20230805081230.png]]

For example, appTurnGreen is a custom directive. We will have a logic for turning the text to green in the class TurnGreenDirective that is configured with @Directive that tells angular to make this a directive.

We have many inbuilt directives, on such is `*ngIf` structural directive. 