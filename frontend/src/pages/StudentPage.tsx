// frontend/src/pages/StudentPage.tsx
import React, { useState } from 'react';
import '../styles/Dashboard.css';

// Mock data for design purposes
const mockCourses = [
  {
    id: 1,
    name: 'Mathematics 101',
    instructor: 'Dr. Smith',
    grade: 'A-',
    assignments: [
      { id: 1, title: 'Algebra Basics', dueDate: '2024-01-15', status: 'submitted', grade: '95%' },
      { id: 2, title: 'Calculus Introduction', dueDate: '2024-02-10', status: 'pending' },
      { id: 3, title: 'Geometry Quiz', dueDate: '2024-01-25', status: 'submitted', grade: '88%' }
    ]
  },
  {
    id: 2,
    name: 'Computer Science Fundamentals',
    instructor: 'Prof. Johnson',
    grade: 'B+',
    assignments: [
      { id: 4, title: 'Programming Basics', dueDate: '2024-01-20', status: 'submitted', grade: '92%' },
      { id: 5, title: 'Data Structures', dueDate: '2024-02-15', status: 'pending' }
    ]
  },
  {
    id: 3,
    name: 'English Literature',
    instructor: 'Dr. Williams',
    grade: 'A',
    assignments: [
      { id: 6, title: 'Shakespeare Analysis', dueDate: '2024-01-30', status: 'submitted', grade: '98%' },
      { id: 7, title: 'Modern Poetry Essay', dueDate: '2024-02-20', status: 'late' }
    ]
  }
];

const StudentPage: React.FC = () => {
  const [selectedCourse, setSelectedCourse] = useState(mockCourses[0]);

  return (
    <div className="dashboard-container">
      <div className="dashboard-header">
        <h1>Student Dashboard</h1>
        <p>Welcome back, John Doe! Here's your academic overview.</p>
      </div>

      <div className="student-content">
        <div className="courses-section">
          <h2>Your Courses</h2>
          <div className="courses-grid">
            {mockCourses.map((course) => (
              <div 
                key={course.id} 
                className={`course-card ${selectedCourse.id === course.id ? 'selected' : ''}`}
                onClick={() => setSelectedCourse(course)}
              >
                <h3>{course.name}</h3>
                <p>Instructor: {course.instructor}</p>
                <div className="grade-badge">
                  Grade: {course.grade}
                </div>
              </div>
            ))}
          </div>
        </div>

        {selectedCourse && (
          <div className="course-detail">
            <h3>{selectedCourse.name} - Assignments</h3>
            <div className="assignments-list">
              {selectedCourse.assignments.map((assignment) => (
                <div key={assignment.id} className="assignment-item">
                  <div className="assignment-info">
                    <h4>{assignment.title}</h4>
                    <p>Due: {new Date(assignment.dueDate).toLocaleDateString()}</p>
                  </div>
                  <div className="assignment-status">
                    <span className={`status-badge ${assignment.status}`}>
                      {assignment.status}
                    </span>
                    {assignment.grade && (
                      <span className="grade">Grade: {assignment.grade}</span>
                    )}
                  </div>
                </div>
              ))}
            </div>
          </div>
        )}

        <div className="quick-stats">
          <h2>Quick Stats</h2>
          <div className="stats-grid">
            <div className="stat-card">
              <h3>Enrolled Courses</h3>
              <p className="stat-number">{mockCourses.length}</p>
            </div>
            <div className="stat-card">
              <h3>Assignments Due</h3>
              <p className="stat-number">
                {mockCourses.reduce((count, course) => {
                  return count + course.assignments.filter(a => a.status === 'pending').length;
                }, 0)}
              </p>
            </div>
            <div className="stat-card">
              <h3>Average Grade</h3>
              <p className="stat-number">A-</p>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default StudentPage;