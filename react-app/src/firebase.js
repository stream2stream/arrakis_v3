// Import the functions you need from the SDKs you need
import { initializeApp } from "firebase/app";
import { getAnalytics } from "firebase/analytics";
import { getAuth } from "firebase/auth";
// TODO: Add SDKs for Firebase products that you want to use
// https://firebase.google.com/docs/web/setup#available-libraries

// Your web app's Firebase configuration
// For Firebase JS SDK v7.20.0 and later, measurementId is optional
const firebaseConfig = {
    apiKey: "AIzaSyB-VkMHcni_AjkWGEZAlw1SzQ4_SM_O1og",
    authDomain: "just-bonds.firebaseapp.com",
    projectId: "just-bonds",
    storageBucket: "just-bonds.appspot.com",
    messagingSenderId: "807524564122",
    appId: "1:807524564122:web:41cd4516f6a1e159907323",
    measurementId: "G-BBNBPK4RRF"
};

// Initialize Firebase
const app = initializeApp(firebaseConfig);
const analytics = getAnalytics(app);

export const auth = getAuth(app);
export default app;
