const defaultResult = 0;

let currentResult = defaultResult;

currentResult = (currentResult + 10) * 3 / 2 -1;

//let calculationDescription = ' ( ' +defaultResult + ' + 10) * 3 / 2 -1';

// Whats the use of `` --> it avoids the use of manual string concatination with variables so the above line can also be written as

let calculationDescription = `( ${defaultResult} + 10) * 3 / 2 -1`;

// using `` is called as template literal in JavaScript

outputResult(currentResult,calculationDescription);