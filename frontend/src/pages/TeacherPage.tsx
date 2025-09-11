// frontend/src/pages/TeacherPage.tsx
import React, { useState } from 'react';
import '../styles/Dashboard.css';

// Mock data for design purposes
const mockTeachingCourses = [
  {
    id: 1,
    name: 'Advanced Mathematics',
    code: 'MATH301',
    enrolledStudents: 24,
    assignments: [
      { id: 1, title: 'Calculus Test', dueDate: '2024-01-20', submissions: 22, graded: 18 },
      { id: 2, title: 'Linear Algebra Project', dueDate: '2024-02-15', submissions: 15, graded: 10 }
    ]
  },
  {
    id: 2,
    name: 'Computer Science Principles',
    code: 'CSP201',
    enrolledStudents: 32,
    assignments: [
      { id: 3, title: 'Programming Assignment', dueDate: '2024-01-25', submissions: 30, graded: 28 },
      { id: 4, title: 'Algorithm Design', dueDate: '2024-02-05', submissions: 25, graded: 20 }
    ]
  },
  {
    id: 3,
    name: 'Data Structures',
    code: 'CS302',
    enrolledStudents: 28,
    assignments: [
      { id: 5, title: 'Linked Lists Implementation', dueDate: '2024-01-30', submissions: 26, graded: 26 },
      { id: 6, title: 'Tree Structures', dueDate: '2024-02-20', submissions: 10, graded: 5 }
    ]
  }
];

const TeacherPage: React.FC = () => {
  const [selectedCourse, setSelectedCourse] = useState(mockTeachingCourses[0]);

  return (
    <div className="dashboard-container">
      <div className="dashboard-header">
        <h1>Teacher Dashboard</h1>
        <p>Welcome, Professor Johnson! Manage your courses and students.</p>
      </div>

      <div className="teacher-content">
        <div className="courses-section">
          <h2>Your Teaching Courses</h2>
          <div className="courses-grid">
            {mockTeachingCourses.map((course) => (
              <div 
                key={course.id} 
                className={`course-card ${selectedCourse.id === course.id ? 'selected' : ''}`}
                onClick={() => setSelectedCourse(course)}
              >
                <h3>{course.name}</h3>
                <p>Course Code: {course.code}</p>
                <div className="enrollment-badge">
                  Students: {course.enrolledStudents}
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
                  <div className="assignment-stats">
                    <span className="stat">Submissions: {assignment.submissions}</span>
                    <span className="stat">Graded: {assignment.graded}</span>
                    <span className="stat pending">
                      Pending: {assignment.submissions - assignment.graded}
                    </span>
                  </div>
                  <button className="btn-primary">
                    Grade Assignments
                  </button>
                </div>
              ))}
            </div>
          </div>
        )}

        <div className="teacher-actions">
          <h2>Quick Actions</h2>
          <div className="action-buttons">
            <button className="btn-primary">Create New Course</button>
            <button className="btn-secondary">View All Students</button>
            <button className="btn-secondary">Generate Reports</button>
          </div>
        </div>

        <div className="quick-stats">
          <h2>Teaching Overview</h2>
          <div className="stats-grid">
            <div className="stat-card">
              <h3>Total Courses</h3>
              <p className="stat-number">{mockTeachingCourses.length}</p>
            </div>
            <div className="stat-card">
              <h3>Total Students</h3>
              <p className="stat-number">
                {mockTeachingCourses.reduce((total, course) => total + course.enrolledStudents, 0)}
              </p>
            </div>
            <div className="stat-card">
              <h3>Assignments to Grade</h3>
              <p className="stat-number">
                {mockTeachingCourses.reduce((total, course) => {
                  return total + course.assignments.reduce((assignTotal, assignment) => {
                    return assignTotal + (assignment.submissions - assignment.graded);
                  }, 0);
                }, 0)}
              </p>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default TeacherPage;