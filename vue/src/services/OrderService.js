import axios from 'axios';

export default {

    getOrderByID(id){
        return axios.get(`/order/${id}`);
    },
    getAllOrders(){
        return axios.get('/order');
    },
    placeOrder(order){
        return axios.post('/order', order);
    },
    getOrdersByStatus(status){
        return axios.get(`/order?status=${status}`)
    },
    updateOrderStatus(id, status){
        return axios.put(`/order/${id}/status`, {status})
    }
}