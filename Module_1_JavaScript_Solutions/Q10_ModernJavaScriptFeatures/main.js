// Q10: Modern JavaScript Features (ES6+)
const events = [
  { name: "Music Night", category: "music", seats: 10, location: "Hall A" },
  { name: "Art Workshop", category: "art", seats: 0, location: "Room B" },
  { name: "Food Festival", category: "food", seats: 25, location: "Open Grounds" },
];

// Destructuring
events.forEach(({ name, category, seats, location }) => {
  console.log(`${name} | ${category} | ${seats} seats | ${location}`);
});

// Default parameters
function createEvent(name, category = "general", seats = 20) {
  return { name, category, seats };
}
console.log(createEvent("Dance Night"));

// Spread to clone before filtering
const cloned = [...events];
const available = cloned.filter((e) => e.seats > 0);
console.log("Available events:", available.map((e) => e.name));

// let and const
let totalSeats = 0;
available.forEach((e) => (totalSeats += e.seats));
console.log("Total available seats:", totalSeats);
