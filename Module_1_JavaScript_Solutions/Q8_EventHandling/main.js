// Q8: Event Handling
const events = [
  { id: 1, name: "Music Night", category: "music", seats: 10 },
  { id: 2, name: "Art Workshop", category: "art", seats: 5 },
  { id: 3, name: "Food Festival", category: "food", seats: 20 },
];

const container = document.getElementById("events-container");

function renderEvents(list) {
  container.innerHTML = list.map(
    (e) => `<div><h3>${e.name}</h3><p>${e.category} - ${e.seats} seats</p>
    <button onclick="alert('Registered for ${e.name}!')">Register</button></div>`
  ).join("");
}

renderEvents(events);

// onchange to filter by category
document.getElementById("category-filter").onchange = function () {
  const val = this.value;
  const filtered = val === "all" ? events : events.filter((e) => e.category === val);
  renderEvents(filtered);
};

// keydown for quick search
document.getElementById("search").addEventListener("keydown", function (e) {
  if (e.key === "Enter") {
    const query = this.value.toLowerCase();
    const filtered = events.filter((ev) => ev.name.toLowerCase().includes(query));
    renderEvents(filtered);
  }
});
