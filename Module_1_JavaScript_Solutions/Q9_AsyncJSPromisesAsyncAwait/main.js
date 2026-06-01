// Q9: Async JS, Promises, Async/Await

// Mock API URL (use a real JSON server or JSONPlaceholder in practice)
const MOCK_API = "https://jsonplaceholder.typicode.com/posts?_limit=5";

// Using .then() and .catch()
function fetchEventsWithPromise() {
  console.log("Fetching events with Promise...");
  fetch(MOCK_API)
    .then((res) => {
      if (!res.ok) throw new Error("Network response was not ok");
      return res.json();
    })
    .then((data) => console.log("Events (Promise):", data))
    .catch((err) => console.error("Error:", err.message));
}

// Using async/await
async function fetchEventsAsync() {
  console.log("Fetching events with async/await...");
  console.log("Loading..."); // spinner simulation
  try {
    const res = await fetch(MOCK_API);
    if (!res.ok) throw new Error("Network response was not ok");
    const data = await res.json();
    console.log("Events (Async/Await):", data);
  } catch (err) {
    console.error("Error:", err.message);
  } finally {
    console.log("Loading complete.");
  }
}

fetchEventsWithPromise();
fetchEventsAsync();
