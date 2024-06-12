<template>
    <ul class="nav nav-pills" id="pills-tab" role="tablist">
        <li class="nav-item" role="presentation" v-for="(tab, index) in tabs" :key="tab.id">
            <a class="nav-link" :id="tab.id + '-tab'" data-bs-toggle="pill" :data-bs-target="'#' + tab.id" type="button"
                role="tab" :aria-controls="tab.id" :aria-selected="activeTabIndex === index"
                :class="{ active: activeTabIndex === index }" @click.prevent="setActiveTab(index)">
                {{ tab.label }}
            </a>
        </li>
    </ul>
    <!-- Tab panes -->
    <div class="tab-content" id="pills-tabContent">
        <div v-for="(tab, index) in tabs" :key="tab.id" :id="tab.id" class="tab-pane fade"
            :class="{ show: activeTabIndex === index, active: activeTabIndex === index }" role="tabpanel"
            :aria-labelledby="tab.id + '-tab'">
            <!-- Crust and Size-->
            <div v-if="tab.id === 'pills-size'" class="card">
                <form class="row">
                    <div class="col">
                        <label for="size-name">Name</label>
                        <input type="text" id="size-name" v-model="size.name">
                    </div>
                    <div class="col">
                        <label for="size-price">Price</label>
                        <input type="text" id="size-price" v-model="size.price">
                    </div>
                </form>
                <!--Button Start-->
                <div>
                    <button class="addButton" @click="addPizzaSize">Submit Size
                    </button>
                </div>



            </div>
            <!-- Sauce and Cheese-->
            <div v-else-if="tab.id === 'pills-crust'" class="card">
                <div class="tab-pane" id="pills-sauce-cheese" role="tabpanel" aria-labelledby="pills-sauce-cheese-tab">
                    <form class="row">
                        <div class="col">
                            <label for="crust-name">Name </label>
                            <input type="text" id="crust-name" v-model="crust.name">
                        </div>
                        <div class="col">
                            <label for="crust-price">Price Modifier </label>
                            <input type="text" id="crust-price" v-model="crust.price">
                        </div>
                        <div class="col">
                            <label for="crust-description">Description </label>
                            <input type="textfield" id="crust-description" v-model="crust.description">
                        </div>
                    </form>

                    <!--Button Start-->
                    <div>
                        <button class="addButton" @click="addPizzaCrust">Submit Crust</button>
                    </div>


                </div>
            </div>
            <!-- Meats-->
            <div v-else-if="tab.id === 'pills-sauce'" class="card">
                <div class="tab-pane" id="pills-meat" role="tabpanel" aria-labelledby="pills-meat-tab">

                    <form class="row">
                        <div class="col form-group">
                            <label for="sauce-name">Name</label>
                            <input type="text" id="sauce-name" v-model="sauce.name">
                        </div>
                        <div class="col form-group">
                            <label for="crust-description">Description</label>
                            <input type="text" id="sauce-description" v-model="crust.description">
                        </div>
                        <div class="form-group">
                            <label for="sauce-tier">Topping Tier</label>
                            <select id="sauce-tier" v-model="sauce.tier">
                                <option value="0">Free</option>
                                <option value="1">Standard</option>
                                <option value="2">Premium</option>
                            </select>
                        </div>
                    </form>

                    <!--Button Start-->
                    <div>
                        <button class="addButton" @click="addPizzaSauce">Submit Sauce</button>
                    </div>


                </div>
            </div>
            <div v-else class="card">
                <div class="tab-pane" id="pills-topping" role="tabpanel" aria-labelledby="pills-veggies-tab">

                </div>
                <form>
                    <div class="row">
                        <div class="col form-group">
                            <label for="topping-name">Name</label>
                            <input type="text" id="topping-name" v-model="topping.name">
                        </div>
                        <div class="col form-group">
                            <label for="topping-description">Description</label>
                            <input type="text" id="topping-description" v-model="topping.description">
                        </div>
                    </div>
                    <div class="row">
                        <div class="col form-group">
                            <label for="topping-type">Type</label>
                            <select id="topping-type" v-model="topping.type">
                                <option value="Cheese">Cheese</option>
                                <option value="Meat">Meat</option>
                                <option value="Veggie">Veggie</option>
                            </select>
                        </div>
                        <div class="col form-group">
                            <label for="topping-tier">Topping Tier</label>
                            <select id="topping-tier" v-model="topping.tier">
                                <option value="0">Free</option>
                                <option value="1">Standard</option>
                                <option value="2">Premium</option>
                            </select>
                        </div>
                    </div>
                </form>


                <!--Button Start-->
                <div>
                    <button class="addButton" @click="addPizzaOption">Submit Topping</button>
                </div>


            </div>
        </div>
    </div>
