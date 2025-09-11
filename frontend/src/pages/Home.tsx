// frontend/src/pages/Home.tsx
import React from 'react';
import { Link } from 'react-router-dom';
import '../styles/Dashboard.css';

const Home: React.FC = () => {
  // Mock user data for design purposes
  const mockUser = {
    username: 'John Doe',
    role: 'student'
  };

  const isLoggedIn = false; // Change to true to see logged-in state

  return (
    <div className="dashboard-container">
      <div className="hero-section">
        <h1>Welcome to EVA COHORTS GRADING SYSTEM</h1>
        <p>Manage your courses, track progress, and view grades all in one place</p>
      </div>

      {isLoggedIn ? (
        <div className="user-welcome">
          <h2>Hello, {mockUser.username}!</h2>
          <p>You are logged in as a {mockUser.role}</p>
          
          <div className="dashboard-actions">
            {mockUser.role === 'student' && (
              <Link to="/student" className="btn-primary">
                Go to Student Dashboard
              </Link>
            )}
            {mockUser.role === 'teacher' && (
              <Link to="/teacher" className="btn-primary">
                Go to Teacher Dashboard
              </Link>
            )}
          </div>
        </div>
      ) : (
        <div className="auth-prompts">
          <div className="auth-card">
            <h3>Students</h3>
            <p>Access your courses, view assignments, and check your grades</p>
            <div className="auth-actions">
              <Link to="/login" className="btn-primary">
                Student Login
              </Link>
              <Link to="/register" className="btn-secondary">
                Student Register
              </Link>
            </div>
          </div>

          <div className="auth-card">
            <h3>Teachers</h3>
            <p>Manage courses, create assignments, and grade student work</p>
            <div className="auth-actions">
              <Link to="/login" className="btn-primary">
                Teacher Login
              </Link>
              <Link to="/register" className="btn-secondary">
                Teacher Register
              </Link>
            </div>
          </div>
        </div>
      )}

      <div className="features-section">
        <h2>Features</h2>
        <div className="features-grid">
          <div className="feature-card">
            <h3>Grade Tracking</h3>
            <p>Monitor your academic progress with real-time grade updates</p>
          </div>
          <div className="feature-card">
            <h3>Course Management</h3>
            <p>Organize and access all your course materials in one place</p>
          </div>
          <div className="feature-card">
            <h3>Assignment Submission</h3>
            <p>Submit assignments and receive feedback from instructors</p>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Home;