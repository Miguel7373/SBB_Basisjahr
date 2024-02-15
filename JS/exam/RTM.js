document.addEventListener("DOMContentLoaded", time)
document.addEventListener("DOMContentLoaded", loadDashboardData)
document.addEventListener("DOMContentLoaded", loadChatList)
const months = ["January","February","March","April","May","June","July",
  "August","September","October","November","December"];
const weekdays = ["Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday","Sunday"];
function time(){
  let date = new Date()
  let hours  = date.getHours()
  let minutes = date.getMinutes()
  document.getElementById("timeInTopBar").innerHTML = underten(hours, minutes);
  let day = date.getDate()
  document.getElementById("day").innerHTML = day;
  let month = date.getMonth()
  document.getElementById("month").innerHTML = months[month];
  let weekday = date.getDay()
  document.getElementById("weekday").innerHTML = weekdays[weekday -1]
  let weekNumber = getWeekNumber(date);
  document.getElementById("weekNumber").innerHTML = "KW " + weekNumber;
}
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
  const weekNumber = Math.ceil((((date - yearStart) / 86400000) + 1) / 7);
  return weekNumber;
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
      document.getElementById('timerTopBar').innerHTML = data.currentWorkingHours.time.hours+":"+data.currentWorkingHours.time.minutes

      document.getElementById('SBBCrackhead').innerHTML = data.user.displayName
      const available = data.user.available;
      if (available === true){
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

        if (data.tiles[i].action !== null && data.tiles[i].action !== undefined) {

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
    .then(response => response.json())
    .then(data => {
      
    });
}
