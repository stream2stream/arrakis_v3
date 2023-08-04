import axios from 'axios';

const BASE_URL = 'http://localhost:8080'; // Replace with your API base URL
// Replace with your actual Authorization token
const token = localStorage.getItem('jwtToken');
export const HttpService = axios.create({
  baseURL: BASE_URL,
  headers: {
    Authorization: `Bearer ${token}`
  }
});

