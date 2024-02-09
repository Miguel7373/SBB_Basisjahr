async function onClickMeClick() {
  fetch('https://api.chucknorris.io/jokes/random')
    .then(response => {
      if (!response.ok) {
        throw new Error('Network response was not ok');
      }
      return response.json();
    })
    .then(data => {
      alert(data.value);
    })
    .catch(error => {
      console.error('There was a problem with the fetch operation:', error);
    });
}
