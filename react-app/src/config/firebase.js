// export const hostNameUrl = "https://<PROJECT-ID>.<REGION>.r.appspot.com";
// Import the functions you need from the SDKs you need
import { initializeApp } from "firebase/app";
import {getAuth, setPersistence, browserLocalPersistence} from 'firebase/auth'
// TODO: Add SDKs for Firebase products that you want to use
// https://firebase.google.com/docs/web/setup#available-libraries

// Your web app's Firebase configuration
// For Firebase JS SDK v7.20.0 and later, measurementId is optional
const firebaseConfig = {
    apiKey: "AIzaSyAykhDo5zanmBcB-LsNjN0UORy9oGo6GX4",
    authDomain: "web-arkkis.firebaseapp.com",
    projectId: "web-arkkis",
    storageBucket: "web-arkkis.appspot.com",
    messagingSenderId: "33033977537",
    appId: "1:33033977537:web:1a894d360bb78d469a9e40",
    measurementId: "G-R72079D9WV"
};
const app = initializeApp(firebaseConfig);
let auth = getAuth(app);
await setPersistence(auth,browserLocalPersistence);
export default auth;


