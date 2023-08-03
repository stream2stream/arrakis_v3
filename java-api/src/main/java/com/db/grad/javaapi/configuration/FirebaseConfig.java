/*
package com.db.grad.javaapi.configuration;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.context.annotation.Configuration;
import javax.annotation.PostConstruct;
import java.io.FileInputStream;

    @Configuration //TODO: Firebase Stub
    public class FirebaseConfig {

        @PostConstruct
        public void initialize() {
            try {
                FileInputStream serviceAccount = new FileInputStream("java-api/src/main/resources/KEYFirebaseAdminSDK.json");

                FirebaseOptions options = new FirebaseOptions.Builder()
                        .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                        .build();

                FirebaseApp.initializeApp(options);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

*/
