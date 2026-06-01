// Q13: Debugging and Testing

// Simulated form data
const formData = {
  name: "Bob",
  email: "bob@example.com",
  event: "Food Festival",
};

console.log("Step 1: Form data captured", formData);

function validateForm(data) {
  if (!data.name) throw new Error("Name is missing");
  if (!data.email || !data.email.includes("@")) throw new Error("Invalid email");
  if (!data.event) throw new Error("No event selected");
  return true;
}

async function submitForm(data) {
  try {
    console.log("Step 2: Validating form...");
    validateForm(data);
    console.log("Step 3: Validation passed");

    console.log("Step 4: Sending fetch request...");
    const response = await fetch("https://jsonplaceholder.typicode.com/posts", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(data),
    });

    console.log("Step 5: Response status:", response.status);
    const result = await response.json();
    console.log("Step 6: Fetch payload sent successfully. Result ID:", result.id);
  } catch (err) {
    console.error("Debug - Error caught:", err.message);
    // Set a breakpoint here in Chrome DevTools to inspect 'err'
    debugger;
  }
}

submitForm(formData);

/* 
  Debugging Tips:
  - Open Chrome DevTools → Console tab to see console.log steps
  - Use Network tab to inspect the fetch POST request and its payload
  - Add breakpoints in Sources tab on the validateForm() or fetch lines
  - Inspect 'data' and 'response' variables at each breakpoint
*/
