<template>
  <div>
    <StudentTable :students="students" @add="showAddForm" @edit="editStudent" @delete="deleteStudent" />
    <StudentForm v-if="showForm" :student="selectedStudent" :isEdit="isEdit" @complete="handleFormSubmit" />
  </div>
</template>

<script>
import StudentTable from '../components/StudentTable.vue';
import StudentForm from '../components/StudentForm.vue';
import { getStudents, addStudent, updateStudent, deleteStudent } from '../services/api';

export default {
  components: { StudentTable, StudentForm },
  data() {
    return {
      students: [],
      showForm: false,
      selectedStudent: { name: '', age: '', sexuality: '' },
      isEdit: false,
    };
  },
  methods: {
    async fetchStudents() {
      const { data } = await getStudents();
      this.students = data;
    },
    showAddForm() {
      this.selectedStudent = { name: '', age: '', sexuality: '' };
      this.isEdit = false;
      this.showForm = true;
    },
    editStudent(student) {
      this.selectedStudent = { ...student };
      this.isEdit = true;
      this.showForm = true;
    },
    async deleteStudent(id) {
      await deleteStudent(id);
      this.fetchStudents();
    },
    async handleFormSubmit(student) {
      if (this.isEdit) {
        await updateStudent(student.studentId, student);
      } else {
        await addStudent(student);
      }
      this.fetchStudents();
      this.showForm = false;
    },
  },
  mounted() {
    this.fetchStudents();
  },
};
</script>
s
