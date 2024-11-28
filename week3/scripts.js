document.getElementById('login-form').addEventListener('submit', function(event) {
    event.preventDefault();
    const username = document.getElementById('login-username').value;
    const password = document.getElementById('login-password').value;

    if (username === 'admin' && password === 'admin') {
        alert('Correct');
    } else {
        alert('Incorrect username or password');
    }
});



