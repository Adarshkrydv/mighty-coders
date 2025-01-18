<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Login & Signup | Event Manager</title>
    <link
      href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600&display=swap"
      rel="stylesheet"
    />
    <link rel="stylesheet" href="login_signup.css" />
  </head>
  <body>
    <header class="navbar">
      <div class="logo">EventManager</div>
      <nav>
        <ul>
          <li><a href="../Main-File/index.html">Home</a></li>
          <li><a href="#">Events</a></li>
          <li><a href="#">Categories</a></li>
          <li><a href="#">About Us</a></li>
          <li><a href="#">Contact</a></li>
        </ul>
      </nav>
    </header>

    <section class="auth-container">
      <div class="auth-box">
        <div class="tab-buttons">
          <button class="active" id="login-tab">Login</button>
          <button id="signup-tab">Signup</button>
        </div>

        <!-- Login Form -->
        <form id="login-form" class="auth-form">
          <h2>Login</h2>
          <input type="email" id="login-email" placeholder="Email" required />
          <input
            type="password"
            id="login-password"
            placeholder="Password"
            required
          />
          <button type="submit" class="submit-btn">Login</button>
          <p>Don't have an account? <a href="#" id="to-signup">Sign Up</a></p>
        </form>

        <!-- Signup Form -->
        <form id="signup-form" class="auth-form" style="display: none">
          <h2>Signup</h2>
          <input
            type="text"
            id="signup-name"
            placeholder="Full Name"
            required
          />
          <input type="email" id="signup-email" placeholder="Email" required />
          <input
            type="password"
            id="signup-password"
            placeholder="Password"
            required
          />
          <input
            type="password"
            id="confirm-password"
            placeholder="Confirm Password"
            required
          />
          <button type="submit" class="submit-btn">Signup</button>
          <p>Already have an account? <a href="#" id="to-login">Login</a></p>
        </form>
      </div>
    </section>

    <div id="error-message" class="error-message">
      <p id="error-text"></p>
    </div>

    <script src="login_signup.js"></script>
  </body>
</html>
