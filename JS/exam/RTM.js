document.addEventListener("DOMContentLoaded", time)
document.addEventListener("DOMContentLoaded", loadDashboardData)
document.addEventListener("DOMContentLoaded", loadChatList)
document.addEventListener("DOMContentLoaded", surchbar)
const months = ["January","February","March","April","May","June","July",
  "August","September","October","November","December"];
const weekdays = ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"];
function time(){
  let date = new Date()
  document.getElementById("timeInTopBar").innerHTML = underten(date.getHours(), date.getMinutes());
  document.getElementById("day").innerHTML = date.getDate();
  document.getElementById("month").innerHTML = months[date.getMonth()];
  document.getElementById("weekday").innerHTML = weekdays[date.getDay()]
  document.getElementById("weekNumber").innerHTML = "KW " + getWeekNumber(date);
}

/**
 *
 * @param hours
 * @param minutes
 * @returns {string}
 */
function underten(hours, minutes){
  let newhours;
  let newMinutes;
  if (hours <= 9 && hours >= 0){
     newhours = "0" + hours;
  }else {
    newhours = hours;
  }
  if (minutes <= 9 && hours >= 0){
    newMinutes = "0" + minutes;
  }else {
    newMinutes = minutes;
  }
  const newdate = newhours+":"+newMinutes
  return newdate;
}
function getWeekNumber(date) {
  date = new Date(Date.UTC(date.getFullYear(), date.getMonth(), date.getDate()));
  date.setUTCDate(date.getUTCDate() + 4 - (date.getUTCDay() || 7));
  const yearStart = new Date(Date.UTC(date.getUTCFullYear(), 0, 1));
  return Math.ceil((((date - yearStart) / 86400000) + 1) / 7);
}
let directionArrow = true;
function leftNavAnimation(){
  const element = document.getElementById("jomama");
  element.classList.toggle("keck")
  const arrow = document.getElementById("pfeilOben")
  if (directionArrow){
    arrow.style.rotate = "180deg"
  } else {
    arrow.style.rotate = "0deg"
  }
  directionArrow = !directionArrow;
}
function loadDashboardData() {
  fetch('https://raw.githubusercontent.com/it-ninjas/labs/master/static/files/json/dashboard.json')
    .then(response => {
      if (response.ok){
        return response.json();
      }
      throw new Error('Network response was not ok.')
    })
    .then(data => {
      document.getElementById("reason").innerHTML = data.currentWorkingHours.reason;
      document.getElementById("organization").innerHTML = data.currentWorkingHours.organization;
      document.getElementById('timerTopBar').innerHTML = data.currentWorkingHours?.time.hours+":"+data.currentWorkingHours.time.minutes

      document.getElementById('SBBCrackhead').innerHTML = data.user.displayName
      if (data.user.available){
        document.getElementById('available').innerHTML = "Anwesend";
      }else {
        document.getElementById('available').innerHTML = "Abwesend";
      }
      document.getElementById('userReason').innerHTML = data.user.reason;
      document.getElementById('lastSeen').innerHTML = data.user.lastSeen;
      for (let i = 0; i <= data.tiles.length; i++) {
        const titel = data.tiles[i].title
        const amount = data.tiles[i].amount
        const pic = data.tiles[i].icon

        const dfkljs = document.querySelectorAll('.textInTopWhiteBox');
        const amounofjomama = document.querySelectorAll('.numberinwhitebox')
        const picofjomama = document.querySelectorAll('.pictureinbox')

        amounofjomama[i].textContent = amount;
        dfkljs[i].textContent = titel;
        picofjomama[i].src= "\\F3 HTML\\bilder\\" + pic;

        if (data.tiles[i].action) {

          const actionTitle = data.tiles[i].action.title;
          const actionLink = data.tiles[i].action.action;
          document.getElementById('smallTextInAbsenzen').innerHTML = actionTitle;
          document.getElementById('smallTextInAbsenzen').href = actionLink;
        }
      }
    })
}
function loadChatList() {
  fetch('https://raw.githubusercontent.com/it-ninjas/labs/master/static/files/json/chat.json')
    .then(response => {
      if (response.ok) {
        return response.json();
      }
      throw new Error('Network response was not ok.');
    })
    .then(data => {
      const availableList = document.getElementById('availableList');
      const unavailableList = document.getElementById('unavailableList');
      const addPersonWithDelay = (person, isAvailable, index) => {
        setTimeout(() => {
          const personDiv = document.createElement('div');
          personDiv.className = 'rightsidenavprofile';
          personDiv.innerHTML = `
            <img class="profileLogo" src="\\F3 HTML\\bilder\\avatar.svg">
            <div class="profileInfo">
              <span class="namesInrightsidenav">${person}</span>
              <div class="arbeitszeitInfo">
                <span class="arbeitszeitInrightsidenav">Arbeitszeit(0)</span>
              </div>
            </div>
            <img class="clocklogo" src="\\F3 HTML\\bilder\\clock.svg">
          `;
          if (isAvailable) {
            availableList.appendChild(personDiv);
          } else {
            unavailableList.appendChild(personDiv);
          }
        },  300);
      };
      data.available.forEach((person, index) => {
        addPersonWithDelay(person, true, index);
      });
      setTimeout(() => {
        data.unavailable.forEach((person, index) => {
          addPersonWithDelay(person, false, index);
        });
      }, data.available.length * 300);
    })
}
function surchbar() {
  let input = document.getElementById('wordinsurchbar').value
  input = input.toLowerCase();
  const names = document.getElementsByClassName('namesInrightsidenav');
  const proflie = document.getElementsByClassName('rightsidenavprofile');
  for (i = 0; i < names.length; i++) {
    if (!names[i].innerHTML.toLowerCase().includes(input)) {
      proflie[i].style.display= "none";
    }
    else {
      proflie[i].style.display = "";
    }
  }
}
function reload() {
  window.location.reload("Refresh");
}
