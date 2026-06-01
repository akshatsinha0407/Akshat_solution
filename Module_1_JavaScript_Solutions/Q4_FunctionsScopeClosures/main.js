// Q4: Functions, Scope, Closures, Higher-Order Functions
const events = [];

function addEvent(name, category, seats) {
  events.push({ name, category, seats });
  console.log(`Event added: ${name}`);
}

function registerUser(eventName) {
  const event = events.find((e) => e.name === eventName);
  if (!event || event.seats <= 0) {
    console.log("Cannot register.");
    return;
  }
  event.seats--;
  console.log(`Registered for ${eventName}. Seats left: ${event.seats}`);
}

function filterEventsByCategory(category, callback) {
  return events.filter((e) => e.category === category).filter(callback);
}

// Closure to track registrations per category
function createCategoryTracker(category) {
  let count = 0;
  return function () {
    count++;
    console.log(`Total registrations for '${category}': ${count}`);
  };
}

addEvent("Music Night", "music", 20);
addEvent("Art Workshop", "art", 15);
addEvent("Jazz Evening", "music", 5);

const trackMusic = createCategoryTracker("music");
registerUser("Music Night");
trackMusic();
registerUser("Jazz Evening");
trackMusic();

const availableMusic = filterEventsByCategory("music", (e) => e.seats > 0);
console.log("Available music events:", availableMusic.map((e) => e.name));
