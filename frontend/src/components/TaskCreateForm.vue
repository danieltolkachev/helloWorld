<template>
  <div>
    <button type="button" class="btn btn-success sticky-button" data-bs-toggle="offcanvas"
            data-bs-target="#task-create-offcanvas" aria-controls="#task-create-offcanvas">Add Task
      <i class="bi bi-task-plus-fill"></i>
    </button>
    <div class="offcanvas offcanvas-end" tabindex="-1" id="task-create-offcanvas" aria-labelledby="offcanvas-label">
      <div class="offcanvas-header">
        <h5 id="offcanvas-label">New Task</h5>
      </div>
      <div class="offcanvas-body">
        <form class="text-start needs-validation" id="task-create-form" novalidate>
          <div class="mb-3">
            <label for="title" class="form-label">Task Title: </label>
            <input type="text" class="form-control" id="title" v-model="taskTitle" required>
            <div class="invalid-feedback">
              Please enter a Task Title
            </div>
          </div>
          <div class="mb-3">
            <label for="description" class="form-label">Task Description: </label>
            <input type="text" class="form-control" id="description" v-model="description" required>
            <div class="invalid-feedback">
              Please enter a Task Description
            </div>
          </div>
          <div class="mb-3">
            <div class="form-check">
              <input class="form-check-input" type="checkbox" id="Favorite" v-model="favorite">
              <label class="form-check-label" for="Favorite">
                Favorite?
              </label>
            </div>
          </div>
          <div v-if="this.serverValidationMessages">
            <ul>
              <li v-for="(message, index) in serverValidationMessages" :key="index" style="color: red">
                {{ message }}
              </li>
            </ul>
          </div>
          <div class="mt-5">
            <button class="btn btn-primary me-3 text-reset" type="submit" @click.prevent="createTask">Create</button>
            <button class="btn btn-danger text-reset" type="reset">Reset</button>
          </div>
        </form>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'TaskCreateForm',
  data () {
    return {
      taskTitle: '',
      description: '',
      favorite: false,
      serverValidationMessages: []
    }
  },

  emits: ['created'],
  methods: {
    async createTask () {
      const valid = this.validate()
      if (valid) {
        const endpoint = 'http://localhost:8080/api/v1/task'

        const headers = new Headers()
        headers.append('Content-Type', 'application/json')

        const task = JSON.stringify({
          title: this.taskTitle,
          description: this.description,
          favorite: this.favorite
        })

        const requestOptions = {
          method: 'POST',
          header: headers,
          body: task,
          redirect: 'follow'
        }

        const response = await fetch(endpoint, requestOptions)
        await this.handleResponse(response)
      }
    },
    async handleResponse (response) {
      if (response.ok) {
        this.$emit('created', response.headers.get('location'))
        document.getElementById('close-offcanvas').click()
      } else if (response.status === 400) {
        response = await response.json()
        response.errors.forEach(error => {
          error.defaultMessage = undefined
          this.serverValidationMessages.push(error.defaultMessage)
        })
      } else {
        this.serverValidationMessages.push('Unknown error occurred')
      }
    },
    validate () {
      const form = document.getElementById('task-create-form')
      form.classList.add('was-validated')
      return form.checkValidity()
    }
  }
}
</script>
<style scoped>
</style>
