Requirements
============

Java 1.5 and later.

Installation
============

### Maven users

Add this dependency to your project's POM:

    <dependency>
      <groupId>com.shirtsio</groupId>
      <artifactId>shirtsio-lib</artifactId>
    </dependency>

Usage
=====

ShirtsioExample.java

    import com.shirtsio.model.Authentication;
    import com.shirtsio.AuthenticationManager;

    public class ShirtsioExample {

        public static void main(String[] args) {
            AuthenticationManager authenticationManager = new AuthenticationManager();
            Authentication authentication = authenticationManager.authenticate("deantest", "Pa$$w0rd");

            System.out.println(authentication.getApiKey());
        }
    }
