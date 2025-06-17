<template>
  <div>
    <!-- New Product Form -->
    <form id="productForm" v-on:submit.prevent="addProduct">      
      <div class="flex-container">        
        <input class="flex-item"
          type="text"
          v-model="newProduct.name"
          id="name"
          placeholder="Product Name"
          required
          autocomplete="off"
        />     
       
        <textarea class="flex-item"
          v-model="newProduct.description"
          id="description"
          placeholder="Product Description"
        ></textarea>
       <input type="submit" value="Add Product" class="flex-item btn btn-primary btn-sm" />
     
       </div>
    </form>

    <!-- Product List Table -->
    <table>
      <thead>
        <tr>
          <th>ID</th>
          <th>Name</th>
          <th># Reviews</th>
          <th>Actions</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="product in products" v-bind:key="product.id">
          <td>{{ product.id }}</td>
          <td>
            <div v-if="product.isEditing" class="flex-container">
              <input v-model="product.name" placeholder="Product Name" class="flex-item" />
              
              <textarea
                v-model="product.description"
                placeholder="Description"
                class="flex-item"
              ></textarea>
            </div>
            <div v-else>
              <router-link
                v-bind:to="{ name: 'product-detail', params: { id: product.id } }"
              >
                {{ product.name }}
              </router-link>
            </div>
          </td>
          <td>{{ product.reviews.length }}</td>
          <td>
            <button
              v-if="!product.isEditing"
              v-on:click="enableEdit(product)"
              title="Edit"
            >
              <i class="fas fa-edit"></i>
              Edit
            </button>
            <button v-if="product.isEditing" v-on:click="saveEdit(product)">
              Save
            </button>
            <button v-if="product.isEditing" v-on:click="cancelEdit(product)">
              Cancel
            </button>
            <button v-on:click="deleteProduct(product)" title="Delete">
              <i class="fas fa-trash"></i>
              Delete
            </button>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
    import productService from '../services/ProductService';
   

    export default {
      name: 'ProductsList',
      data() {
        return {       
          productList: [],                      
          newProduct: {
            name: '',
            description: '',
          },
        };
      },
      
      computed:{       
       products(){
         return this.$store.state.products;
       }
      },
      methods: {
        addProduct() {
          const product = {
            name: this.newProduct.name,
            description: this.newProduct.description,
            reviews: [],
            isEditing: false,
          };
          //TODO 2: Use service to create new product.
          productService.createProduct(product)
            .then(response => {
              if (response.status === 200 || response.status === 201) {
                // Get products and set products
                this.getProducts();
                // Reset form fields
                this.resetForm();
              }
            })
            .catch(error => {
             if (error.response) {
                  console.error(`Error adding new product. Response received was "${error.response.statusText}".`, error);
              } else if (error.request) {                
                  console.error('Error adding new product. Server could not be reached.', error);
              } else {
                  console.error('Error adding new product. Request could not be created.', error);
              }
            }
            
            );
        },
        enableEdit(product) {
          // Save original values to allow canceling the edit
          product.originalName = product.name;
          product.originalDescription = product.description;
          product.isEditing = true;
        },
        saveEdit(product) {
          productService.updateProduct(product.id, product)
            .then(response => {
              if (response.status === 200 || response.status === 201) {
                // Get products and set products
                this.getProducts();
              }
            })
            .catch(error => {
              if (error.response) {
                  console.error(`Error updating product. Response received was "${error.response.statusText}".`, error);
              } else if (error.request) {                
                  console.error('Error updating product. Server could not be reached.', error);
              } else {
                  console.error('Error updating product. Request could not be created.', error);
              }
            })
            .finally(() => {
              product.isEditing = false;
              delete product.originalName;
              delete product.originalDescription;
            });
        },

        cancelEdit(product) {
          // Revert to original values and exit edit mode
          product.name = product.originalName;
          product.description = product.originalDescription;
          product.isEditing = false;
          delete product.originalName;
          delete product.originalDescription;
        },

        deleteProduct(product) {
          if (confirm(`Are you sure you want to delete product: ${product.name}?`)) {
            productService.deleteProduct(product.id)
              .then(response => {
                if (response.status === 200 || response.status === 201 || response.status === 204) {
                  // Get products and set products                 
                  this.getProducts();
                }
              })
              .catch(error => {
                if (error.response) {
                  console.error(`Error deleting product. Response received was "${error.response.statusText}".`, error);
              } else if (error.request) {                
                  console.error('Error deleting product. Server could not be reached.', error);
              } else {
                  console.error('Error deleting product. Request could not be created.', error);
              }
              });
          }
        },

        getProducts() {
          
          productService.getAllProducts()
            .then(response => {
              this.productList = response.data;
              this.setProducts(this.productList);
            })
            .catch(error => {
               if (error.response) {
                  console.error(`Error getting products. Response received was "${error.response.statusText}".`, error);
              } else if (error.request) {                
                  console.error('Error getting products. Server could not be reached.', error);
              } else {
                  console.error('Error getting products. Request could not be created.', error);
              }
            });
        },
        setProducts(products) {
          this.$store.commit('SET_PRODUCTS', products);
        },
        resetForm() {
          this.newProduct.name = '';
          this.newProduct.description = '';
        },
      },
    };
</script>


<style scoped>
    table {
      margin: auto;
    }

    th,
    td {
      text-align: left;
      padding: 10px;
      vertical-align: top;
    }

    tr:nth-child(even) {
      background-color: rgb(238, 238, 238);
    }

    button {
      background: none;
      border: none;
      cursor: pointer;
      padding: 5px;
    }

    button:hover {
      opacity: 0.7;
    }

    form {
      margin-bottom: 20px;
    }

    form div {
      margin-bottom: 10px;
    }

    form label {
      margin-right: 10px;
    }
    input{
      margin-right: 5px;
    }
    textarea{
      margin-right: 5px;
      resize:none;
      height: 40px;
    }
    textarea.placeholder{
      text-align: left;
      vertical-align: middle;
      
    }

    .flex-container{
      display: flex;
      align-content: flex-start;
      
    }
    .flex-item {
       /* Sets flex-grow, flex-shrink, and flex-basis */ 
      flex: 1 1 1;               
      text-align: center;
    }

</style>
