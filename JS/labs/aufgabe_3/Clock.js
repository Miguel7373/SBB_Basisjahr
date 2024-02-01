function updateClock() {
  const now = new Date();
  const hours = now.getHours() % 12;
  const minutes = now.getMinutes();
  const seconds = now.getSeconds();

  const hourHand = document.getElementById('hour');
  const minuteHand = document.getElementById('minute');
  const secondHand = document.getElementById('second');

  const hourDeg = (360 / 12) * (hours + minutes / 60);
  const minuteDeg = (360 / 60) * minutes;
  const secondDeg = (360 / 60) * seconds;

  hourHand.setAttribute('transform', `rotate(${hourDeg} 400 400)`);
  minuteHand.setAttribute('transform', `rotate(${minuteDeg} 400 400)`);
  secondHand.setAttribute('transform', `rotate(${secondDeg} 400 400)`);
}

  setInterval(updateClock, 1000);
  updateClock();
