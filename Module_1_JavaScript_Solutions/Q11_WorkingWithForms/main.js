// Q11: Working with Forms
document.getElementById("registration-form").addEventListener("submit", function (e) {
  e.preventDefault();

  const name = this.elements["name"].value.trim();
  const email = this.elements["email"].value.trim();
  const event = this.elements["event"].value;

  document.getElementById("name-error").textContent = "";
  document.getElementById("email-error").textContent = "";
  document.getElementById("event-error").textContent = "";

  let valid = true;

  if (!name) {
    document.getElementById("name-error").textContent = "Name is required.";
    valid = false;
  }
  if (!email || !email.includes("@")) {
    document.getElementById("email-error").textContent = "Valid email is required.";
    valid = false;
  }
  if (!event) {
    document.getElementById("event-error").textContent = "Please select an event.";
    valid = false;
  }

  if (valid) {
    document.getElementById("success-msg").textContent =
      `Thank you, ${name}! You are registered for "${event}".`;
    this.reset();
  }
});
