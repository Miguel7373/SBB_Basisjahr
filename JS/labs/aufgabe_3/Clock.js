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


document.addEventListener("DOMContentLoaded",function () {
  for (let i = 0; i < 12; i++) {
    const angle = i * 30;
    const line = document.createElementNS('http://www.w3.org/2000/svg', 'line');
    line.setAttribute('stroke', 'rgb(52, 115, 96)');
    line.setAttribute('stroke-width', '8');
    line.setAttribute('x1', 400 + 250 * Math.sin(angle * (Math.PI / 180)));
    line.setAttribute('y1', 400 - 250 * Math.cos(angle *(Math.PI / 180)));
    line.setAttribute('x2', 400 + 290 * Math.sin(angle * (Math.PI / 180)));
    line.setAttribute('y2',  400 - 290 * Math.cos(angle* (Math.PI / 180)));
    document.getElementById("levin").appendChild(line)
  }
})

setInterval(updateClock, 1000);
