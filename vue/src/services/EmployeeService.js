import axios from 'axios';

export default {
    addPizza(pizza){
        return axios.post('/pizzas', pizza);
    }
}