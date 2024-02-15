document.getElementById('abfragen').addEventListener('click', function() {
  var childElements = document.querySelector('.child-elements');
  childElements.classList.toggle('hide');

  var arrow = document.getElementById('arrow');
  arrow.classList.toggle('rotate');
});
