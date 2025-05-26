// AuthService.java
public class AuthService {
    // Usuarios “hardcodeados” por ahora
    private static final String USER = "admin";
    private static final String PASS = "1234";

    public static boolean validar(String usuario, String contrasena) {
        return usuario.equals(USER) && contrasena.equals(PASS);
    }
}
