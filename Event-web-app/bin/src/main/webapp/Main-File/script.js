// Event Registration Button
document.querySelectorAll(".register-btn").forEach((button) => {
  button.addEventListener("click", function () {
    alert("You have registered for the event!");
  });
});

// View Events Button (Category)
document.querySelectorAll(".view-btn").forEach((button) => {
  button.addEventListener("click", function () {
    alert("You are viewing the events in this category!");
  });
});
