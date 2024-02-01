
async function onClickMeClick() {
  try {
    const response = await fetch('https://dog.ceo/api/breeds/image/random');
    const data = await response.json();

    const dogImageContainer = document.getElementById('dogImageContainer');
    const imgElement = document.createElement('img');
    imgElement.src = data.message;
    imgElement.alt = 'Random Dog Image';

    // Clear previous images
    while (dogImageContainer.firstChild) {
      dogImageContainer.removeChild(dogImageContainer.firstChild);
    }

    dogImageContainer.appendChild(imgElement);
  } catch (error) {
    console.error('Error fetching dog image:', error);
  }
}
