const backendUrl = 'http://localhost:8080'; 
const frontendUrl = 'http://localhost:3000'; 

//#region options
    const ChartBaseOptions = {
        responsive: true,
        plugins: {
            legend: {
                display: true,
                position: 'top',
                labels: {
                    color: '#ffffff', // White text
                    font: {
                        size: 14,
                        family: 'Arial',
                    },
                },
            },
            title: {
                display: true,
                text: '', // Default title text, can be overridden
                color: '#ffffff',
                font: {
                    size: 20,
                    family: 'Arial',
                    weight: 'bold',
                },
                padding: {
                    top: 10,
                    bottom: 30,
                },
            },
            tooltip: {
                backgroundColor: '#333333',
                titleColor: '#ffffff',
                bodyColor: '#ffffff',
                borderColor: '#666666',
                borderWidth: 1,
            },
        },
        layout: {
            padding: {
                top: 20,
                bottom: 20,
                left: 10,
                right: 10,
            },
        },
        scales: {
            x: {
                grid: {
                    color: '#3c3c3c',
                    lineWidth: 1,
                },
                ticks: {
                    color: '#ffffff',
                    font: {
                        size: 12,
                        weight: 'bold',
                    },
                },
            },
            y: {
                grid: {
                    color: '#3c3c3c',
                    lineWidth: 1,
                },
                ticks: {
                    color: '#ffffff',
                    font: {
                        size: 12,
                        weight: 'bold',
                    },
                },
                title: {
                    display: true,
                    text: 'Value',
                    color: '#ffffff',
                    font: {
                        size: 14,
                        weight: 'bold',
                    },
                },
            },
        },
    };
//#endregion

//#region dashboard
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
                datasets: [
                    {
                        label: 'Fuel Sales',
                        data: salesData,
                        backgroundColor: ['#ff6384', '#36a2eb', '#ffce56', '#4bc0c0', '#9966ff', '#ff9f40'],
                        borderColor: '#ffffff',
                        borderWidth: 1,
                    },
                ],
            },
            options: {
                plugins: {
                    legend: {
                        display: true,
                    },
                },
                scales: {
                    x: {
                        title: {
                            display: true,
                            text: 'Fuel Types',
                        },
                    },
                    y: {
                        max: 1000,
                        title: {
                            display: true,
                            text: 'Liters',
                        },
                    },
                },
            },
        });
    })
    .catch(error => console.error('Error fetching fuel sales data:', error));

