<template>
    <section class="container-fluid">
        <div class="row menu">
            <div class="col-2">
                <div class="menu">
                    <div class="menu">
                        <div class="menu-items">
                            <div class="menu-item">
                                <a href="#pizzas">
                                    <h3>Pizzas</h3>
                                </a>
                            </div>
                            <div class="menu-item">
                                <router-link to="/coming_soon">
                                    <h3>Salads</h3>
                                </router-link>
                            </div>
                            <div class="menu-item">
                                <router-link to="/coming_soon">
                                    <h3>Sides</h3>
                                </router-link>
                            </div>
                            <div class="menu-item">
                                <router-link to="/coming_soon">
                                    <h3>Kid's Meal</h3>
                                </router-link>
                            </div>
                            <div class="menu-item">
                                <router-link to="/coming_soon">
                                    <h3>Beverages</h3>
                                </router-link>
                            </div>
                            <div class="menu-item">
                                <router-link to="/coming_soon">
                                    <h3>Desserts</h3>
                                </router-link>
                            </div>
                            <div class="menu-item">
                                <router-link to="/coming_soon">
                                    <h3>Deals</h3>
                                </router-link>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="col-10">

                <!-- Pizza Carousel-->
                <div id="carouselExampleCaptions" class="carousel slide">
                    <div class="carousel-indicators">
                        <button v-for="(pizza, index) in pizzas" :key="index" type="button"
                            :data-bs-target="'#carouselExampleCaptions'" :data-bs-slide-to="index"
                            :class="{ active: index === 0 }" :aria-current="index === 0 ? 'true' : undefined"
                            :aria-label="'Slide ' + (index + 1)"></button>
                    </div>

                    <div class="carousel-inner">
                        <div v-for="(pizza, index) in pizzas" :key="pizza.name" v-on:click="setActivePizza(pizza)"
                            :class="['carousel-item', { active: index === 0 }]">
                            <img :src="images[pizza.name]" class="d-block w-100" :alt="pizza.name">
                            <div class="carousel-caption d-none d-md-block">
                                <h5>{{ pizza.name }}</h5>
                                <p>{{ pizza.description }}</p>
                            </div>
                        </div>
                    </div>

                    <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions"
                        data-bs-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="visually-hidden">Previous</span>
                    </button>
                    <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions"
                        data-bs-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="visually-hidden">Next</span>
                    </button>
                </div>

                <!-- Salad Carousel-->

            </div>
        </div>



        <CustomPizzaMenu />
    </section>
</template>


<script>
import ToppingsService from '../services/ToppingsService';
// import CustomPizzaMenu from './CustomPizzaMenu.vue';

export default {
    data() {
        return {
            images:
            {
                'The Front-End': '/images/AI_margherita_pizza.webp',
                'The Default': '/images/pepperoni_pizza.jpg',
                'The Back-End': '/images/BBQ_chicken_pizza.jpg',
                'The Constructor': '/images/classic_cheese_pizza.jpg',
                'The Polymorph': '/images/custom_pizza.jpeg',
                'The Framework': '/images/Meat_Lovers.jpg',
                'The Compiler': '/images/supreme_pizza.webp',
                'The API': '/images/tomato_basil_pizza.jpeg',
                'The Debugger': '/images/veggie_pizza.webp',
                'The Full-Stack': '/images/full_stack_pizza.jpg'
            },
            pizzas: [],
        };
    },
    created() {
        ToppingsService.getPizzas().then(response => {
            this.pizzas = response.data;
        });
    },
    methods: {
        setActivePizza(pizza) {
            //console.log("reached set active pizza");
            let veggies = [];
            let meats = []; 
            let cheese;
            let stringToppingList = '';
            this.$store.commit("SET_ACTIVE_PIZZA", pizza);
            pizza.toppings.forEach(
                (topping) => {
                    if (topping.type === "Cheese") {
                        cheese = topping.name;
                    }
                    if (topping.type === "Meat") {
                        meats.push(topping.name);
                        if(stringToppingList.length != 0) stringToppingList += ',';
                        stringToppingList += ' ' + topping.name;
                    }
                    if (topping.type === "Veggie") {
                        veggies.push(topping.name);
                        if(stringToppingList.length != 0) stringToppingList += ',';
                        stringToppingList += ' ' + topping.name;
                    }
                });
            this.$store.commit("SET_ACTIVE_CHEESE", cheese);
            this.$store.commit("SET_ACTIVE_MEATS", meats);
            this.$store.commit("SET_ACTIVE_VEGGIES", veggies);
            this.$store.commit("SET_ACTIVE_TOPPING_STRING", stringToppingList);
        }
    }
};



</script>


<style scoped>
.container-fluid {
    margin-top: 20px;
    background-color: #2892C4;
    border: 2px solid #2892C4;
    border-radius: 5px;
    padding: 20px;
    min-height: 40dvh;
}

.row {
    display: flex;
    min-height: 100%;
    background-color: #2892C4;
}
.row.menu {
    display: flex;
    flex-direction: row;
    align-items: center;
}

.menu-items {
    display: flex;
    flex-direction: column;
    height: 100%;
}

.menu-item {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 70px;
    width: 100%;
    background-color: #F7C516;
    border: 2px solid #2892C4;
    border-radius: 5px;
    color: #A4200B;
    text-transform: capitalize;
}

img {
    height: 500px;
    /* width: 100%; */
    object-fit: cover;
}

.carousel-control-prev {
    width: 5%;
    height: 100%;
    background-color: #A4200B;
    border: 2px solid #A4200B;
    border-radius: 5px;
}

.carousel-control-next {
    width: 5%;
    height: 100%;
    background-color: #A4200B;
    border: 2px solid #A4200B;
    border-radius: 5px;
}

h5,
p {
    color: #F7C516;
}

.carousel-caption {
    background-color: #A4200B;
    border: 2px solid #A4200B;
    border-radius: 5px;
    opacity: .9;
}
</style>