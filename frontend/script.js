const backendUrl = 'http://localhost:8080'; 
const frontendUrl = 'http://localhost:3000'; 
// Fetch and display fuel sales by type
fetch(`${backendUrl}/api/fuel-sales`)
    .then(response => response.json())
    .then(data => {
        const fuelTypes = data.map(item => item.fuelType);
        const salesData = data.map(item => item.sales);

        const ctx1 = document.getElementById('salesByFuelChart').getContext('2d');
        new Chart(ctx1, {
            type: 'bar',
            data: {
                labels: fuelTypes,
                datasets: [{
                    label: 'Sales by Fuel Type',
                    data: salesData,
                    backgroundColor: ['#ff6384', '#36a2eb', '#cc65fe', '#ffce56', '#4bc0c0']
                }]
            }
        });
    })
    .catch(error => console.error('Error fetching fuel sales data:', error));

// Fetch and display stock levels by terminal
fetch(`${backendUrl}/api/stock-levels`)
    .then(response => response.json())
    .then(data => {
        const terminals = data.map(item => item.terminal);
        const stockLevels = data.map(item => item.stock);

        const ctx2 = document.getElementById('stockLevelsChart').getContext('2d');
        new Chart(ctx2, {
            type: 'line',
            data: {
                labels: terminals,
                datasets: [{
                    label: 'Stock Levels by Terminal',
                    data: stockLevels,
                    borderColor: '#36a2eb',
                    fill: false
                }]
            }
        });
    })
    .catch(error => console.error('Error fetching stock levels data:', error));

// Fetch and display top-selling products
fetch(`${backendUrl}/api/top-selling-products`)
    .then(response => response.json())
    .then(data => {
        const products = data.map(item => item.product);
        const salesData = data.map(item => item.sales);

        const ctx3 = document.getElementById('topSellingProductsChart').getContext('2d');
        new Chart(ctx3, {
            type: 'pie',
            data: {
                labels: products,
                datasets: [{
                    label: 'Top Selling Products',
                    data: salesData,
                    backgroundColor: ['#ff6384', '#36a2eb', '#ffce56', '#4bc0c0', '#cc65fe']
                }]
            }
        });
    })
    .catch(error => console.error('Error fetching top-selling products:', error));

// Fetch and display boxed items inventory
fetch(`${backendUrl}/api/boxed-items-inventory`)
    .then(response => response.json())
    .then(data => {
        const items = data.map(item => item.name);
        const inventoryData = data.map(item => item.inventory);

        const ctx4 = document.getElementById('boxedItemsInventoryChart').getContext('2d');
        new Chart(ctx4, {
            type: 'bar',
            data: {
                labels: items,
                datasets: [{
                    label: 'Boxed Items Inventory',
                    data: inventoryData,
                    backgroundColor: ['#ff6384', '#36a2eb', '#ffce56', '#4bc0c0']
                }]
            }
        });
    })
    .catch(error => console.error('Error fetching boxed items inventory data:', error));

// Fetch and display average purchase size
fetch(`${backendUrl}/api/average-purchase-size`)
    .then(response => response.json())
    .then(data => {
        const purchaseSizes = data.map(item => item.purchaseSize);

        const ctx5 = document.getElementById('avgPurchaseSizeChart').getContext('2d');
        new Chart(ctx5, {
            type: 'bar',
            data: {
                labels: ['Average Purchase Size'],
                datasets: [{
                    label: 'Average Purchase Size (Liters)',
                    data: [purchaseSizes],
                    backgroundColor: ['#ff6384']
                }]
            }
        });
    })
    .catch(error => console.error('Error fetching average purchase size data:', error));

// Fetch and display sales by time of day
fetch(`${backendUrl}/api/sales-by-hour`)
    .then(response => response.json())
    .then(data => {
        const hours = data.map(item => item.hour);
        const salesData = data.map(item => item.sales);

        const ctx6 = document.getElementById('salesByTimeChart').getContext('2d');
        new Chart(ctx6, {
            type: 'bar',
            data: {
                labels: hours,
                datasets: [{
                    label: 'Sales by Time of Day',
                    data: salesData,
                    backgroundColor: ['#36a2eb']
                }]
            }
        });
    })
    .catch(error => console.error('Error fetching sales by time of day data:', error));

// Fetch and display low stock alerts
fetch(`${backendUrl}/api/low-stock`)
    .then(response => response.json())
    .then(data => {
        const lowStockAlertList = document.getElementById('lowStockAlert');
        data.forEach(item => {
            const listItem = document.createElement('li');
            listItem.textContent = `${item.product}: ${item.stock} units remaining`;
            lowStockAlertList.appendChild(listItem);
        });
    })
    .catch(error => console.error('Error fetching low stock alerts:', error));

// Fetch and display loyalty program performance
fetch(`${backendUrl}/api/loyalty-performance`)
    .then(response => response.json)



//Login page

document.getElementById('loginForm').addEventListener('submit', async function(event) {
    event.preventDefault();
    
    const username = document.getElementById('userInput').value;
    const password = document.getElementById('inputPassword').value;

    const response = await fetch('/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        }, 
        body: JSON.stringify({ username, password })
    });

    const result = await response.json();
    if (result.accountStatus === 'ok') {
        window.location.href = 'dashboard.html';
    } else {
        alert('Invalid credentials');
    }
});


//query
document.getElementById('sqlForm').addEventListener('submit', async function(event) {
    event.preventDefault();
    const query = document.getElementById('sqlQuery').value;

    const response = await fetch('/execute-sql', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ query })
    });

    const result = await response.json();
    if (result.error) {
        document.getElementById('result').innerHTML = `<div class="alert alert-danger">${result.error}</div>`;
    } else {
        document.getElementById('result').innerHTML = `<pre>${JSON.stringify(result.data, null, 2)}</pre>`;
    }
});

//modify

async function fetchFuelData() {
try {
    const response = await fetch('/fetch-fuel-data');
    const data = await response.json();

    // Update the form fields with the fetched data
    document.getElementById('gasolineAmount').value = data.gasolineAmount;
    document.getElementById('gasolinePrice').value = data.gasolinePrice;
    document.getElementById('dieselAmount').value = data.dieselAmount;
    document.getElementById('dieselPrice').value = data.dieselPrice;

} catch (error) {
    document.getElementById('result').innerHTML = `<div class="alert alert-danger">Failed to fetch fuel data.</div>`;
}
}

// Fetch fuel data when the page loads
document.addEventListener('DOMContentLoaded', fetchFuelData);

document.getElementById('modifyFuelForm').addEventListener('submit', async function(event) {
event.preventDefault();

// Get the values for gasoline and diesel
const gasolineAmount = document.getElementById('gasolineAmount').value;
const gasolinePrice = document.getElementById('gasolinePrice').value;
const dieselAmount = document.getElementById('dieselAmount').value;
const dieselPrice = document.getElementById('dieselPrice').value;

// Send data to the server
const response = await fetch('/modify-fuel', {
    method: 'POST',
    headers: {
        'Content-Type': 'application/json'
    },
    body: JSON.stringify({
        gasolineAmount,
        gasolinePrice,
        dieselAmount,
        dieselPrice
    })
});

const result = await response.json();
if (result.success) {
    document.getElementById('result').innerHTML = `<div class="alert alert-success">Fuel data updated successfully!</div>`;
} else {
    document.getElementById('result').innerHTML = `<div class="alert alert-danger">${result.error}</div>`;
}
});