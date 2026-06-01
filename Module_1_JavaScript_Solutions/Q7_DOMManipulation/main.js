// Q7: DOM Manipulation
const events = [
  { id: 1, name: "Music Night", category: "music", seats: 10 },
  { id: 2, name: "Art Workshop", category: "art", seats: 5 },
  { id: 3, name: "Food Festival", category: "food", seats: 0 },
];

const container = document.querySelector("#events-container");

function renderEvents(eventList) {
  container.innerHTML = "";
  eventList.forEach((event) => {
    const card = document.createElement("div");
    card.classList.add("event-card");
    card.id = `event-${event.id}`;
    card.innerHTML = `
      <h3>${event.name}</h3>
      <p>Category: ${event.category}</p>
      <p id="seats-${event.id}">Seats: ${event.seats}</p>
      <button onclick="register(${event.id})" ${event.seats === 0 ? "disabled" : ""}>Register</button>
      <button onclick="cancel(${event.id})">Cancel</button>
    `;
    container.appendChild(card);
  });
}

function register(id) {
  const event = events.find((e) => e.id === id);
  if (event && event.seats > 0) {
    event.seats--;
    document.getElementById(`seats-${id}`).textContent = `Seats: ${event.seats}`;
    if (event.seats === 0) {
      document.querySelector(`#event-${id} button`).disabled = true;
    }
  }
}

function cancel(id) {
  const event = events.find((e) => e.id === id);
  if (event) {
    event.seats++;
    document.getElementById(`seats-${id}`).textContent = `Seats: ${event.seats}`;
    document.querySelector(`#event-${id} button`).disabled = false;
  }
}

renderEvents(events);
