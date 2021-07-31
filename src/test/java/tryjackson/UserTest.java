package tryjackson;

import org.junit.jupiter.api.Test;

import java.io.*;

import static org.assertj.core.api.Assertions.assertThat;

class UserTest {


    @Test
    void serializeToFile() throws IOException, ClassNotFoundException {
        User user = new User();
        user.setId(1);
        user.setName("Maria");

        String filePath = "src/test/resources/protocols/user.txt";

        FileOutputStream fileOutputStream = new FileOutputStream(filePath);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(user);

        FileInputStream fileInputStream = new FileInputStream(filePath);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        User deserializedUser = (User) objectInputStream.readObject();

        assertThat(deserializedUser.getId()).isEqualTo(1);
        assertThat(deserializedUser.getName()).isEqualTo("Maria");
    }
}
