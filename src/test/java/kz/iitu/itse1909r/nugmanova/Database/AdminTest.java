package kz.iitu.itse1909r.nugmanova.Database;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

class AdminTest {
    Admin admin = new Admin("email", "password");

    @Test
    void testToString() {
        String result = admin.toString();
        Assertions.assertEquals("ADMIN INFO: email password", result);
    }

    @Test
    void testSetAdminId() {
        admin.setAdminId(Integer.valueOf(0));
    }

    @Test
    void testSetEmail() {
        admin.setEmail("email");
    }

    @Test
    void testSetPassword() {
        admin.setPassword("password");
    }

    @Test
    void testEquals() {
        boolean result = admin.equals("o");
        Assertions.assertNotNull(result);
    }

    @Test
    void testCanEqual() {
        boolean result = admin.canEqual("other");
        Assertions.assertNotNull(result);
    }

    @Test
    void testHashCode() {
        ReflectionTestUtils.setField(admin, "email", "aaa");
        ReflectionTestUtils.setField(admin, "password", "aaa");
        int result = admin.hashCode();
        Assertions.assertEquals(6134322, result);
    }
}