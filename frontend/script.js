document.addEventListener("DOMContentLoaded", function() {
    const registerButton = document.getElementById("registerButton");
    
    registerButton.addEventListener("click", function() {
        const email = document.getElementById("registerEmail").value;
        const password = document.getElementById("registerPassword").value;
        localStorage.setItem("email", email);
        localStorage.setItem("password", password);
        alert("Registration successful!");
        window.location.href = "index.html";
    });
});