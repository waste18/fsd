document.getElementById('register-form').addEventListener('submit', function(event) {
    event.preventDefault();
    const name = document.getElementById('name').value;
    const user = document.getElementById('register-username').value;
    const pass = document.getElementById('register-password').value;
    alert('Registration form submitted:\nName: ' + name + '\nUsername: ' + user + '\nPassword: ' + pass);
});

