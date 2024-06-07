<template>
    <div>

    </div>

</template>


<script scoped>
import ToppingsService
 from '../services/ToppingsService';
export default{
    components: {

    },
    data(){
        return {
            specialtyPizzas: [],
        }

    },
    methods: {

    },
    created() {
    // ToppingsService.getToppings().then(
    //   (response) => {
    //     // this.pizzaToppings = response.data;
    //     this.pizzaToppings.forEach(
    //     (topping) =>{
    //       if(topping.topping_type === "Meat" && topping.topping_available){ 
    //         this.meatToppings.push(topping);
    //         // console.log(topping.name);
    //       }
    //       if(topping.topping_type === "Veggie" && topping.topping_available){ 
    //         this.veggieToppings.push(topping);
    //       }
    //       if(topping.topping_type === "Cheese" && topping.topping_available){ 
    //         this.cheeseToppings.push(topping);
    //       }
    //       // console.log(topping.name);
    //     });
    //   });
    // ToppingsService.getCheese().then(
    //   (response) => {
    //     // this.cheeseToppings = response.data;
    //     let cheeseList;
    //     cheeseList = response.data;
    //     //console.log(cheeseList);
    //     cheeseList.forEach(
    //       (cheeseLoop) => {
    //         if (cheeseLoop.available /* && cheeseLoop.toppingTier == 2*/) {
    //           this.cheeseToppings.push(cheeseLoop);
    //           //console.log(cheeseLoop);
    //         }
    //       });
    //   });
    // ToppingsService.getMeat().then(
    //   (response) => {
    //     // this.meatToppings = response.data;
    //     let meatList;
    //     meatList = response.data;
    //     meatList.forEach(
    //       (toppingLoop) => {
    //         if (toppingLoop.available) {
    //           this.meatToppings.push(toppingLoop);
    //         }
    //       });
    //   });
    // ToppingsService.getSauce().then(
    //   (response) => {
    //     // this.sauces = response.data;
    //     let sauceList;
    //     sauceList = response.data;
    //     sauceList.forEach(
    //       (toppingLoop) => {
    //         if (toppingLoop.available) {
    //           this.sauces.push(toppingLoop);
    //         }
    //       });
    //   });
    // ToppingsService.getCrust().then(
    //   (response) => {
    //     // this.crustTypes = response.data;
    //     let crustList;
    //     crustList = response.data;
    //     crustList.forEach(
    //       (typesLoop) => {
    //         if (typesLoop.available) {
    //           this.crustTypes.push(typesLoop);
    //         }
    //       });
    //   });
    // ToppingsService.getVeggie().then(
    //   (response) => {
    //     // this.veggieToppings = response.data;
    //     let veggieList;
    //     veggieList = response.data;
    //     veggieList.forEach(
    //       (toppingLoop) => {
    //         if (toppingLoop.available) {
    //           this.veggieToppings.push(toppingLoop);
    //         }
    //       });
    //   });
    // ToppingsService.getSize().then(
    //   (response) => {
    //     this.crustSizes = [];
    //     let sizesList = response.data;
    //     // sizesList = response.data;
    //     sizesList.forEach(
    //       (sizeLoop) => {
    //         if (sizeLoop.available) {
    //           this.crustSizes.push(sizeLoop);
    //         }
    //       });
    //   });
    ToppingsService.getPizzas().then(
      (response) => {
        this.specialtyPizzas = response.data;
        let pizzaList = this.specialtyPizzas;
        // pizzaList.forEach(
        //   (pizzaLoop) => {
        //     if (pizzaLoop.name === "The Polymorph") {
        //       this.$store.commit("SET_ACTIVE_PIZZA", pizzaLoop);
        //       pizzaLoop.toppings.forEach(
        //         (topping) => {
        //           if (topping.type === "Cheese") { 
        //             cheese = topping;
        //           }
        //           if (topping.type === "Meat") { 
        //             meatList.push(topping.name); 
        //           }
        //           if (topping.type === "Veggie") { 
        //             veggieList.push(topping.name);
        //           }
        //         });
        //         this.$store.commit("SET_ACTIVE_CHEESE", cheese);
        //         this.$store.commit("SET_ACTIVE_MEATS", meatList);
        //         this.$store.commit("SET_ACTIVE_VEGGIES", veggieList); 
        //     }
        //   });
      });


  },


}
</script>

<style>
.container {
  background-color: #F2DC9C;
  border: 2px solid #2892C4;
  border-radius: 5px;
  padding: 20px;
}
.cheese-sauce,
.size-crust,
.toppings {
  font-weight: bold;
  text-transform: uppercase;
  color: #2892C4;
}
input[type="checkbox"] {
  width: 1em;
  height: 1em;
  accent-color: #A4200B;
}

</style>