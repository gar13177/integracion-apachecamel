
package org.apache.camel.example.facebooktwitter;
import org.apache.camel.main.Main;

/**
 * A main to start this example.
 */
public final class CamelTwitterWebSocketMain {

    //Twitter
    private static String consumerKey = Keys.consumerKey;
    private static String consumerSecret = Keys.consumerSecret;
    private static String accessToken = Keys.accessToken;
    private static String accessTokenSecret = Keys.accessTokenSecret;
    
    //Facebook
    private static String OAuthAppId = Keys.OAuthAppId;
    private static String OAuthAppSecret = Keys.OAuthAppSecret;
    
    private CamelTwitterWebSocketMain() {
        // 
    }

    public static void main(String[] args) throws Exception {

        // Crear un main de Camel
        Main main = new Main();

        TwitterFacebookRoute route = new TwitterFacebookRoute();

        // Colocar las llaves de acceso de twitter
        route.setAccessToken(accessToken);
        route.setAccessTokenSecret(accessTokenSecret);
        route.setConsumerKey(consumerKey);
        route.setConsumerSecret(consumerSecret);
        
        // Colocar llaves de facebook
        route.setOAuthAppId(OAuthAppId);
        route.setOAuthAppSecret(OAuthAppSecret);
        
        // agregar paginas de facebbok
        route.addFacebookId("9gag");
        route.addFacebookId("IFeakingLoveScience");
        route.addFacebookId("trustmestore");
        

        // add our routes to Camel
        main.addRouteBuilder(route);

        // and run, which keeps blocking until we terminate the JVM (or stop CamelContext)
        main.run();
    }

}
