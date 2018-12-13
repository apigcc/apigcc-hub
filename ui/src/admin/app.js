import Vue from 'vue'
import App from './App.vue'
import router from './router.js'
import 'vue-awesome/icons'
import Icon from 'vue-awesome/components/Icon'
import BootstrapVue from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

Vue.use(BootstrapVue);
Vue.component('v-icon', Icon)
Vue.config.productionTip = false

new Vue({
    router,
    render: h => h(App),
}).$mount('#app');
