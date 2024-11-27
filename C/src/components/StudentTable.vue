<template>
  <div>
    <button @click="showAddForm">Add Student</button>
    <table>
      <thead>
        <tr>
          <th>ID</th>
          <th>Name</th>
          <th>Age</th>
          <th>Sexuality</th>
          <th>Actions</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="student in students" :key="student.studentId">
          <td>{{ student.studentId }}</td>
          <td>{{ student.name }}</td>
          <td>{{ student.age }}</td>
          <td>{{ student.sexuality }}</td>
          <td>
            <button @click="editStudent(student)">Edit</button>
            <button @click="confirmDelete(student.studentId)">Delete</button>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
export default {
  props: ['students'],
  methods: {
    showAddForm() {
      this.$emit('add');
    },
    editStudent(student) {
      this.$emit('edit', student);
    },
    confirmDelete(id) {
      if (confirm('Are you sure you want to delete this student?')) {
        this.$emit('delete', id);
      }
    },
  },
};
</script>

<style scoped>
table {
  width: 100%;
  border-collapse: collapse;
  margin-top: 20px;
}
th,
td {
  border: 1px solid #ddd;
  padding: 8px;
  text-align: left;
}
</style>
