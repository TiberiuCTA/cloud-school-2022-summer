@ActiveRecord(tableName = "command", primaryKeyName = "id")
public class Command extends Entity {
    int id;
    String description;
    int user_id;

    public Command() {
    }

    public Command(String description, int user_id) {
        this.description = description;
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Command{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", user_id=" + user_id +
                '}';
    }
}
