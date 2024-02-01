async function onClickMeClick() {
  const response = await fetch('https://api.chucknorris.io/jokes/random');
  const data = await response.json();
  alert(data.value);
}
