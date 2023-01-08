<template>
  <div class="row row-cols-1 row-cols-md-4 g-4">
    <div class="col" v-for="task in task" :key="task.id">
      <div class="card h-100">
        <div class="card-body">
          <h5 class="card-title">{{ task.title }}</h5>
          <p class="card-text">{{ task.description }}</p>
        </div>
      </div>
    </div>
  </div>
</template>
<script>

export default {
  name: 'TaskCard',
  props: {
    task: {
      type: Object,
      require: true
    }
  }

}
</script>

<style scoped>
</style>