// Fetch and display stock levels by terminal
fetch(`${backendUrl}/api/stock-levels`)
    .then(response => response.json())
    .then(data => {
        // Extract terminal names and stock levels
        const terminals = data.map(item => item.terminal); // ["Terminal 1", "Terminal 2"]
        const stockLevels = data.map(item => item.stock); // [1500, 1200]

        // Get canvas context for Chart.js
        const ctx2 = document.getElementById('stockLevelsChart').getContext('2d');

        // Create a bar chart
        new Chart(ctx2, {
            type: 'bar',
            data: {
                labels: terminals, // Terminal names for x-axis
                datasets: [{
                    label: 'Stock Levels by Terminal', // Chart legend
                    data: stockLevels, // Stock data for y-axis
                    backgroundColor: terminals.map(() => `#${Math.floor(Math.random() * 16777215).toString(16)}`), // Random colors
                    borderWidth: 1 // Border thickness for bars
                }]
            },
            options: {
                responsive: true, // Responsive chart
                plugins: {
                    legend: {
                        display: true, // Show legend
                        position: 'top' // Legend position
                    }
                },
                scales: {
                    y: {
                        beginAtZero: true, // Start y-axis at 0
                        title: {
                            display: true,
                            text: 'Stock Levels' // y-axis title
                        }
                    },
                    x: {
                        title: {
                            display: true,
                            text: 'Terminals' // x-axis title
                        }
                    }
                }
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
fetch(`${backendUrl}/api/boxed`)
    .then(response => response.json())
    .then(data => {
        // Extract names and inventory data from the API response
        const items = data.map(item => item.name); // ["Coolant", "Wiper Fluid"]
        const inventoryData = data.map(item => item.inventory); // [80, 100]

        // Generate random colors for each item
        const randomColors = items.map(() => {
            const randomColor = `#${Math.floor(Math.random()*16777215).toString(16)}`;
            return randomColor;
        });

        // Create a bar chart using Chart.js
        const ctx4 = document.getElementById('boxedItemsInventoryChart').getContext('2d');
        new Chart(ctx4, {
            type: 'bar',
            data: {
                labels: items, // Labels for the chart
                datasets: [{
                    label: 'Boxed Items Inventory', // Legend label
                    data: inventoryData, // Inventory data
                    backgroundColor: randomColors // Random colors for each bar
                }]
            },
            options: {
                responsive: true,
                scales: {
                    y: {
                        beginAtZero: true // Ensure y-axis starts at 0
                    }
                }
            }
        });
    })
    .catch(error => console.error('Error fetching boxed items inventory data:', error));



// Fetch and display average purchase size
fetch(`${backendUrl}/api/averages`)
    .then(response => response.json())
    .then(data => {
        // Compute average purchase sizes
        const purchaseSizes = data.map(item => 
            (item.gasoline + item.diesel + item.windowCleaner + item.engineOil + item.coolant + item.antiFreeze)/6
        );

        const ctx5 = document.getElementById('avgPurchaseSizeChart').getContext('2d');
        new Chart(ctx5, {
            type: 'bar',
            data: {
                labels: purchaseSizes.map((_, index) => `Average ${index + 1}`),
                datasets: [{
                    label: 'Average Purchase Size (Liters)',
                    data: purchaseSizes,
                    backgroundColor: '#ff6384'
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


//#endregion
//#region Login page

// document.getElementById('loginForm').addEventListener('submit', async function(event) {
//     event.preventDefault();
    
//     const username = document.getElementById('userInput').value;
//     const password = document.getElementById('inputPassword').value;

//     const response = await fetch('/login', {
//         method: 'POST',
//         headers: {
//             'Content-Type': 'application/json'
//         }, 
//         body: JSON.stringify({ username, password })
//     });

//     const result = await response.json();
//     if (result.accountStatus === 'ok') {
//         window.location.href = 'dashboard.html';
//     } else {
//         alert('Invalid credentials');
//     }
// });
//#endregion

//#region query
document.getElementById('sqlForm').addEventListener('submit', async function (event) {
    event.preventDefault();
    const query = document.getElementById('sqlQuery').value;

    //  const response = await fetch('/execute-sql', {
    //      method: 'POST',
    //      headers: {
    //         'Content-Type': 'application/json',
    //     },
    //      body: JSON.stringify({ query }),
    //  });
    const response = await fetch('rsc/mockjson.json');
    const result = await response.json();
    const resultDiv = document.getElementById('result');

    if (result.error) {
        resultDiv.innerHTML = `<div class="alert alert-danger">${result.error}</div>`;
    } else {
        
        resultDiv.innerHTML = '';

       
        const wrapper = document.createElement('div');
        wrapper.classList.add('query-result-table-wrapper');

        
        const table = document.createElement('table');
        table.classList.add('query-result-table'); 

        
        const headers = result.data[0];
        const thead = table.createTHead();
        const headerRow = thead.insertRow();
        headers.forEach(header => {
            const th = document.createElement('th');
            th.textContent = header;
            headerRow.appendChild(th);
        });

       
        const tbody = table.createTBody();
        result.data.slice(1).forEach(rowData => {
            const row = tbody.insertRow();
            rowData.forEach(cellData => {
                const cell = row.insertCell();
                cell.textContent = cellData;
            });
        });

        wrapper.appendChild(table);

        resultDiv.appendChild(wrapper);
    }
});

