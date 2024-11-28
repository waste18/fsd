 const EventEmitter = require('events');
 class MyEmitter extends EventEmitter {}
 const myEmitter = new MyEmitter();
 // Event listener
 myEmitter.on('customEvent', (arg) => {
    console.log('Event triggered with argument:', arg);
 });
 // Emitting the event
 myEmitter.emit('customEvent', 'Hello, EventEmitter!');