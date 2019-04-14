/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author Tassio
 */
public class login {

    private String login;
    private String senha;

    public login() {
        this.login = "admin";
        this.senha = "admin123";
    }

    public boolean validarLogin(String login) {

        if (login.trim().length() > 0 && senha.trim().length() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean validarSenha(String senha) {
        if (senha.length() > 6 && senha.length() < 12) {
            return true;
        } else {
            return false;
        }
    }

    public boolean autenticar(String login, String senha) {
        if (login.equalsIgnoreCase("admin") && senha.equalsIgnoreCase("admin123")) {
            return true;
        } else {
            return false;
        }
    }
}
