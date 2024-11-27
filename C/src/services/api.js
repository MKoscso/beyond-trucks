import axios from 'axios';

const api = axios.create({
  baseURL: 'http://localhost:8080/students',
  timeout: 5000,
});

api.interceptors.response.use(
  (response) => response,
  (error) => {
    alert(`Error: ${error.response?.data?.message || 'Something went wrong'}`);
    return Promise.reject(error);
  }
);

export const getStudents = () => api.get('');
export const addStudent = (student) => api.post('', student);
export const updateStudent = (id, student) => api.put(`/${id}`, student);
export const deleteStudent = (id) => api.delete(`/${id}`);
