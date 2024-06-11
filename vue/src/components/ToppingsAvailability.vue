<template>
  <div class="row">
    <div class="col-4">
      <h3>Size Availability</h3>
      <SizeAvailability />
    </div>
    <div class="col-4">
      <h3>Crust Availability</h3>
      <CrustAvailability />
    </div>
    <div class="col-4">
      <h3>Sauce Availability</h3>
      <SauceAvailability />
    </div>
  </div>
  <div class="row">
    <div class="col-4">
      <h3>Cheese Availability</h3>
      <CheeseAvailability />
    </div>
    <div class="col-4">
      <h3>Meat Availability</h3>
      <MeatAvailability />
    </div>
    <div class="col-4">
      <h3>Veggie Availability</h3>
      <VeggieAvailability />
    </div>
  </div>
</template>


<script scoped>
// import ToppingsService from '../services/ToppingsService';
import CheeseAvailability from './CheeseAvailability.vue';
import CrustAvailability from './CrustAvailability.vue';
import MeatAvailability from './MeatAvailability.vue';
import SauceAvailability from './SauceAvailability.vue';
import SizeAvailability from './SizeAvailability.vue';
import VeggieAvailability from './VeggieAvailability.vue';

export default {
  components: {
    SizeAvailability,
    CrustAvailability,
    CheeseAvailability,
    SauceAvailability,
    MeatAvailability,
    VeggieAvailability
  }
}
</script>

<style>
.row {
  background-color: #F2DC9C;
  margin-top: 10px;
}

hr {
  border: 2px solid #A4200B;
}

h3 {
  color: #A4200B;
  font-size: 26pt;
}
</style>