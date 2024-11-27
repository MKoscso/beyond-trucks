public class Task {
  private final int id;
  private final String description;

  public Task(int id, String description) {
      this.id = id;
      this.description = description;
  }

  public int getId() {
      return id;
  }

  public String getDescription() {
      return description;
  }

  @Override
  public String toString() {
      return "Task{" +
              "id=" + id +
              ", description='" + description + '\'' +
              '}';
  }
}
