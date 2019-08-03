import Vue from 'vue'
import './plugins/axios'
import './plugins/iview.js'
import router from './router.js'
import App from './App.vue'
import LoadingButton from './components/LoadingButton.vue'

Vue.component('LoadingButton',LoadingButton);

new Vue({
    router,
    render: h => h(App),
}).$mount('#app');
