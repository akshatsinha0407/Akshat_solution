// Q12: AJAX & Fetch API
const MOCK_API = "https://jsonplaceholder.typicode.com/posts";

function showMessage(msg, isSuccess) {
  console.log(isSuccess ? `SUCCESS: ${msg}` : `ERROR: ${msg}`);
}

// POST user registration data
async function submitRegistration(userData) {
  try {
    // Simulate delayed response
    await new Promise((resolve) => setTimeout(resolve, 1500));

    const response = await fetch(MOCK_API, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(userData),
    });

    if (!response.ok) throw new Error("Submission failed.");

    const result = await response.json();
    showMessage(`Registration submitted! ID: ${result.id}`, true);
  } catch (err) {
    showMessage(err.message, false);
  }
}

submitRegistration({ name: "Alice", email: "alice@example.com", event: "Music Night" });
