<template>
    <div class="namespaces">
        <b-container>
            <b-table striped hover :items="items" />
        </b-container>
    </div>
</template>

<script>
    export default {
        name: 'Project',
        data() {
            return {
                items: [
                    { isActive: true, age: 40, first_name: 'Dickerson', last_name: 'Macdonald' },
                    { isActive: false, age: 21, first_name: 'Larsen', last_name: 'Shaw' },
                    { isActive: false, age: 89, first_name: 'Geneva', last_name: 'Wilson' },
                    { isActive: true, age: 38, first_name: 'Jami', last_name: 'Carney' }
                ]
            }
        }
    }
</script>

<style>

</style>