</template>

<script scoped>
import EmployeeService from '../services/EmployeeService';


export default {
    data() {
        return {
            activeTabIndex: 0,
            tabs: [
                { id: 'pills-size', label: 'Add a Size' },
                { id: 'pills-crust', label: 'Add a Crust' },
                { id: 'pills-sauce', label: 'Add a Sauce' },
                { id: 'pills-topping', label: 'Add a Topping' },
            ],
            size: {
                name: '',
                price: ''
            },
            crust: {
                name: '',
                price: '',
                description: ''
            },
            sauce: {
                name: '',
                tier: '0',
                description: ''
            },
            topping: {
                name: '',
                description: '',
                type: 'Cheese',
                tier: '0'
            }
        }
    },
    computed: {
    },
    methods: {
        addPizzaOption() {
            const newTopping = {
                name: this.topping.name,
                toppingTier: this.topping.tier,
                type: this.topping.type,
                available: true,
                description: this.topping.description
            }
            EmployeeService.addPizzaOption(newTopping).then(() => {
                this.topping.name = "";
                this.topping.tier = "0";
                this.topping.type = "Cheese";
                this.topping.description = "";
            });

        },
        addPizzaSize() {
            const newSize = {
                price: parseInt(this.size.price),
                topping: {
                    name: this.size.name,
                    type: "Size",
                    toppingTier: 0,
                    available: true,
                    description: ""
                }

            }
            EmployeeService.addPizzaSize(newSize).then(() => {
                this.size.name = "";
                this.size.price = "";
            });
        },
        addPizzaCrust() {
            const newCrust = {
                priceModifier: parseInt(this.crust.price),
                topping: {
                    name: this.crust.name,
                    type: "Crust",
                    toppingTier: 0,
                    available: true,
                    description: this.crust.description
                }

            }
            EmployeeService.addPizzaCrust(newCrust).then(() => {
                this.crust.name = "";
                this.crust.price = "";
                this.crust.description = "";
            });
        },
        addPizzaSauce() {
            const newSauce = {
                name: this.sauce.name,
                type: "Sauce",
                toppingTier: this.sauce.toppingTier,
                available: true,
                description: this.sauce.description
            }
            console.log(newSauce);
            EmployeeService.addPizzaOption(newSauce).then(() => {
                this.sauce.name = '';
                this.sauce.toppingTier = '0';
                this.sauce.description = '';
            })
        },
        setActiveTab(index) {
            this.activeTabIndex = index;
        },

    }

}


</script>


<style scoped>
h1,
h2 {
    text-align: center;
    color: #A4200B;
    margin-top: 10px;
    margin-bottom: 10px;
}

h1 {
    font-weight: bold;
}

.nav-pills {
    /* padding: 20px; */
    background-color: #2892C4;
    color: #F7C516;
    border-radius: 5px;
    margin-top: 10px;

}

.container {
    display: flex;
    flex-direction: column;
    background-color: #F2DC9C;
    border: 2px solid #2892C4;
    border-radius: 5px;
    padding-bottom: none;
}

.row {
    display: flex;
    justify-content: center;
}

label,
input {
    font-size: 16pt;
    margin: 10px;
    padding: 10px;
    font-weight: bold;
    color: #A4200B;
    letter-spacing: 3px;
}

.addButton {
    background-color: #2892C4;
    color: #F7C516;
    border: none;
    border-radius: 5px;
    padding: 10px;
    font-weight: bold;
    margin-top: 10px;
    height: 100%;
}
</style>