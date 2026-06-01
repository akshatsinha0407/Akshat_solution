// Q6: Arrays and Methods
let events = [
  { name: "Jazz Evening", category: "music", seats: 20 },
  { name: "Pottery Class", category: "workshop", seats: 10 },
  { name: "Rock Concert", category: "music", seats: 50 },
  { name: "Baking Workshop", category: "workshop", seats: 15 },
];

// Add new event
events.push({ name: "Classical Night", category: "music", seats: 25 });
console.log("After push:", events.map((e) => e.name));

// Filter music events
const musicEvents = events.filter((e) => e.category === "music");
console.log("Music events:", musicEvents.map((e) => e.name));

// Map to display cards
const displayCards = events.map((e) => `${e.category.charAt(0).toUpperCase() + e.category.slice(1)} on ${e.name}`);
console.log("Display cards:", displayCards);
