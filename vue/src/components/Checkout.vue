<template>
    <h1> Check Out</h1>
    <div>
        <form>
            <div class="form-element">
                <label for="name">Name: </label>
                <input type="text" id="first" v-model="customerInfo.name" />
            </div>
            <div class="form-element">
                <label for="email">Email address: </label>
                <input type="email" id="last" v-model="customerInfo.email" />
            </div>
            <div class="form-element">
                <label for="streetAddress">Street Address: </label>
                <input type="text" id="streetAddress" v-model="customerInfo.streetAddress" />
            </div>
            <div class="form-element">
                <label for="city">City: </label>
                <input type="text" id="city" v-model="customerInfo.city" />
            </div>
            <div class="form-element">
                <label for="state">State: </label>
                <input type="text" id="streetAddress" v-model="customerInfo.state" />
            </div>
            <div class="form-element">
                <label for="zip">Zip Code: </label>
                <input type="text" id="zip" v-model="customerInfo.zip" />
            </div>
            <div class="form-element">
                <label for="ccNumber">Credit Card Number: </label>
                <input type="text" id="ccNumber" v-model="customerInfo.ccNumber" />
            </div>
            <div class="form-element">
                <label for="ccExp">Expiration: </label>
                <input type="text" id="ccExp" v-model="customerInfo.ccExp" />
            </div>
            <div class="form-element">
                <label for="ccCode">CCV: </label>
                <input type="text" id="ccCode" v-model="customerInfo.ccCode" />
            </div>
            <div class="btn-div">
                <button type="submit" @click.prevent="save">Save</button>
                <button @click.prevent="cancel">Cancel</button>
            </div>
        </form>
    </div>

</template>

<script scoped>

export default {
    data() {
        return {
            customerInfo: {
                name: '',
                email: '',
                phone: '',
                streetAddress: '',
                city: '',
                state: '',
                zip: '',
                paymentType: '',
                ccNumber: '',
                ccExp: '',
                ccCode: '',
            }
        }
    }
}

</script>



<style>

</style>