import axios from 'axios';

const API_URL = 'http://localhost:8080/api';

export const apiClient = axios.create({
    baseURL: API_URL,
    headers: {
        'Content-Type': 'application/json',
    },
});

export const performSearch = (query) => apiClient.get('/search', {
    params: { query },
});
export const errorHandling = (error) => console.error("Error on request exection: ", error)