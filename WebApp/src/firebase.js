import { initializeApp } from "firebase/app";
import "firebase/compat/auth";

const firebaseConfig = {
  apiKey: "AIzaSyCDM9-btpFVFJxga4s66DazZWgFgfYzyPk",
  authDomain: "weblogin-33efe.firebaseapp.com",
  projectId: "weblogin-33efe",
  storageBucket: "weblogin-33efe.appspot.com",
  messagingSenderId: "975267844894",
  appId: "1:975267844894:web:2423ef03f8fba510f6af0f"
};

// Initialize Firebase
const app = initializeApp(firebaseConfig);
export default app;