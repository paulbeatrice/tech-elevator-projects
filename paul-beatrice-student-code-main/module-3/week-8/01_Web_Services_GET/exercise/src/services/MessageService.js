const BASE_URL = 'http://localhost:3000';

export default {
    get(id) {
        return fetch(`${BASE_URL}/messages/${id}`)
        .then(response => {
            if (!response.ok) {
                throw new Error('Failed to fetch message');
            }
            return response.json();
        });
    }
};