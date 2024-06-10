import axios from 'axios';

export default {
    addPizza(pizza){
        return axios.post('/pizzas', pizza);
    },

    updatePizzaAvailability(pizza){
        return axios.put(`/pizzas/${pizza.id}`, pizza);
    }
}