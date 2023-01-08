<template>
  <div class="container-fluid">
    <task-card-list :tasks="this.tasks"></task-card-list>
  </div>
  <div id="buttonAdd"><task-create-form @created="addTask"></task-create-form></div>

</template>

<script>

import TaskCreateForm from '@/components/TaskCreateForm'
import TaskCardList from '@/components/TaskCardList'

export default {
  name: 'TaskView',
  components: {
    TaskCardList,
    TaskCreateForm
  },
  data () {
    return {
      tasks: []
    }
  },
  methods: {
    addTask (taskLocation) {
      const endpoint = 'http://localhost:8080/api/v1/task' + taskLocation
      const requestOptions = {
        method: 'GET',
        redirect: 'follow'
      }

      fetch(endpoint, requestOptions)
        .then(response => response.json())
        .then(task => this.tasks.push(task))
        .catch(error => console.log('error', error))
    }
  },
  mounted () {
    const endpoint = 'http://localhost:8080/api/v1/task'
    const requestOptions = {
      method: 'GET',
      redirect: 'follow'
    }
    fetch(endpoint, requestOptions)
      .then(response => response.json())
      .then(result => result.forEach(task => {
        this.tasks.push(task)
      }))
      .catch(error => console.log('error', error))
  }
}
</script>
<style scoped>

#buttonAdd{
  margin-top:20px;
}
</style>
