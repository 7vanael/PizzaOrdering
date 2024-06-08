import axios from 'axios';

export default {
    getToppings() {
        return axios.get('/toppings');
    },
    getCheese() {
        return axios.get('/toppings?type=Cheese');
    },
    getMeat() {
        return axios.get('/toppings?type=Meat');
    },
    getVeggie() {
        return axios.get('/toppings?type=Veggie');
    },
    getSauce() {
        return axios.get('/toppings?type=Sauce');
    },
    getCrust() {
        return axios.get('/toppings?type=Crust');
    },
    getSize() {
        return axios.get('/toppings?type=Size');
    },
    getPizzas() {
        return axios.get('/pizzas');
    },
    getCrustPriceBySize(size){
        return axios.get(`/price`, {params: {size: size}});
    }

}