const students = [];

function addStudent() {
  const name = document.getElementById('name').value;
  const grades = document.getElementById('grades').value.split(',').map(grade => parseFloat(grade.trim()));

  if (students.some(student => student.name === name)) {
    alert('Student already exists.');
    return;
  }

  if (!name || !grades.every(grade => !isNaN(grade) && grade >= 1 && grade <= 6)) {
    alert('Invalid input.');
    return;
  }


  students.push({ name, grades });
  document.getElementById('results').textContent = 'Student added successfully.';
}

function showAverageAndDescription() {
  const totalAverage = students.reduce((sum, student) => sum + student.grades.reduce((total, grade) => total + grade, 0) / student.grades.length, 0) / students.length;
  let description = '';

  if (isNaN(totalAverage)) {
    description = 'No students added yet.';
  } else if (totalAverage === 6) {
    description = 'Sehr gut';
  } else if (totalAverage >= 5) {
    description = 'Gut';
  } else if (totalAverage >= 4) {
    description = 'Befriedigend';
  } else if (totalAverage >= 3) {
    description = 'Ausreichend';
  } else {
    description = 'Mangelhaft';
  }

  document.getElementById('results').textContent = `Average: ${totalAverage.toFixed(2)}, Description: ${description}`;
}

function calculateAverage(grades) {
  return grades.reduce((sum, grade) => sum + grade, 0) / grades.length;
}

function findStudentWithExtremum(students, isMax) {
  if (students.length === 0) {
    return null;
  }

  let extremumStudent = students[0];
  let extremumAverage = calculateAverage(extremumStudent.grades);

  for (let i = 1; i < students.length; i++) {
    const currentAverage = calculateAverage(students[i].grades);
    if ((isMax && currentAverage > extremumAverage) || (!isMax && currentAverage < extremumAverage)) {
      extremumStudent = students[i];
      extremumAverage = currentAverage;
    }
  }

  return { name: extremumStudent.name, average: extremumAverage };
}

function showBestStudent() {
  const bestStudent = findStudentWithExtremum(students, true);
  if (bestStudent) {
    document.getElementById('results').textContent = `Best Student: ${bestStudent.name}, Average: ${bestStudent.average.toFixed(2)}`;
  } else {
    document.getElementById('results').textContent = 'No students added yet.';
  }
}

function showWorstStudent() {
  const worstStudent = findStudentWithExtremum(students, false);
  if (worstStudent) {
    document.getElementById('results').textContent = `Worst Student: ${worstStudent.name}, Average: ${worstStudent.average.toFixed(2)}`;
  } else {
    document.getElementById('results').textContent = 'No students added yet.';
  }
}

function compareStudentsByAverage(studentA, studentB) {
  const averageA = calculateAverage(studentA.grades);
  const averageB = calculateAverage(studentB.grades);

  if (averageA === averageB) {
    return 0;
  } else if (averageA < averageB) {
    return -1;
  } else {
    return 1;
  }
}

function showSortedStudents() {
  const sortedStudents = students.slice().sort(compareStudentsByAverage);
  const sortedStudentNames = sortedStudents.map(student => student.name);
  document.getElementById('results').textContent = sortedStudentNames.join(', ');
}
