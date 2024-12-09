const backendUrl = 'http://localhost:8080'; // Backend server URL

// Fetch initial fuel data and populate the form
async function fetchFuelData() {
    try {
        const response = await fetch(`${backendUrl}/api/fetch-fuel-data`);
        if (!response.ok) {
            throw new Error(`Failed to fetch fuel data: ${response.statusText}`);
        }

        const data = await response.json();

        // Access the last element of the array (if needed)
        if (data && data.length > 0) {
            const fuelData = data[data.length - 1]; // Get the last object in the array

            // Populate the form fields
            document.getElementById('gasolineAmount').value = fuelData.gasolineAmount || '';
            document.getElementById('gasolinePrice').value = fuelData.gasolinePrice || '';
            document.getElementById('dieselAmount').value = fuelData.dieselAmount || '';
            document.getElementById('dieselPrice').value = fuelData.dieselPrice || '';
        } else {
            console.error('No data received from API');
            document.getElementById('result').innerHTML = `<div class="alert alert-warning">No data available.</div>`;
        }
    } catch (error) {
        document.getElementById('result').innerHTML = `<div class="alert alert-danger">Failed to fetch fuel data. Please try again later.</div>`;
        console.error('Error fetching fuel data:', error);
    }
}

// Post updated fuel data to the server
async function postFuelData(event) {
    event.preventDefault(); // Prevent default form submission behavior

    // Get the values from the form fields
    const gasolineAmount = document.getElementById('gasolineAmount').value;
    const gasolinePrice = document.getElementById('gasolinePrice').value;
    const dieselAmount = document.getElementById('dieselAmount').value;
    const dieselPrice = document.getElementById('dieselPrice').value;
    const id = 3;

    // Prepare the payload with a fixed ID of 1
    const payload = {
        id: parseInt(id), // Fixed ID
        gasolineAmount: parseFloat(gasolineAmount),
        gasolinePrice: parseFloat(gasolinePrice),
        dieselAmount: parseFloat(dieselAmount),
        dieselPrice: parseFloat(dieselPrice),
    };

    console.log(JSON.stringify(payload))

    try {
        const response = await fetch(`${backendUrl}/api/modify-fuel`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(payload), // Send the JSON payload
        });


       
    } catch (error) {
        document.getElementById('result').innerHTML = `<div class="alert alert-danger">Error updating fuel data. Please try again later.</div>`;
        console.error('Error posting fuel data:', error);
    }
}

// Event listeners
document.addEventListener('DOMContentLoaded', fetchFuelData); // Fetch data on page load
document.getElementById('modifyFuelForm').addEventListener('submit', postFuelData); // Handle form submission
