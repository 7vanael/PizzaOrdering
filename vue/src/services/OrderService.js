import axios from 'axios';

export default {

    getOrderByID(id){
        return axios.get(`/order/${id}`);
    },
    getAllOrders(){
        return axios.get('/order');
    },
    placeOrder(order){
        return axios.post('/topics', order);
    },
}