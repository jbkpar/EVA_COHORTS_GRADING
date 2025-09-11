import React from 'react';
// Make sure useAuth is exported from AuthProvider, or adjust the import path if needed
import { useAuth } from '../../context/AuthContext';
import '../../styles/Navbar.css';

const Navbar: React.FC = () => {
  const { user, logout } = useAuth();

  return (
    <nav className="navbar">
      <div className="navbar-brand">
        <h2>EVA Grading System</h2>
      </div>
      <div className="navbar-menu">
        {user ? (
          <>
            <span>Welcome, {user.username} ({user.role})</span>
            <button onClick={logout} className="logout-btn">
              Logout
            </button>
          </>
        ) : (
          <span>Please login</span>
        )}
      </div>
    </nav>
  );
};

export default Navbar;