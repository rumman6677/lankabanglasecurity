document.addEventListener("DOMContentLoaded", function() {
    const loginButton = document.getElementById("loginButton");
    const registerRedirect = document.getElementById("registerRedirect");
    const registerButton = document.getElementById("registerButton");
    
    loginButton.addEventListener("click", function() {
        const email = document.getElementById("loginEmail").value;
        const password = document.getElementById("loginPassword").value;
        const storedEmail = localStorage.getItem("email");
        const storedPassword = localStorage.getItem("password");
        
        if (email === storedEmail && password === storedPassword) {
            window.location.href = "dashboard.html";
        } else {
            alert("Invalid credentials. Please try again.");
        }
    });
    
    registerRedirect.addEventListener("click", function() {
        window.location.href = "register.html";
    });
});