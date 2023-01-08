<template>
      <div class="card h-100">
        <h5 class="card-header">{{ task.title }}</h5>
        <div class="card-body">
          <p class="card-text">{{ task.description }}</p>
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
