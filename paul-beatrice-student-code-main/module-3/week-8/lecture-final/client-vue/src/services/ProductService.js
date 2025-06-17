import axios from 'axios';

const productService = {
    getAllProducts() {
        
      return axios.get('/products');
    },
  
    getProductById(id) {
      return axios.get(`/products/${id}`);
    },
  
    createProduct(product) {
      return axios.post('/products', product);
    },
  
    updateProduct(id, product) {
      return axios.put(`/products/${id}`, product);
    },
  
    deleteProduct(id) {
      return axios.delete(`/products/${id}`);
    },
  };
  
  export default productService;