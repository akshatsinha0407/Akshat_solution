// Q14: jQuery and JS Frameworks

// Handle Register button click using jQuery
$('#registerBtn').click(function () {
  $('#message').text('You have registered for Music Night!').css('color', 'green');
});

// FadeIn / FadeOut toggle for event cards
let visible = true;
$('#toggleBtn').click(function () {
  if (visible) {
    $('.event-card').fadeOut(400);
    visible = false;
  } else {
    $('.event-card').fadeIn(400);
    visible = true;
  }
});

/*
  Why move to React or Vue?
  
  Benefit of React:
  - React uses a component-based architecture and Virtual DOM, making it much easier
    to build complex, scalable UIs where state changes (like registrations) automatically
    re-render only the affected parts — no manual DOM manipulation needed.
    
  Benefit of Vue:
  - Vue offers reactive two-way data binding out of the box, so form inputs and
    displayed data stay in sync automatically, reducing boilerplate code significantly.
*/
