const BASE_URL = 'http://localhost:3000';

export default {
    list() {
        return fetch(`${BASE_URL}/topics`)
        .then(response => {
            if (!response.ok) {
                throw new Error('Failed to fetch topics');
            }
            return response.json();
        });
    },
    get(id) {
        return fetch(`${BASE_URL}/topics/${id}`)
        .then(response => {
            if(!response.ok) {
                throw new Error('Failed to fetch topic');
            }
            return response.json();
        });
    }
};