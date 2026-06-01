// Q2: Syntax, Data Types, and Operators
const eventName = "Community Music Night";
const eventDate = "2026-06-15";
let seats = 50;

console.log(`Event: ${eventName} | Date: ${eventDate} | Seats Available: ${seats}`);

// Register one user
seats--;
console.log(`After registration, seats left: ${seats}`);

// Cancel one registration
seats++;
console.log(`After cancellation, seats left: ${seats}`);
