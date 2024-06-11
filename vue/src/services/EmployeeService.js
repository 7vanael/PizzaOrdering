import axios from 'axios';

export default {
    addPizza(pizza){
        return axios.post('/pizzas', pizza);
    },

    updatePizzaAvailability(pizza){
        return axios.put(`/pizzas/${pizza.id}`, pizza);
    },
    
    updateToppingAvailability(topping){
        return axios.put(`/toppings/${topping.name}`, topping);
    },

    addPizzaOption(topping){
        return axios.post('/topping', topping);
    },

    addPizzaSize(size){
        return axios.post('/size', size);
    },
    
    addPizzaCrust(crust){
        return axios.post('/crust', crust);
    }
}