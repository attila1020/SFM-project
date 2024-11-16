const backendUrl = 'http://localhost:8080'; 
const frontendUrl = 'http://localhost:3000'; 
const handleLogin = async (event) => {
    event.preventDefault(); 

    try {
        const username = document.getElementById('userInput').value.trim();
        const password = document.getElementById('inputPassword').value.trim();

        if (!username || !password) {
            alert('Both username and password are required.');
            return;
        }

        const response = await fetch('${urls.backend}/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
            },
            body: new URLSearchParams({ username, password }) 
        });

        if (response.ok) {
            const result = await response.json();
            if (result.accountStatus === 0) {
                window.location.href = 'dashboard.html'; // Redirect to dashboard
            } else {
                alert('Invalid credentials');
            }
        } else {
            alert('Invalid credentials');
        }
    } catch (error) {
        console.error('Error during login:', error);
        alert('An error occurred. Please try again.');
    }
};

// Attach event listener to the form
document.getElementById('loginForm').addEventListener('submit', handleLogin);