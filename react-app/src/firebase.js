import { initializeApp } from "firebase/app";
import { getAnalytics } from "firebase/analytics";
import { getAuth } from "firebase/auth"
// TODO: Add SDKs for Firebase products that you want to use
// https://firebase.google.com/docs/web/setup#available-libraries

// Your web app's Firebase configuration
// For Firebase JS SDK v7.20.0 and later, measurementId is optional
const firebaseConfig = {
    apiKey: "AIzaSyBqJaeAoRU7yZQduOqqDtd8t3pL_ORiRFM",
    authDomain: "db-challenge-t11.firebaseapp.com",
    projectId: "db-challenge-t11",
    storageBucket: "db-challenge-t11.appspot.com",
    messagingSenderId: "179940941606",
    appId: "1:179940941606:web:cea2e7713883b21364abe7",
    measurementId: "G-6TSWWEK0KJ"
};

// Initialize Firebase
const app = initializeApp(firebaseConfig);
const analytics = getAnalytics(app);

// Initialize Firebase Authentication and get a reference to the service
export const auth = getAuth(app);
export default app;

