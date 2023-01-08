<template>
  <div class="row row-cols-xl-4 row-cols-lg-3 row-cols-md-2 row-cols-sm-1 g-4">
    <div class="col-sm" v-for="task in tasks" :key="task.id">
      <task-card :task="task"></task-card>
    </div>
  </div>
</template>

<script>
import TaskCard from '@/components/TaskCard'

export default {
  name: 'TaskCardList',
  components: { TaskCard },
  props: {
    tasks: {
      type: Array,
      required: true
    }
  }
}

</script>

<style scoped>
</style>
