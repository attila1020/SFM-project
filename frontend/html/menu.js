const menuPath = 'menu.html';
fetch(menuPath)
  .then(response => {
    if (!response.ok) {
      throw new Error('Failed to load menu');
    }
    return response.text();
  })
  .then(data => {
    document.getElementById('menu-container').innerHTML = data;
  })
  .catch(error => {
    console.error('Error loading menu:', error);
  });