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


  students.push({name, grades});
  document.getElementById('results').textContent = 'Student added successfully.';
}

function showAverageAndDescription() {
  const totalAveragePromise = new Promise((resolve, reject) => {
    const totalAverage = students.reduce((sum, student) => sum + calculateAverage(student.grades), 0) / students.length;

    if (!isNaN(totalAverage)) {
      resolve(totalAverage);
    } else {
      reject('Error: Could not calculate total average.');
    }
  });

  totalAveragePromise.then(totalAverage => {
    let description = '';

    if (totalAverage === 6) {
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
  }).catch(error => {
    console.error('Error:', error);
  });
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

  return {name: extremumStudent.name, average: extremumAverage};
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
  return new Promise((resolve, reject) => {
    const averageA = calculateAverage(studentA.grades);
    const averageB = calculateAverage(studentB.grades);

    if (averageA === averageB) {
      resolve(0);
    } else if (averageA < averageB) {
      resolve(-1);
    } else {
      resolve(1);
    }
  });
}

function showSortedStudents() {
  const sortedStudents = students.slice().sort(compareStudentsByAverage);
  const sortedStudentNames = sortedStudents.map(student => student.name);
  document.getElementById('results').textContent = sortedStudentNames.join(', ');
}
