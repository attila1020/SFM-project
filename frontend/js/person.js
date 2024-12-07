const backendUrl = 'http://localhost:8080'; // Backend URL for API requests

// Wait for the DOM to fully load
document.addEventListener('DOMContentLoaded', () => {
  const currentPage = window.location.pathname;

  if (currentPage.includes('accounts.html')) {
    console.log('Initializing Accounts Page');
    initializeAccountsPage();
  } else if (currentPage.includes('add-update_person.html')) {
    console.log('Initializing Add/Update Person Page');
    initializeAddUpdatePersonPage();
  }
});

//#region Accounts Page

// Initialize the Accounts Page
function initializeAccountsPage() {
  const loadButton = document.getElementById('loadDataButton');
  const personTable = document.getElementById('personTableBody');

  // Attach event listener to load data
  if (loadButton) {
    loadButton.addEventListener('click', () => loadPersonData(personTable));
  } else {
    console.error('Load Data button not found!');
  }
}

// Load person data and populate table
function loadPersonData(table) {
  if (!table) {
    console.error('Table body not found!');
    return;
  }

  fetch(`${backendUrl}/api/person`)
    .then(response => {
      if (!response.ok) {
        throw new Error('Failed to fetch person data');
      }
      return response.json();
    })
    .then(data => {
      table.innerHTML = data.length
        ? data.map(personToRow).join('')
        : `<tr><td colspan="6" class="text-center">No persons found.</td></tr>`;
    })
    .catch(error => console.error('Error fetching person data:', error));
}

// Convert a person object to an HTML table row
function personToRow(person) {
  return `
    <tr>
      <td>${person.id}</td>
      <td>${person.name}</td>
      <td>${person.email}</td>
      <td>${person.phoneNumber}</td>
      <td>${person.loyaltyPoints}</td>
      <td>
        <button class="btn btn-primary btn-sm" onclick="redirectToUpdate(${person.id})">Edit</button>
        <button class="btn btn-danger btn-sm" onclick="deletePerson(${person.id})">Delete</button>
      </td>
    </tr>`;
}

// Redirect to Add/Update Person page
function redirectToUpdate(id) {
  window.location.href = `add-update_person.html?id=${id}`;
}

// Delete a person by ID
function deletePerson(id) {
  if (!confirm('Are you sure you want to delete this person?')) return;

  fetch(`${backendUrl}/api/person/${id}`, { method: 'DELETE' })
    .then(response => {
      if (!response.ok) {
        throw new Error('Failed to delete person');
      }
      alert('Person deleted successfully!');
      loadPersonData(document.getElementById('personTableBody')); // Reload the table
    })
    .catch(error => {
      console.error('Error deleting person:', error);
      alert('An error occurred while deleting the person.');
    });
}

//#endregion

//#region Add/Update Person Page

// Initialize the Add/Update Person Page
function initializeAddUpdatePersonPage() {
  const form = document.getElementById('personForm');
  const heading = document.getElementById('heading1');
  const cancelButton = document.querySelector('.btn-danger');
  const queryParams = new URLSearchParams(window.location.search);
  const personId = queryParams.get('id');

  // Redirect to accounts page on Cancel
  if (cancelButton) {
    cancelButton.addEventListener('click', () => {
      window.location.href = 'accounts.html';
    });
  }

  // Handle form submission for Add/Update
  if (form) {
    form.addEventListener('submit', event => {
      event.preventDefault();
      const personData = getFormData();
      personId ? updatePerson(personId, personData) : addPerson(personData);
    });
  }

  // If personId exists, populate the form for updating
  if (personId) {
    heading.textContent = 'Update Person';
    populateFormForUpdate(personId);
  } else {
    heading.textContent = 'Add Person';
  }
}

// Fetch person details and populate the form
function populateFormForUpdate(id) {
  fetch(`${backendUrl}/api/person/${id}`)
    .then(response => {
      if (!response.ok) {
        throw new Error('Failed to fetch person details');
      }
      return response.json();
    })
    .then(person => setFormData(person))
    .catch(error => console.error('Error fetching person details:', error));
}

// Set form data for editing
function setFormData(person) {
  document.getElementById('userInput').value = person.name;
  document.getElementById('InputEmail1').value = person.email;
  document.getElementById('inputphone').value = person.phoneNumber;
  document.getElementById('inputponts').value = person.loyaltyPoints;
}

// Get form data as an object
function getFormData() {
  return {
    name: document.getElementById('userInput').value,
    email: document.getElementById('InputEmail1').value,
    phoneNumber: document.getElementById('inputphone').value,
    loyaltyPoints: document.getElementById('inputponts').value,
  };
}

// Add a new person
function addPerson(personData) {
  fetch(`${backendUrl}/api/person`, {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(personData),
  })
    .then(response => {
      if (!response.ok) {
        throw new Error('Failed to add person');
      }
      alert('Person added successfully!');
      window.location.href = 'accounts.html';
    })
    .catch(error => {
      console.error('Error adding person:', error);
      alert('An error occurred while adding the person.');
    });
}

// Update an existing person
function updatePerson(id, personData) {
  fetch(`${backendUrl}/api/person/${id}`, {
    method: 'PUT',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(personData),
  })
    .then(response => {
      if (!response.ok) {
        throw new Error('Failed to update person');
      }
      alert('Person updated successfully!');
      window.location.href = 'accounts.html';
    })
    .catch(error => {
      console.error('Error updating person:', error);
      alert('An error occurred while updating the person.');
    });
}

//#endregion
