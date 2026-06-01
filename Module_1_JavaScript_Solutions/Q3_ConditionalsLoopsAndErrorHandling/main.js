// Q3: Conditionals, Loops, and Error Handling
const events = [
  { name: "Art Workshop", date: "2025-01-01", seats: 0 },
  { name: "Music Night", date: "2027-06-15", seats: 30 },
  { name: "Food Festival", date: "2027-07-20", seats: 10 },
];

const today = new Date();

events.forEach((event) => {
  const eventDate = new Date(event.date);
  if (eventDate < today) {
    console.log(`${event.name} is a past event. Skipping.`);
  } else if (event.seats === 0) {
    console.log(`${event.name} is full. Skipping.`);
  } else {
    console.log(`Upcoming: ${event.name} on ${event.date} - ${event.seats} seats left.`);
  }
});

function registerUser(event) {
  try {
    if (!event) throw new Error("Event not found.");
    if (event.seats <= 0) throw new Error("No seats available.");
    event.seats--;
    console.log(`Registered for ${event.name}. Seats left: ${event.seats}`);
  } catch (err) {
    console.error("Registration error:", err.message);
  }
}

registerUser(events[1]);
registerUser(events[0]);
