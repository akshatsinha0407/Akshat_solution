// Q5: Objects and Prototypes
function Event(name, category, date, seats) {
  this.name = name;
  this.category = category;
  this.date = date;
  this.seats = seats;
}

Event.prototype.checkAvailability = function () {
  if (this.seats > 0) {
    console.log(`${this.name} has ${this.seats} seats available.`);
  } else {
    console.log(`${this.name} is fully booked.`);
  }
};

const e1 = new Event("Music Night", "music", "2027-06-15", 30);
const e2 = new Event("Art Workshop", "art", "2025-01-01", 0);

e1.checkAvailability();
e2.checkAvailability();

console.log("Event details:");
Object.entries(e1).forEach(([key, value]) => {
  console.log(`  ${key}: ${value}`);
});
