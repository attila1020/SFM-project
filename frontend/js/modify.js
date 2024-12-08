const backendUrl = 'http://localhost:8080'; // Ensure this is the correct backend server URL

async function fetchFuelData() {
    try {
        const response = await fetch(`${backendUrl}/api/fetch-fuel-data`);
        if (!response.ok) {
            throw new Error(`Failed to fetch fuel data: ${response.statusText}`);
        }

        const data = await response.json();

        // Access the first element of the array
        if (data && data.length > 0) {
            const fuelData = data[0]; // Get the first object from the array

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

document.addEventListener('DOMContentLoaded', fetchFuelData);
