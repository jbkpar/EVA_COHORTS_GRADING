// frontend/src/services/api.ts
// API service for making HTTP requests to the backend
const API_BASE_URL = import.meta.env.VITE_API_BASE_URL || 'http://localhost:8080';

export const api = {
  get: async (endpoint: string) => {
    const token = localStorage.getItem('authToken');
    const response = await fetch(`${API_BASE_URL}${endpoint}`, {
      headers: {
        'Authorization': token ? `Bearer ${token}` : '',
        'Content-Type': 'application/json',
      },
    });
    return response;
  },

  post: async (endpoint: string, data: any) => {
    const token = localStorage.getItem('authToken');
    const response = await fetch(`${API_BASE_URL}${endpoint}`, {
      method: 'POST',
      headers: {
        'Authorization': token ? `Bearer ${token}` : '',
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(data),
    });
    return response;
  },

  put: async (endpoint: string, data: any) => {
    const token = localStorage.getItem('authToken');
    const response = await fetch(`${API_BASE_URL}${endpoint}`, {
      method: 'PUT',
      headers: {
        'Authorization': token ? `Bearer ${token}` : '',
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(data),
    });
    return response;
  },

  delete: async (endpoint: string) => {
    const token = localStorage.getItem('authToken');
    const response = await fetch(`${API_BASE_URL}${endpoint}`, {
      method: 'DELETE',
      headers: {
        'Authorization': token ? `Bearer ${token}` : '',
      },
    });
    return response;
  },
};

// For design mode - mock API responses
export const mockApi = {
  get: async (endpoint: string) => {
    console.log('Mock API GET:', endpoint);
    
    // Simulate network delay
    await new Promise(resolve => setTimeout(resolve, 500));
    
    // Return mock data based on endpoint
    if (endpoint === '/api/student/dashboard') {
      return {
        ok: true,
        json: async () => ({
          courses: [
            {
              id: 1,
              name: 'Mathematics 101',
              instructor: 'Dr. Smith',
              grade: 'A-',
              assignments: [
                { id: 1, title: 'Algebra Basics', dueDate: '2024-01-15', status: 'submitted', grade: '95%' },
                { id: 2, title: 'Calculus Introduction', dueDate: '2024-02-10', status: 'pending' },
              ]
            },
            {
              id: 2,
              name: 'Computer Science Fundamentals',
              instructor: 'Prof. Johnson',
              grade: 'B+',
              assignments: [
                { id: 3, title: 'Programming Basics', dueDate: '2024-01-20', status: 'submitted', grade: '92%' },
              ]
            }
          ]
        })
      };
    }
    
    if (endpoint === '/api/teacher/dashboard') {
      return {
        ok: true,
        json: async () => ({
          courses: [
            {
              id: 1,
              name: 'Advanced Mathematics',
              code: 'MATH301',
              enrolledStudents: 24,
              assignments: [
                { id: 1, title: 'Calculus Test', dueDate: '2024-01-20', submissions: 22, graded: 18 },
                { id: 2, title: 'Linear Algebra Project', dueDate: '2024-02-15', submissions: 15, graded: 10 }
              ]
            }
          ]
        })
      };
    }
    
    return {
      ok: false,
      status: 404,
      json: async () => ({ error: 'Endpoint not found' })
    };
  },

  post: async (endpoint: string, data: any) => {
    console.log('Mock API POST:', endpoint, data);
    await new Promise(resolve => setTimeout(resolve, 500));
    
    if (endpoint === '/api/auth/login') {
      return {
        ok: true,
        json: async () => ({
          token: 'mock-jwt-token',
          user: {
            id: 1,
            username: data.email.split('@')[0],
            email: data.email,
            role: data.email.includes('teacher') ? 'teacher' : 'student'
          }
        })
      };
    }
    
    if (endpoint === '/api/auth/register') {
      return {
        ok: true,
        json: async () => ({
          token: 'mock-jwt-token',
          user: {
            id: Date.now(),
            username: data.username,
            email: data.email,
            role: data.role
          }
        })
      };
    }
    
    return {
      ok: false,
      status: 404,
      json: async () => ({ error: 'Endpoint not found' })
    };
  }
};